package com.forum.common.restful.jersey.util;

import java.util.Map;

import com.forum.common.restful.RestfulClientImpl;
import com.sun.jersey.api.client.WebResource.Builder;

/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-12
 * @version V1.0.0
 */
public class JerseyRestfulClient extends RestfulClientImpl {
	private Builder builder;
	private void initBuilder(){
		this.builder = JerseyClientUtil.getInstance().getClient().resource(url).getRequestBuilder();
	}
	
	private void prepareRequest(){
		initBuilder();
		if(!headers.isEmpty()){
			for (Map.Entry<String, Object> header : headers.entrySet()) {
				builder.header(header.getKey(), header.getValue());
			}
		}
	}

	public <T> T post(Class<T> returnType, Object postData) throws Exception {
		prepareRequest();
		return builder.post(returnType, postData);
	}

	public <T> T get(Class<T> returnType) throws Exception {
		prepareRequest();
		return builder.get(returnType);
	}
	
}
