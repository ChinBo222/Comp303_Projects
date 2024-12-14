package assignment3.BloodBankSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloodBankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankSystemApplication.class, args);
		//print message so I know it's actually running

		System.out.println("SpringBoot is running on localhost:8083");

	}

}
