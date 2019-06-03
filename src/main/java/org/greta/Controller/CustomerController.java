package org.greta.Controller;

import java.util.ArrayList;

import java.util.List;

import org.greta.entites.Customer;

import org.greta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;


@RestController
//@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
 private CustomerRepository customerRepository;
	/*
	 * @Autowired private CustomerJpaRepository cutomerJparepository;
	 */

 
 
 @PostMapping("/saveAll")
 public int saveCustomer(@RequestBody List<Customer> customers) {
	  
	     customerRepository.save(customers);
	     return customers.size();
	 
 }
 @PostMapping("/savecustomer")
 public Customer saveCustomer(@RequestBody Customer customer) {
	 return customerRepository.save(customer);
	 
 }
 @DeleteMapping("/deleteone")
 public void  deleteCustomer(Customer c ) {
	 customerRepository.delete(c);     	 
 }
 
 @DeleteMapping("/deleteAll")
 public void deleteall(){
		
	 customerRepository.deleteAll();
 }
 
 @DeleteMapping("/deleteByFirstName/{firstName}")
 public void  deleteByFirstName(@PathVariable String firstName) {
	 
	     customerRepository.deleteByFirstName(firstName);

 }
 
 @GetMapping("/findAlls")
 public List<Customer> findAllCustomers(){
		
		
		 List<Customer>listCustomers=new ArrayList<>();
	     Iterable<Customer>customers=customerRepository.findAll();
		 customers.forEach(listCustomers::add);
		
		 
	 return  listCustomers;
 }
 
 @GetMapping("/findByFistName/{firstName}")
 public List<Customer> findByFirstName(@PathVariable String firstName){
	 return customerRepository.findByFirstName(firstName);
 }
 
 
 

}
