package com.target.sample.configurations;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.target.sample.repositories")
@PropertySource(value = "classpath:application.properties")
public class ElasticSearchConfiguration {

	@Resource
	private Environment environment;
	

	@Bean
	public Client client() {
		Settings settings = Settings.settingsBuilder()
		        .put("cluster.name", "elasticsearch")
		        .put("client.transport.sniff", true)
		        .put("client.transport.ping_timeout", "5s").build();

		TransportClient client  = TransportClient.builder().settings(settings).build();
		
		try {
			client.addTransportAddress(
					(TransportAddress) new InetSocketTransportAddress(
							InetAddress.getByName(environment.getProperty("elasticsearch.host")), 
							Integer.valueOf(environment.getProperty("elasticsearch.port"))));
		} catch (NumberFormatException | UnknownHostException e) {
			e.printStackTrace();
		}
		//client.connectedNodes();
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
     }
}
