package com.gemmano.kw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gemmano.kw.dtos.DeviceData;
import com.gemmano.kw.services.KafkaSender;

@RestController
@RequestMapping("/kafkamsg")
public class KafkaController {
	
	@Autowired
	private KafkaSender kafkaSender;

	@RequestMapping(method = RequestMethod.POST)
	public String kafkaMsg(@RequestBody DeviceData deviceData) {
		kafkaSender.send(deviceData);
		return "OK"; //TODO return better response
	}
}
