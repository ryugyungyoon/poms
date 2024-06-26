package com.jg.poms;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import com.jg.poms.core.http.HttpBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PomsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PomsApplication.class, args);
	}

	@Bean
	Hibernate5JakartaModule hibernate5Module() {
		return new Hibernate5JakartaModule();
	}
}
