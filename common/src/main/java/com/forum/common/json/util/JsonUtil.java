package com.forum.common.json.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @Copyright Copyright (c) 2016 版权归作者所有
 * @author yuangenping
 * @date 2016-12-12
 * @version V1.0
 * @param <T>
 */
public class JsonUtil{
	
	private static JsonUtil instance = new JsonUtil();
	
	public static JsonUtil getInstance(){
		return instance;
	}
	
	public String writeValueAsString(Object value)throws Exception{
		return JSON.toJSONString(value);
	}
	
	public <T> T readValue(String content, Class<T> valueType)throws Exception{
		return JSON.parseObject(content, valueType);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> toMap(String text){
		return (Map<String, Object>)JSON.parse(text);
	}
	
	public static void main(String[] args) {
		String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\",\"list\":[\"aaa\",\"bbb\"]}"; 
		System.out.println(JsonUtil.getInstance().toMap(str));
	}
}
