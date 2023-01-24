package sahininden.com.classified.lifecycle.poc.enums;

public enum IlanStatus {
	AKTIF("Aktif"),
	ONAYDA("Onay Bekliyor"),
	DEAKTIF("Deaktif");
	private final String value;
	IlanStatus(String value) {
	this.value = value;
	}

	public String getValue() {
		return value;
	}
}
