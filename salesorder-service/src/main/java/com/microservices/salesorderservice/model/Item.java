package com.microservices.salesorderservice.model;

/**
 * @author 474984
 *
 */
public class Item {

	private String itemId;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private String quantity;
	
	public Item(){
		
	}

	public Item(String itemId, String name, String description, double price, String quantity) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
