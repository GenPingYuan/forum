package com.forum.common.restful;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-12
 * @version V1.0.0
 */
public abstract class RestfulClientImpl implements RestfulClient{
	protected String url;
	protected Map<String, Object> headers = new ConcurrentHashMap<String, Object>();
	public RestfulClient setURL(String url) {
		this.url = url;
		return this;
	}

	public RestfulClient addHeader(String name, Object value) {
		headers.put(name, value);
		return this;
	}

}
