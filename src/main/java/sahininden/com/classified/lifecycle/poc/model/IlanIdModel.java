package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value ="Ilan ID Model", description ="Ön yüzde seçilen ilanin apiye gönderim modeli.")
public class IlanIdModel {
	private long ilanId;

	public long getIlanId() {
		return ilanId;
	}

	public void setIlanId(long ilanId) {
		this.ilanId = ilanId;
	}

	public IlanIdModel(long ilanId) {
		this.ilanId = ilanId;
	}

	public IlanIdModel() {	}

	@Override
	public String toString() {
		return "IlanIdModel{" +
				"ilanId=" + ilanId +
				'}';
	}
}
