package com.gemmano.kw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.gemmano.kw.dtos.DeviceData;

@Service
public class KafkaSender {

	@Autowired
    private KafkaTemplate<String, DeviceData> kafkaTemplate;

	@Value("${spring.kafka.topic}")
	private String topic;

	public void send(DeviceData data) {
		
		kafkaTemplate.send(topic, data);
	}
}
