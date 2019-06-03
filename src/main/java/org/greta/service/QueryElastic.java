package org.greta.service;

import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.greta.entites.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QueryElastic {
	
	@Autowired
	private ElasticsearchTemplate template;
	
	
	public List<Customer> searchMultifield(String firstName,int age){
		
		QueryBuilder query=QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("firstName",firstName))
				                                    .must(QueryBuilders.matchQuery("age",age));
		
		NativeSearchQuery nativeSearchQuery=new NativeSearchQueryBuilder().withQuery(query).build();
		List<Customer> customers=template.queryForList(nativeSearchQuery, Customer.class);
		return customers;	
	}
	
	
	public List<Customer> getCustomerSearchData(String input) {
		 String search = ".*"+input+".*";
		 SearchQuery searchQuery= new NativeSearchQueryBuilder().withFilter(QueryBuilders.regexpQuery("firstName", search)).build();
		 List<Customer> customers=template.queryForList(searchQuery, Customer.class);
		 return customers;
		
	}
	
	public List<Customer> multiMatchQuery(String text){
		QueryBuilder  queryBuilder= 	
		   QueryBuilders.multiMatchQuery(text).field("firstName").field("lastName").type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
	
		 SearchQuery searchQuery =new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
		
		 List<Customer> customers=template.queryForList(searchQuery, Customer.class);
		 return customers;
	}
	
	
	
	

}
