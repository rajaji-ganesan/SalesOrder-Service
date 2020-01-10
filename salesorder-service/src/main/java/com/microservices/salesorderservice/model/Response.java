package com.microservices.salesorderservice.model;

/**
 * @author 474984
 *
 */

public class Response<T> {

	private static final String R_MSG_EMPTY = "";
	private static final String R_CODE_OK = "OK";

	private String responseCode;

	private String responseMessage;

	private T response;

	public Response(String responseCode, String responseMessage) {
		this.responseCode = responseCode == null ? Response.R_CODE_OK : responseCode;
		this.responseMessage = responseMessage == null ? Response.R_MSG_EMPTY : responseMessage;
		this.response = null;
	}

	public Response() {}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getResponse() {
		return this.response;
	}

	public Response<T> setResponse(final T obj) {
		this.response = obj;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", response="
				+ response + "]";
	}


}
