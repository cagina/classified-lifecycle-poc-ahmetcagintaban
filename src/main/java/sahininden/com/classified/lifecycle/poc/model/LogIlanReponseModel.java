package sahininden.com.classified.lifecycle.poc.model;

import java.time.Instant;

public class LogIlanReponseModel {
	private String oldValue;
	private String newValue;
	private Long ilanId;
	private Instant createdDate;

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Long getIlanId() {
		return ilanId;
	}

	public void setIlanId(Long ilanId) {
		this.ilanId = ilanId;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public LogIlanReponseModel(String oldValue, String newValue, Long ilanId, Instant createdDate) {
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.ilanId = ilanId;
		this.createdDate = createdDate;
	}
}
