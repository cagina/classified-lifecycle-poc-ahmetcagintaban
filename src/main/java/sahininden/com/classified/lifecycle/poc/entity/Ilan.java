package sahininden.com.classified.lifecycle.poc.entity;

import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;
import sahininden.com.classified.lifecycle.poc.enums.IlanStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "Ilan")
public class Ilan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private IlanCategory category;

	@Column(name = "status")
	private IlanStatus status;

	@Column(name = "created_Date")
	private Timestamp createdDate = Timestamp.from(Instant.now());

	@Column(name = "expiry_Date")
	private Timestamp expiryDate;

	@Column(name = "repeated")
	private Boolean repeated;
	public Ilan() {};

	public Boolean getRepeated() {
		return repeated;
	}

	public void setRepeated(Boolean repeated) {
		this.repeated = repeated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public IlanCategory getCategory() {
		return category;
	}

	public void setCategory(IlanCategory category) {
		this.category = category;
	}

	public IlanStatus getStatus() {
		return status;
	}

	public void setStatus(IlanStatus status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Ilan(String title, String description, IlanCategory category, IlanStatus status, Timestamp expiryDate, Boolean repeated) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.expiryDate = expiryDate;
		this.repeated = repeated;
	}
}
