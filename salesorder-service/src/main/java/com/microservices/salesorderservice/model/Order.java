package com.microservices.salesorderservice.model;

import java.util.List;

/**
 * @author 474984
 *
 */
public class Order {

	private String orderDesc;
	
	private Long custId;
	
	private List<Item> items;
	
	public Order(){
		
	}

	public Order(String orderDesc, Long custId, List<Item> items) {
		super();
		this.orderDesc = orderDesc;
		this.custId = custId;
		this.items = items;
	}


	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderDesc=" + orderDesc + ", custId=" + custId + ", items=" + items + "]";
	}
	
}
