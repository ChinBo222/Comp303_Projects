package com.tu.chinbo.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootDemoApplication.class, args);

		Scanner input = new Scanner(System.in);
		System.out.println("enter a number");

		int Num = input.nextInt();
		int factorial = 1;
		for (int counter = 1; counter <= Num; counter++) {

			factorial *= counter;
			System.out.println(counter+"! ="+factorial);
		}
		input.close();
	}

}
