package com.forum.common.xml;

import java.util.Map;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年10月10日
 * @version V1.0.0
 */
public interface Branch extends Node{
	/**
	 * 将元素转成map
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @return
	 */
	public Map<String, Object> toMap();
	/**
	 * 添加元素
	 * @author yuangenping
	 * @date 2018年10月10日
	 * @version V1.0.0
	 * @param name
	 * @return
	 */
	public Element addElement(String name);
}
