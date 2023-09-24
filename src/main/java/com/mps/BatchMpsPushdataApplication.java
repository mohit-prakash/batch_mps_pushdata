package com.mps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:sqlQuery.xml"})
public class BatchMpsPushdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchMpsPushdataApplication.class, args);
	}

}
