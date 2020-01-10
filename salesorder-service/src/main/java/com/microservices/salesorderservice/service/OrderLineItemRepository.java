package com.microservices.salesorderservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.salesorderservice.model.OrderLineItem;


public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long>{

}
