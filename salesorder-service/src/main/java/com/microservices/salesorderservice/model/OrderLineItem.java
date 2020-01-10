/**
 * 
 */
package com.microservices.salesorderservice.model;

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
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="item_id")
	private Long id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name= "item_quantity")
	private String itemQuantity;
	
	@Column(name="order_id")
	private String orderId;

	public OrderLineItem(){}
	
	/**
	 * @param id
	 * @param itemName
	 * @param itemQuantity
	 * @param orderId
	 */
	public OrderLineItem(Long id, String itemName, String itemQuantity, String orderId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
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
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemQuantity
	 */
	public String getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderLineItem [id=" + id + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", orderId="
				+ orderId + "]";
	}
	
	
}
