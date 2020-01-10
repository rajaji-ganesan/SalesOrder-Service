package com.microservices.salesorderservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.salesorderservice.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
