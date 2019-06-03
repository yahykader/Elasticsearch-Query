
package org.greta.load;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.greta.entites.Customer;
import org.greta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Loaders {
	
	
	@Autowired
	private ElasticsearchOperations operations;
	@Autowired
	private CustomerRepository customerRepository;
	/*@Autowired 
	private CustomerJpaRepository customerJpaRepository;
	 */
	
	
	/**
	 * 
	 */
	@PostConstruct
	@Transactional
	public void loadAll() {
		
		operations.putMapping(Customer.class);
		System.out.println("loading data");
		
		/*
		 List<Customer> data = getData(); //save in h2DB
		  customerJpaRepository.save(data);
		  
		  List<Customer>customerList=customerJpaRepository.findAll();
		  
		  customerRepository.save(customerList);// load in elasticsearch
		  
		  System.out.println("Laoding completed");
		
		*/
	}

  /*
	 private List<Customer> getData() { 
		 List<Customer> customers=new ArrayList<>(); 
					  customers.add(new Customer());
					
	  
	  return customers; 
	 }
*/
}
