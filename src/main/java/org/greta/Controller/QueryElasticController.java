package org.greta.Controller;

import java.util.List;

import org.greta.entites.Customer;
import org.greta.service.QueryElastic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryElasticController {
	
	@Autowired
	private QueryElastic service;
	
	
	@GetMapping("/searchMultifield/{firstName}/{age}")
	public List<Customer> searchByMultifield(@PathVariable String firstName,@PathVariable int age){
		
         return service.searchMultifield(firstName, age);
	}
	
	@GetMapping ("/customersearh/{firstName}")
	public List<Customer> getCustomer(@PathVariable String firstName){
		return service.getCustomerSearchData(firstName);
		
	}
	
	@GetMapping ("/search/{text}")
	public List<Customer> searchText(@PathVariable String text){
		return service.multiMatchQuery(text);
		
	}

}
