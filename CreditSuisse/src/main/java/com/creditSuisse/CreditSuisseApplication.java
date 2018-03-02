package com.creditSuisse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CreditSuisseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CreditSuisseApplication.class);
	
	public static void main(String[] args) {
		try {
			logger.info("Application Starting......");
			SpringApplication.run(CreditSuisseApplication.class, args);
			logger.info("Application Started");
		} catch (Exception e) {
			logger.error("Error while Application Start-up " + e.getMessage());
		}
	}
}
