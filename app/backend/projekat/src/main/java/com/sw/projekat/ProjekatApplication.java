package com.sw.projekat;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjekatApplication {

//	vratice discount 25
//	http://localhost:8080/getDiscount?type=gold
//	vratice discount 15
//	http://localhost:8080/getDiscount?type=diamond

	public static void main(String[] args) {
		SpringApplication.run(ProjekatApplication.class, args);
	}

//	@Bean
//	public KieContainer kieContainer() {
//		return KieServices.Factory.get().getKieClasspathContainer();
//	}

}
