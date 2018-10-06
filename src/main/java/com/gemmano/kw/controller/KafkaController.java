package com.gemmano.kw.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
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
		
		try {
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(deviceData.getTimestamp());
			Date newDate = DateUtils.addHours(date1, 3);
			deviceData.setTimestamp(dateFormat.format(newDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		kafkaSender.send(deviceData);
		return "OK";
	}
}
