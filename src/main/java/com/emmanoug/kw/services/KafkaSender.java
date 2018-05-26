package com.emmanoug.kw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.emmanoug.kw.dtos.Thermodata;

@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, Thermodata> kafkaTemplate;

	@Value("${app.topic.device}")
	private String topic;

	public void send(Thermodata data) {
		
		Message<Thermodata> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        
		
		kafkaTemplate.send(message);
	}
}
