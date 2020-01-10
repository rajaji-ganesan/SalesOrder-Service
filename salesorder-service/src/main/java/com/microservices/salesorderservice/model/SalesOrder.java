/**
 * 
 */
package com.microservices.salesorderservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 474984
 *
 */
@Entity
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="order_id")
	private Long id;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="order_desc")
	private String orderDesc;
	
	@Column(name="total_price")
	private String totalPrice;

	public SalesOrder(){}
	
	/**
	 * @param id
	 * @param orderDate
	 * @param custId
	 * @param orderDesc
	 * @param totalPrice
	 */
	public SalesOrder(Long id, Date orderDate, Long custId, String orderDesc, String totalPrice) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the custId
	 */
	public Long getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}

	/**
	 * @return the orderDesc
	 */
	public String getOrderDesc() {
		return orderDesc;
	}

	/**
	 * @param orderDesc the orderDesc to set
	 */
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	/**
	 * @return the totalPrice
	 */
	public String getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", orderDate=" + orderDate + ", custId=" + custId + ", orderDesc=" + orderDesc
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
}
