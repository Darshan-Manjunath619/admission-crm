package com.admission.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.admission.crm")
@EnableJpaRepositories(basePackages = "com.admission.crm.repository")
@EnableTransactionManagement
public class AdmissionCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionCrmApplication.class, args);
		System.out.println("✅ Admission CRM Application Started Successfully");
	}

}