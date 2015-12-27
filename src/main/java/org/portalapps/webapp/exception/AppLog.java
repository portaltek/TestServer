package org.portalapps.webapp.exception;

import java.util.Locale;

import net.sf.json.JSONObject;

public class AppLog {
	private JSONObject json = new JSONObject();
	private String userMsg;
	private String logMsg;
	private SystemException exception;
	private String unknownException;
	private I18n i18n;
	private Locale locale;

	public AppLog(Locale locale) {
		this.locale = locale;
	}

	public AppLog(String userMsg, String logMsg, Locale locale) {
		this.userMsg = userMsg;
		this.logMsg = logMsg;
		this.locale = locale;
	}

	public AppLog(JSONObject json, String userMsg, String logMsg, Locale locale) {
		this.json = json;
		this.userMsg = userMsg;
		this.logMsg = logMsg;
		this.locale = locale;
	}

	public AppLog(JSONObject json, String userMsg, String logMsg, SystemException exception, Locale locale) {
		this.json = json;
		this.userMsg = userMsg;
		this.logMsg = logMsg;
		this.exception = exception;
	}

	public I18n getI18n() {
		return i18n;
	}

	public AppLog setI18n(I18n i18n) {
		this.i18n = i18n;
		return this;
	}

	public Locale getLocale() {
		return locale;
	}

	public AppLog setLocale(Locale locale) {
		this.locale = locale;
		return this;
	}

	public SystemException getException() {
		return exception;
	}

	public AppLog setException(SystemException exception) {
		this.exception = exception;
		return this;
	}

	public JSONObject getJson() {
		return json;
	}

	public AppLog setJson(JSONObject json) {
		this.json = json;
		return this;
	}

	public String getUserMsg() {
		return userMsg;
	}

	public AppLog setUserMsg(String userMsg) {
		this.userMsg = userMsg;
		return this;
	}

	public String getLogMsg() {
		return logMsg;
	}

	public AppLog setLogMsg(String logMsg) {
		this.logMsg = logMsg;
		return this;
	}

	public String getUnknownException() {
		return unknownException;
	}

	public AppLog setUnknownException(String unknownException) {
		this.unknownException = unknownException;
		return this;
	}
	

}
