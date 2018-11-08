package com.forum.common.restful;

import com.forum.common.restful.jersey.util.JerseyRestfulClient;

/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-12
 * @version V1.0.0
 */
public class RestfulClientFactory {
	public static enum RestfulType{
		JERSEY
	}
	public static RestfulClient getClient(RestfulType type){
		RestfulClient client = null;
		switch (type) {
		case JERSEY:
			client = new JerseyRestfulClient();
			break;
		default:
			break;
		}
		return client;
	}
}
