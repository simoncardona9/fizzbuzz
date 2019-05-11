package com.intraway.fizzbuzz;

import com.intraway.fizzbuzz.utils.Counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class FizzbuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}

	@Bean(name = "counter")
	@Scope("singleton")
	public Counter counter() {
		return new Counter(0);
	}

}
