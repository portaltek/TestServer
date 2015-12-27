package org.portalapps.webapp.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.portalapps.webapp.config.AppBundle;
import org.portalapps.webapp.exception.AppLog;
import org.portalapps.webapp.exception.SystemException;
import org.springframework.stereotype.Service;

@Service("loggingService")
public class LoggingService {

	public static final String DEBUG = "DEBUG";
	public static final String PRODUCTION = "PRODUCTION";
	public static final String RESULT = "RESULT";
	public static final String MSG = "MSG";
	public static final String UNKNOWN = "UNKNOWN";	
	public static final String MODE = DEBUG;

	static final Logger log = LogManager.getLogger();

	@Resource
	protected AppBundle bundle;

	public void log(AppLog appLog) {
		if (MODE == DEBUG) {
			// System.out.println(appLog.getLogMsg());
		}
	}

	public void info(AppLog appLog) {
		appLog.setUserMsg(bundle.get(appLog.getI18n(), appLog.getLocale()));
		appLog.getJson().put(RESULT, "OK");
		appLog.getJson().put(MSG, appLog.getUserMsg());
		String logMsg = appLog.getUserMsg();
		logMsg += "|" + appLog.getLogMsg();
		appLog.setLogMsg(logMsg);
		log(appLog);
		log.info(appLog.getLogMsg());
	}

	public void getUserMsg(AppLog appLog) {
		SystemException e = appLog.getException();
		String key = "";
		String unknownException = "";
		if (e instanceof SystemException && e.getErrorCode() != null) { // Known
			// if (e.getErrorCode() == null) { // Unknown error
			key = e.getErrorCodeString();
		} else { // Unknown error
			key = e.getCause().getClass().getSimpleName();
			unknownException = "-" + key;
		}
		String userMsg = bundle.get(key, appLog.getLocale());
		if (key.equals(userMsg)) {
			userMsg = bundle.get(UNKNOWN, appLog.getLocale());
		}
		appLog.setUserMsg(userMsg).setUnknownException(unknownException);

	}

	public void warn(AppLog appLog) {
		getUserMsg(appLog);
		appLog.getJson().put(RESULT, "ERROR");
		appLog.getJson().put(MSG, appLog.getUserMsg());
		String logMsg = appLog.getException().getErrorLine() + appLog.getUnknownException();
		logMsg += "|" + appLog.getUserMsg();
		logMsg += "|" + appLog.getLogMsg();
		appLog.setLogMsg(logMsg);
		log(appLog);
		log.warn(appLog.getLogMsg());
	}

	public void error(AppLog appLog) {

		getUserMsg(appLog);
		appLog.getJson().put(RESULT, "ERROR");
		appLog.getJson().put(MSG, appLog.getUserMsg());
		String logMsg = appLog.getException().getErrorLine() + appLog.getUnknownException();
		logMsg += "|" + appLog.getUserMsg();
		logMsg += "|" + appLog.getLogMsg();
		appLog.setLogMsg(logMsg);
		log(appLog);
		log.error(appLog.getLogMsg());

	}

}
