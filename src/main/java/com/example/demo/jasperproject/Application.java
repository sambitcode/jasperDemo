package com.example.demo.jasperproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(Application.class, args);

	}

}
