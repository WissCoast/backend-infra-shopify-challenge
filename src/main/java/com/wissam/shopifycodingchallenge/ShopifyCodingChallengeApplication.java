package com.wissam.shopifycodingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.wissam.shopifycodingchallenge.persistence.repositories")
@EntityScan("com.wissam.shopifycodingchallenge.persistence.entities")
@SpringBootApplication
public class ShopifyCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyCodingChallengeApplication.class, args);
	}

}

