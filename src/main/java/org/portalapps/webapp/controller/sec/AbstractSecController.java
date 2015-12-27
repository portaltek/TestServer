package org.portalapps.webapp.controller.sec;

import java.util.Locale;

import javax.annotation.Resource;

import org.portalapps.webapp.config.AppBundle;
import org.portalapps.webapp.exception.I18n;
import org.portalapps.webapp.exception.SystemException;
import org.portalapps.webapp.service.LoggingService;
import org.springframework.context.MessageSource;

import net.sf.json.JSONObject;

public abstract class AbstractSecController {

	@Resource
	protected AppBundle bundle;

	@Resource
	protected MessageSource messageSource;

	@Resource
	protected LoggingService log;

	public void log(SystemException e, JSONObject json, Locale locale) {

		json.put("RESULT", "ERROR");
		json.put("ERROR_KEY", e.getMessage());
		e.printStackTrace();
	}

	public String bundle(I18n errorCode, Locale locale) {
		String key = errorCode.getClass().getSimpleName();
		key += "." + errorCode.toString();
		return messageSource.getMessage(key, null, locale);
	}

	public String bundle(String key, Locale locale) {
		return messageSource.getMessage(key, null, locale);
	}

}
