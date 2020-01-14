package com.app.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

	
	private ResponseHandler() {
		
	}

	public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean isSuccess, String message, Object data){

		Map<String, Object> response = new HashMap<>();
		try {
			response.put(AppConstant.STATUS, status.value());
			response.put(AppConstant.SUCCESS, isSuccess);
			response.put(AppConstant.MESSAGE, message);
			response.put(AppConstant.DATA, data);
		}catch (Exception e){
			response.put(AppConstant.STATUS, HttpStatus.BAD_REQUEST.value());
			response.put(AppConstant.SUCCESS, false);
			response.put(AppConstant.MESSAGE, e.getMessage());
			response.put(AppConstant.DATA, null);
		}

		return new ResponseEntity<>(response, status);
	}
}
