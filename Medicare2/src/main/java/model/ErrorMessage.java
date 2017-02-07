package model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

@XmlRootElement
public class ErrorMessage {
	private HttpStatus statuscode;
private String message;

public ErrorMessage(){}

public ErrorMessage(HttpStatus statuscode, String message) {

	this.statuscode = statuscode;
	this.message = message;
}

public HttpStatus getStatuscode() {
	return statuscode;
}

public void setStatuscode(HttpStatus i) {
	this.statuscode = i;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}




}
