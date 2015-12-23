package org.portalapps.webapp.controller.sec;

import java.util.List;

import javax.annotation.Resource;

import org.portalapps.webapp.dao.sec.SecSystemDao;
import org.portalapps.webapp.dto.sec.SecSystem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
// @RestController
@RequestMapping("/mantto/secSystem")
@Transactional("secEntityTransactionManager")
public class SecSystemController {

	@Resource
	SecSystemDao dao;

	@RequestMapping(value = { "/" })
	public String main(ModelMap m) {
		m.put("title", "Spring Security Custom Login Form");
		m.put("message", "This is welcome page!");
		m.put("list", dao.findAll());
		return "mantto/secSystem/main";
	}

	// @RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
	// public void insert(ModelMap m,
	// @ModelAttribute("entity") SecSystem secSystem) {
	// m.put("title", "Spring Security Custom Login Form");
	// m.put("message", "This is welcome page!");
	// m.put("list", dao.findAll());
	//
	// }

	// @ResponseBody
	// @RequestMapping(value = { "/insert" })
	// public ResponseEntity<String> insert(ModelMap m) {
	// JSONObject json = new JSONObject();
	// m.put("title", "Spring Security Custom Login Form");
	// m.put("message", "This is welcome page!");
	// m.put("list", dao.findAll());
	// json.put("m", m);
	// return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	//
	// } Re*34pdse

	@ResponseBody
	@RequestMapping(value = "/insert")
	public ResponseEntity<String> insert(
@ModelAttribute("secSystem") SecSystem s
	) {
		JSONObject json = new JSONObject();
		List<SecSystem> list = dao.findAll();

		if (list.isEmpty()) {
			return new ResponseEntity<String>(json.toString(), HttpStatus.NO_CONTENT);
		}

		json.put("LIST", list);
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
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
