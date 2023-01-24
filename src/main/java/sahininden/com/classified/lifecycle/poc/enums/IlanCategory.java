package sahininden.com.classified.lifecycle.poc.enums;

public enum IlanCategory {
	EMLAK("Emlak"),
	VASITA("Vasıta"),
	ALISVERIS("Alışveriş"),
	DIGER("Diğer");
	private final String value;
	IlanCategory(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
