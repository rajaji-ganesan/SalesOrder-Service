/**
 * 
 */
package com.microservices.salesorderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.salesorderservice.model.CustomerSOS;
import com.microservices.salesorderservice.model.Order;
import com.microservices.salesorderservice.model.Response;
import com.microservices.salesorderservice.model.SalesOrder;
import com.microservices.salesorderservice.service.CustomerSosRepository;
import com.microservices.salesorderservice.service.SalesOrderRepository;
import com.microservices.salesorderservice.util.SalesOrderConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author 474984
 *
 */

@RestController
//@EnableHystrix
@RequestMapping("/salesorderservice")
public class SalesOrderController {
	private static Logger log = LoggerFactory.getLogger(SalesOrderController.class); 

	@Autowired
	SalesOrderRepository salesOrderRepository;

	@Autowired
	private CustomerSosRepository customerSosRepository;

	@Autowired
	private SOSService sosService;

	@Autowired
	private static SalesOrderConfiguration salesOrderConfiguration;

	@PostMapping("/customer")
	public CustomerSOS  createCustomers(@RequestBody CustomerSOS customer){
		CustomerSOS newCustomer = customerSosRepository.save(customer);
		return newCustomer;
	}
	
	/*static {
		log.info("********Reading Configuration************"+ salesOrderConfiguration.getEnvironment());
	}*/

	@HystrixCommand(fallbackMethod = "fallBackCreateOrder")
	@PostMapping("/orders")
	public ResponseEntity<Response<SalesOrder>> createOrder(@RequestBody Order order){
		log.info("Inside createOrder");
		log.info("Customer id: "+order.getCustId());
		log.info("Item: "+order.getItems());
		boolean value = customerSosRepository.existsById(order.getCustId());
		log.info("isCustomerPresent: "+ value);
		if(value){
			return sosService.createOrder(order);
		}
		return sosService.buildErrorResponse("Cannot create Order. Customer must be register before creating order");
	}

	public ResponseEntity<Response<SalesOrder>> fallBackCreateOrder(@RequestBody Order order, Throwable e){
		log.info("Inside fallBackCreateOrder ");
		log.info("<<<<<<<< Reading Configuration >>>>>>>>"+ salesOrderConfiguration.getEnvironment());
		log.error("Creating order failed due to "+e.getMessage());
		return sosService.buildErrorResponse("Something went wrong - "+e.getMessage());
	}

}
