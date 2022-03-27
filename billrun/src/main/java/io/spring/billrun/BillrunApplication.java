package io.spring.billrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BillrunApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillrunApplication.class, args);
	}

}
