package com.required.annotation;

import org.springframework.beans.factory.annotation.Required;


public class Robot {
	
private int id;
public int getId() {
	return id;
}
/**
 *This annotation is used to make the primary type attribute as mandatory
 *if you go for configuration approach that will make every primitive type as mandatory
 *where ever you want we can write this annotation to make attribute as mandatory
 *this we can apply at only on the setter methods  
 */
@Required
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private String type;
@Override
public String toString() {
	return "Robot [id=" + id + ", type=" + type + "]";
}

}
