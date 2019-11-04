package com.lv.util;

import java.util.HashMap;
import java.util.Map;

public class Message {
	private String msg;
	private Map<String,Object> map=new HashMap<String, Object>();
	
	public static Message success(){
		Message message=new Message();
		message.msg="success";
		return message;
	}
	
	public static Message fail(){
		Message message=new Message();
		message.msg="fail";
		return message;
	}
	
	public Message addMap(String key,Object value){
		this.getMap().put(key, value);
		return this;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Message [msg=" + msg + ", map=" + map + "]";
	}
}
