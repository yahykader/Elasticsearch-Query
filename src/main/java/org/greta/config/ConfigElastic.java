package org.greta.config;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages = "org.greta.jparepository")
@EnableElasticsearchRepositories(basePackages = "org.greta.repository")
public class ConfigElastic {

	@Bean
	public NodeBuilder nodebuilder() {
		
		return new NodeBuilder();
	}
	
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		
		return new ElasticsearchTemplate(nodebuilder().local(true).node().client());
	}

}
