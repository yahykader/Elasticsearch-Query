package org.greta;

import org.greta.entites.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ElasticEssaieApplication implements CommandLineRunner {

	/*
	 * @Autowired RepositoryRestConfiguration repositoryRestConfiguration;
	 * 
	 */	public static void main(String[] args) {
		SpringApplication.run(ElasticEssaieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
         //repositoryRestConfiguration.exposeIdsFor(Customer.class);
	}

}
