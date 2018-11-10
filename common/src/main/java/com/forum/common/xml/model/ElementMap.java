package com.forum.common.xml.model;

import java.util.HashMap;
import java.util.Map;

import com.forum.common.json.util.JsonUtil;import com.forum.common.json.util.JsonUtil;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月30日
 * @version V1.0.0
 */
public class ElementMap extends HashMap<String, Object> {
	private static final long serialVersionUID = 532311858046472505L;
	private static final String NAME = "$name";
	private static final String TEXT = "$text";
	private static final String ATTR = "$attr";
	/**
	 * @author yuangenping
	 * @date 2018年9月30日
	 * @version V1.0.0
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		switch (name) {
		case NAME:
		case TEXT:
		case ATTR:
			throw new IllegalArgumentException(String.format("[%s,%s,%s] are keyword,can not be used as key", NAME,TEXT,ATTR));
		default:
			break;
		}
		put(NAME, name);
	}
	public String getName() {
		return get(NAME).toString();
	}
	/**
	 * @author yuangenping
	 * @date 2018年9月30日
	 * @version V1.0.0
	 * @param text 要设置的 text
	 */
	public void setText(Object text) {
		put(TEXT, text);
	}
	public Object getText() {
		return get(TEXT);
	}
	/**
	 * @author yuangenping
	 * @date 2018年9月30日
	 * @version V1.0.0
	 * @param attr 要设置的 attr
	 */
	public void setAttr(Map<String, String> attr) {
		put(ATTR, attr);
	}
	@SuppressWarnings("unchecked")
	public Map<String, String> getAttr(){
		return (Map<String, String>) get(ATTR);
	}
	
	@Override
	public String toString() {
		try {
			return JsonUtil.getInstance().writeValueAsString(this);
		} catch (Exception e) {
			return super.toString();
		}
	}
}
