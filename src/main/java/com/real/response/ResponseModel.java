package com.real.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseModel {

	private String responseCode;
	private String responseDescription;
	private Object responseObject;

	public ResponseModel() {

	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public ResponseModel(String responseCode, String responseDescription, Object responseObject) {

		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.responseObject = responseObject;
	}

}
