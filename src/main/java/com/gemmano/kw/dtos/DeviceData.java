package com.gemmano.kw.dtos;

import lombok.Data;

@Data
public class DeviceData {
	
	private String deviceName;
	private String temperature;
	private String humidity;
	private String light;
	private String timestamp;
	
}
