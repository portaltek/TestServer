package org.portalapps.webapp.exception;

public enum SecSystemMsg implements I18n {

	RECORD_INSERTED(10000), RECORD_UPDATED(10001), RECORD_DELETED(10002), RECORD_FOUND(100003);

	private final int number;

	private SecSystemMsg(int number) {
		this.number = number;
	}

	@Override
	public int getNumber() {
		return number;
	}

	public enum err {
		DUPLICATED_RECORD, FOREING_KEY_NOT_FOUNDED;
	}

}
