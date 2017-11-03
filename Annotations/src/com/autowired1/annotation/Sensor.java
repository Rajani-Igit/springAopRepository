package com.autowired1.annotation;

public class Sensor {
   private String sensorType;
   private int sensorId;
public void setSensorType(String sensorType) {
	this.sensorType = sensorType;
}
@Override
public String toString() {
	return "Sensor [sensorType=" + sensorType + ", sensorId=" + sensorId + "]";
}
public void setSensorId(int sensorId) {
	this.sensorId = sensorId;
} 
}
