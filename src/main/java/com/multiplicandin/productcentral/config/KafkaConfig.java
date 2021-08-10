package com.multiplicandin.productcentral.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.multiplicandin.productcentral.model.Product;

@Configuration
public class KafkaConfig {

	public ProducerFactory<String, Product> producerFactory(){
		Map<String,Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);

	}
	
	public KafkaTemplate<String,Product> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
}
