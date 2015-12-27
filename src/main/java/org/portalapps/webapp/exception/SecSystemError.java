package org.portalapps.webapp.exception;

public enum SecSystemError implements I18n {

	DUPLICATED_RECORD(-10000), FOREING_KEY_NOT_FOUNDED(-10001);

	private final int number;

	private SecSystemError(int number) {
		this.number = number;
	}

	@Override
	public int getNumber() {
		return number;
	}

}
