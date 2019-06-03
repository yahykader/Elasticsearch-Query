package org.greta.repository;


import java.util.List;

import org.greta.entites.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName );
	void deleteByFirstName(String firstName);

}
