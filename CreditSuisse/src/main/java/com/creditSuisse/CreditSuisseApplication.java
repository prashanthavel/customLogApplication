package com.creditSuisse;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditSuisseApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CreditSuisseApplication.class, args);
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
