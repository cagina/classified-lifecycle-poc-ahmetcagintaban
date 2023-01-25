package sahininden.com.classified.lifecycle.poc.entity;

import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "log_ilan_table")
public class LogIlanTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "ilan_id")
	private long ilanId;

	@Column(name = "old_value")
	private String oldValue;

	@Column(name = "new_value")
	private String newValue;

	@Column(name = "created_Date")
	private Timestamp createdDate = Timestamp.from(Instant.now());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIlanId() {
		return ilanId;
	}

	public void setIlanId(long ilanId) {
		this.ilanId = ilanId;
	}

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public LogIlanTable(long ilanId, String oldValue, String newValue) {
		this.ilanId = ilanId;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public LogIlanTable() {};
}
