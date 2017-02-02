package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private int statuscode;
private String message;

public ErrorMessage(){}

public ErrorMessage(int statuscode, String message) {
	super();
	this.statuscode = statuscode;
	this.message = message;
}

public int getStatuscode() {
	return statuscode;
}

public void setStatuscode(int i) {
	this.statuscode = i;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}




}
