/**
 * 
 */
package com.microservices.salesorderservice.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This is for Centralized configuration
 * @author 474984
 *
 */
@ConfigurationProperties(prefix="salesorder-service")
@Component
public class SalesOrderConfiguration {
	
	private String environment;
	
	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	

}
