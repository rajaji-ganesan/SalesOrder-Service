package com.microservices.salesorderservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.salesorderservice.model.CustomerSOS;

public interface CustomerSosRepository extends JpaRepository<CustomerSOS, Long>{

}
