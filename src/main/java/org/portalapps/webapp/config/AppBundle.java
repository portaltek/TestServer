package org.portalapps.webapp.config;

import java.util.Locale;

import org.portalapps.webapp.exception.I18n;
import org.springframework.context.support.ResourceBundleMessageSource;

public class AppBundle extends ResourceBundleMessageSource {
	

	
	public String get(String key, Locale locale) {
		return getMessage(key, null, locale);
	}

	public String get(I18n errorCode, Locale locale) {
		String key = errorCode.getClass().getSimpleName();
		key += "." + errorCode.toString();
		return getMessage(key, null, locale);
	}
	
//	public void info(String message){
//		log.info(getError(4)+"|" + message);
//	}
//	public void error(String message){
//		log.error(getError(4)+"|" + message);
//	}	
//
//	public String getError(int depth) {
//		String fullClassName = Thread.currentThread().getStackTrace()[depth].getClassName();
//		String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
//		String methodName = Thread.currentThread().getStackTrace()[depth].getMethodName();
//		int lineNumber = Thread.currentThread().getStackTrace()[depth].getLineNumber();
//		return className + "." + methodName + ":" + lineNumber;
//	}
}
