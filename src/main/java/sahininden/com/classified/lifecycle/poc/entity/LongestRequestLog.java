package sahininden.com.classified.lifecycle.poc.entity;

import javax.persistence.*;

@Entity
@Table(name = "longest_request_log")
public class LongestRequestLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "request")
	private String request;
	@Column(name = "response")
	private String response;
	@Column(name = "execute_time")
	private long executeTime;
	@Column(name = "method_name")
	private String method;

	public String getRequest() {
		return request;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public long getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(long executeTime) {
		this.executeTime = executeTime;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public LongestRequestLog(String request, String response, long executeTime, String method) {
		this.request = request;
		this.response = response;
		this.executeTime = executeTime;
		this.method = method;
	}
	public LongestRequestLog() {};
}
