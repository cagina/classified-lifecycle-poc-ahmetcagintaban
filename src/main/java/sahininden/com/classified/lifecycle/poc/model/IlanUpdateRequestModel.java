package sahininden.com.classified.lifecycle.poc.model;

import javax.persistence.Id;

public class IlanUpdateRequestModel {
	private long id;
	private Boolean onay;

	public IlanUpdateRequestModel(long id, Boolean onay) {
		this.id = id;
		this.onay = onay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getOnay() {
		return onay;
	}

	public void setOnay(Boolean onay) {
		this.onay = onay;
	}
}
