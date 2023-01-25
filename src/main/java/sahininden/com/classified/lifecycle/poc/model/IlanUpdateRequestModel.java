package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;
@ApiModel(value ="Ilan Güncelleme Modeli", description ="İlan içinde bulunan statü alanı yani aktif deaktif onayda gibi durumları güncellemek için model.")
public class IlanUpdateRequestModel {
	private long id;
	private Boolean onay;

	public IlanUpdateRequestModel(long id, Boolean onay) {
		this.id = id;
		this.onay = onay;
	}
	public IlanUpdateRequestModel() {};
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

	@Override
	public String toString() {
		return "IlanUpdateRequestModel{" +
				"id=" + id +
				", onay=" + onay +
				'}';
	}
}
