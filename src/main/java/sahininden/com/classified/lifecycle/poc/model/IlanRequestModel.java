package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value ="Ilan Yaratma Modeli", description ="İlan oluşturmak için gerekli alanları içerir.")
public class IlanRequestModel {
	@ApiModelProperty(value="İlan başlık Alanı", required = true)
	private String title;
	@ApiModelProperty(value="İlan Açıklama Alanı", required = true)
	private String description;
	@ApiModelProperty(value="İlan Kategori Alanı Tipleri (EMLAK, VASITA, ALISVERIS, DIGER) diğer girişler engellenmiştir.", required = true)
	private String category;
	public IlanRequestModel(String title, String description, String category, String status) {
		this.title = title;
		this.description = description;
		this.category = category;
	}
	public IlanRequestModel() {};
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

	@Override
	public String toString() {
		return "IlanRequestModel{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", category='" + category + '\'' +
				'}';
	}
}
