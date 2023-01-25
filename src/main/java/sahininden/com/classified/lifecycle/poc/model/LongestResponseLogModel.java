package sahininden.com.classified.lifecycle.poc.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value ="Uzun süren isteklerin Log Modeli", description ="5 ms uzun süren responseları logların modeli")
public class LongestResponseLogModel {
	private String request;
	private String response;
	private long executeTime;
	private String method;

	public String getRequest() {
		return request;
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

	public LongestResponseLogModel(String request, String response, long executeTime, String method) {
		this.request = request;
		this.response = response;
		this.executeTime = executeTime;
		this.method = method;
	}

	public LongestResponseLogModel() {};
}
