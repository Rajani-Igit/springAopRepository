package com.autowired1.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Chip {
  private int chipId;
  private String chipType;
  public Chip() {
	  System.out.println("inside chip class constructor");
  }
public void setChipId(int chipId) {
	this.chipId = chipId;
}
public void setChipType(String chipType) {
	this.chipType = chipType;
}
@Override
public String toString() {
	return "Chip [chipId=" + chipId + ", chipType=" + chipType + "]";
}
  
}
