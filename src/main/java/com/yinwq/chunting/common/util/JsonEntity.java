package com.yinwq.chunting.common.util;


import java.util.HashMap;
import java.util.Map;

public class JsonEntity {
	private boolean success;
	private String message;
	private Map<String, Object> data;
	public JsonEntity(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public JsonEntity(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public JsonEntity addData(String key, Object value){
		if(data == null){
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
		return this;
	}
}
