package com.forum.common.restful.jersey.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @Copyright Copyright (c) 2016 版权归作者所有
 * @author yuangenping
 * @date 2016-12-12
 * @version V1.0
 */
public class JerseyClientUtil {
	private static Client client;
	private static JerseyClientUtil instance = new JerseyClientUtil();
	
	private JerseyClientUtil(){
		ClientConfig config = new DefaultClientConfig();
		//使用Jersey对POJO的支持，必须设置为true
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
		client = Client.create(config);
	}
	
	public Client getClient(){
		return client;
	}
	
	public static JerseyClientUtil getInstance(){
		return instance;
	}
}
