package com.emmanoug.kw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emmanoug.kw.dtos.Thermodata;
import com.emmanoug.kw.services.KafkaSender;

@RestController
@RequestMapping("/kafkamsg")
public class KafkaController {
	
	@Autowired
	private KafkaSender kafkaSender;

	@RequestMapping(method = RequestMethod.POST)
	public String kafkaMsg(@RequestBody Thermodata thermodata) {
		kafkaSender.send(thermodata);
		return "OK";
	}
}
