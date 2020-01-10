package com.microservices.salesorderservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.salesorderservice.model.Item;
import com.microservices.salesorderservice.model.Order;
import com.microservices.salesorderservice.model.OrderLineItem;
import com.microservices.salesorderservice.model.Response;
import com.microservices.salesorderservice.model.SalesOrder;
import com.microservices.salesorderservice.service.ItemServiceFeign;
import com.microservices.salesorderservice.service.OrderLineItemRepository;
import com.microservices.salesorderservice.service.SalesOrderRepository;


@Service
public class SOSService {
	
	Logger log = LoggerFactory.getLogger(SOSService.class); 
	
	@Autowired
	ItemServiceFeign itemServiceFeign;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	public ResponseEntity<Response<SalesOrder>> createOrder(Order order){
		SalesOrder salesOrder = null;
		Response<SalesOrder> response = new Response<SalesOrder>();
		List<Item> listOfAllItems = itemServiceFeign.getAllItemDetails();
		List<Item> listOfItemsToBill = getListOfItemsForBilling(listOfAllItems,order);
		String totalPrice = getItemsTotalPrice(listOfItemsToBill);
		if(Double.valueOf(totalPrice) > 0){
			salesOrder = saveSalesOrder(order,totalPrice);
			if(null != salesOrder){
				if(null != salesOrder.getId()){
					saveOrderLineItem(String.valueOf(salesOrder.getId()),listOfItemsToBill);
					response.setResponseCode("00");
					response.setResponseMessage("SUCCESS");;
					response.setResponse(salesOrder);
					return ResponseEntity.ok(response);
				}
			}
		}else{
			return buildErrorResponse("Items not available");
		}
		log.info("Count"+listOfItemsToBill.size());
		log.info("Total Price "+totalPrice);
		return buildErrorResponse("Items not available");
	}


	private List<Item> getListOfItemsForBilling(List<Item> listOfAllItems, Order order) {
		List<Item> listOfOrderedItems = order.getItems();
		List<Item> listOfItemsToBill = new ArrayList<Item>();
		if(null == listOfAllItems){
			log.info("No Itemsssss Availble");
		}else{
			log.info("Itemsssss-----------"+listOfAllItems.get(0).getName());
			for(Item OrderedItem : listOfOrderedItems){
				for(Item availbleItem : listOfAllItems){
					if(OrderedItem.getName().equalsIgnoreCase(availbleItem.getName()) && Integer.parseInt(OrderedItem.getQuantity()) > 0){
						availbleItem.setQuantity(OrderedItem.getQuantity());
						listOfItemsToBill.add(availbleItem);
					}
				}
			}
		}
		return listOfItemsToBill;
	}
	
	private String getItemsTotalPrice(List<Item> listOfItemsToBill) {
		double totalPrice = 0.0;
		double individualPrice = 0.0;
		if(null != listOfItemsToBill){
			for(Item item : listOfItemsToBill){
				individualPrice = item.getPrice() * Double.parseDouble(item.getQuantity());
				totalPrice = totalPrice + individualPrice;
			}
		}
		return String.valueOf(totalPrice);
	}
	
	private SalesOrder saveSalesOrder(Order order, String totalPrice) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setCustId(order.getCustId());
		salesOrder.setOrderDate(new Date());
		salesOrder.setOrderDesc(order.getOrderDesc());
		salesOrder.setTotalPrice(totalPrice);
		return salesOrderRepository.save(salesOrder);
	}

	private void saveOrderLineItem(String orderId, List<Item> listOfItemsToBill) {
		for(Item item : listOfItemsToBill){
			OrderLineItem orderLineItem = new OrderLineItem();
			orderLineItem.setItemName(item.getName());
			orderLineItem.setItemQuantity(item.getQuantity());
			orderLineItem.setOrderId(orderId);
			orderLineItemRepository.save(orderLineItem);
		}
		
	}
	
	public ResponseEntity<Response<SalesOrder>> buildErrorResponse(String message) {
		Response<SalesOrder> response = new Response<SalesOrder>();
		response.setResponseCode("400");
		response.setResponseMessage(message);
		response.setResponse(null);
		return ResponseEntity.ok(response);
	}
}
