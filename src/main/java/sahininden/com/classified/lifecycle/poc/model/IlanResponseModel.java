package sahininden.com.classified.lifecycle.poc.model;

public class IlanResponseModel {
	private String title;
	private String description;
	private String category;
	private String status;
	private Long Id;
	public IlanResponseModel(String title, String description, String category, String status, Long id) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		Id = id;
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
}
