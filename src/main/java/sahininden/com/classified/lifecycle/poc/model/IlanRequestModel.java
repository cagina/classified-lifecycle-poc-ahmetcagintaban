package sahininden.com.classified.lifecycle.poc.model;

public class IlanRequestModel {
	private String title;
	private String description;
	private String category;
	public IlanRequestModel(String title, String description, String category, String status) {
		this.title = title;
		this.description = description;
		this.category = category;
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
}
