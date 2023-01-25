package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;

import java.time.Instant;
@ApiModel(value ="Ilan Response Model", description ="Ön yüze dönen ilan bilgilerinin modeli.")
public class IlanResponseModel {
	private String title;
	private String description;
	private String category;
	private String status;
	private Long Id;
	private Instant expiryDate;
	public Instant getExpiryDate() {
		return expiryDate;
	}
	private Boolean repeated;

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Boolean getRepeated() {
		return repeated;
	}

	public void setRepeated(Boolean repeated) {
		this.repeated = repeated;
	}

	public IlanResponseModel(String title, String description, String category, String status, Long id, Instant expiryDate, Boolean repeated) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		Id = id;
		this.expiryDate = expiryDate;
		this.repeated = repeated;
	}
}
