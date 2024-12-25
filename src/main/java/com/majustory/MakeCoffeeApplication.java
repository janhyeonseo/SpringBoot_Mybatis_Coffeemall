package com.majustory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.majustory","com.maju"})
@SpringBootApplication
public class MakeCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeCoffeeApplication.class, args);
	}

}
