package com.ChinBoTu_FinalTest_COMP303.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);

		//print message so I know it's actually running

		System.out.println("SpringBoot is running on localhost:8083");
	}

}
