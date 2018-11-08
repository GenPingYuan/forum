package com.forum.common.restful;

/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-12
 * @version V1.0.0
 */
public interface RestfulClient {
	/**
	 * 设置调用地址
	 * @author li.ming
	 * @date 2017-12-12
	 * @version V1.0.0
	 * @param url
	 * @return
	 */
	public RestfulClient setURL(String url);
	/**
	 * 添加调用Header
	 * @author li.ming
	 * @date 2017-12-12
	 * @version V1.0.0
	 * @param name
	 * @param value
	 * @return
	 */
	public RestfulClient addHeader(String name, Object value);
	/**
	 * post方式调用
	 * @author li.ming
	 * @date 2017-12-12
	 * @version V1.0.0
	 * @param returnType
	 * @param postData
	 * @return
	 * @throws Exception
	 */
	public <T> T post(Class<T> returnType, Object postData) throws Exception;
	
	/**
	 * get方式调用
	 * @author li.ming
	 * @date 2017-12-12
	 * @version V1.0.0
	 * @param returnType
	 * @return
	 * @throws Exception
	 */
	public <T> T get(Class<T> returnType) throws Exception;
}
