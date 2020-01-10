package com.microservices.salesorderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CustomerSOS {

	@Id
	@Column(name="cust_id")
	@JsonProperty("id")
	private Long customerId;
	
	@Column(name="cust_first_name")
	@JsonProperty("firstName")
	private String custFirstName;
	
	@Column(name="cust_last_name")
	@JsonProperty("lastName")
	private String custLastName;
	
	@Column(name="cust_email")
	@JsonProperty("email")
	private String custEmail;

	
	public CustomerSOS() {
		super();
	}

	public CustomerSOS(Long customerId, String custFirstName, String custLastName, String custEmail) {
		super();
		this.customerId = customerId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
	}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerSOS [customerId=" + customerId + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custEmail=" + custEmail + "]";
	}
	
}
