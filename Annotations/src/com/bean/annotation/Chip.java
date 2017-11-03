package com.bean.annotation;

public class Chip {
private int chipId;
private String chipType;
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
