package com.makersharks.search_api_makersharks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoDataException extends Exception {
	
	String msg="No data Has Found";

	public NoDataException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
