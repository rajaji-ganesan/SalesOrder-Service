/**
 * 
 */
package com.microservices.salesorderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.salesorderservice.controller.SalesOrderController;
import com.microservices.salesorderservice.model.Item;

/**
 * @author 474984
 *
 */

//@FeignClient(name="item-service", url="localhost:8181")
@FeignClient(name="item-service")
@RibbonClient(name="item-service")
public interface ItemServiceFeign {
	Logger log = LoggerFactory.getLogger(SalesOrderController.class); 

	@GetMapping("/itemservice/items")
	public List<Item> getAllItemDetails();
	
	@GetMapping("/itemservice/items/{itemName}")
	public Item getItemDetails(@PathVariable("itemName") String itemName);
	
	/*@Component
    class HystrixClientFallback implements ItemServiceFeign{

		@Override
		public List<Item> getAllItemDetails() {
			log.info("Inside HystrixClientFallback of getAllItemDetails");
			return new ArrayList<Item>();
		}

		@Override
		public Item getItemDetails(String message) {
			log.info("Inside HystrixClientFallback of getItemDetails");
			return new Item();
		}
		
	}*/
}
