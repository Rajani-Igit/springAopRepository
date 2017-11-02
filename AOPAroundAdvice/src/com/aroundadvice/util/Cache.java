package com.aroundadvice.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
private Map<String,Object> dataMap;
private static Cache instance;
private Cache() {	
	System.out.println("Cache Constructor called");
	dataMap = new ConcurrentHashMap<String,Object>();
}
public static synchronized Cache getInstance() {
	if(instance == null) {
		instance = new Cache();
	}
	return instance;
}
//This method is to insert data into dataMap
public void put(String key,Object value) {
	dataMap.put(key, value);
}
//This method is to retrive the data from the dataMap
public Object get(String key) {
	return dataMap.get(key);
}
//This method is to check weather data available or not
public boolean containsKey(String key) {
	return dataMap.containsKey(key);
}
}
