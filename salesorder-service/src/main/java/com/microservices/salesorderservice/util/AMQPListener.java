/**
 * 
 */
package com.microservices.salesorderservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.salesorderservice.model.CustomerSOS;
import com.microservices.salesorderservice.service.CustomerSosRepository;

/**
 * @author 474984
 *
 */

@Component
public class AMQPListener {
	
	Logger log = LoggerFactory.getLogger(AMQPListener.class);
	
	@Autowired
	private CustomerSosRepository customerSosRepository;
	
	@RabbitListener(queues="${rabbitmq.queueName}")
    public void receivedMessage(CustomerSOS customerSOS) {
		log.info(">>>>>>> Received Message: " + customerSOS);
		CustomerSOS newCustomer = customerSosRepository.save(customerSOS);
		log.info("Consumed messages are successfully inserted- "+newCustomer);
    }
}
