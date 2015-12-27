package org.portalapps.webapp.controller.sec;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.portalapps.webapp.dao.sec.SecSystemDao;
import org.portalapps.webapp.dto.sec.SecSystem;
import org.portalapps.webapp.exception.AppLog;
import org.portalapps.webapp.exception.SecSystemError;
import org.portalapps.webapp.exception.SecSystemMsg;
import org.portalapps.webapp.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/mantto/secSystem")
public class SecSystemController extends AbstractSecController {

	@Resource
	SecSystemDao dao;

	@ModelAttribute("secSystem")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView main(ModelMap m) {
		m.put("title", "Spring Security Custom Login Form");
		m.put("message", "This is welcome page!!!");
		m.put("list", dao.findAll());

		// return ;
		return new ModelAndView("mantto/secSystem/main", "secSystem", new SecSystem());
	}

	@ResponseBody
	@RequestMapping(value = "/insert")
	public ResponseEntity<String> insert(@ModelAttribute("secSystem") SecSystem s, Locale locale) throws Exception {
		AppLog applog = new AppLog(locale);
		try {
			if (dao.exist(s.getSystemId())) { // 3
				throw SystemException.get(SecSystemError.DUPLICATED_RECORD);
			}
			// throw new Exception(); //1
			dao.insert(s); // 2
			applog.setI18n(SecSystemMsg.RECORD_INSERTED).setLogMsg(s.toString());
			log.info(applog); // 4
		} catch (SystemException e) {
			applog.setException(e).setLogMsg(s.toString());
			log.warn(applog);
		} catch (Exception e) {
			applog.setException(SystemException.wrap(e)).setLogMsg(s.toString());
			log.error(applog);
		}
		return new ResponseEntity<String>(applog.getJson().toString(), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> findAll() {
		JSONObject json = new JSONObject();
		List<SecSystem> list = dao.findAll();

		if (list.isEmpty()) {
			return new ResponseEntity<String>(json.toString(), HttpStatus.NO_CONTENT);
		}

		json.put("LIST", list);
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}

}
