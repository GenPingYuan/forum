package com.forum.common.xml;

import java.util.List;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public interface Element extends Branch{
	/**
	 * 获取元素属性
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @param s
	 * @return
	 */
	public abstract Attribute attribute(String s);
	
	/**
	 * 获取元素属性值
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @param s
	 * @return
	 */
	public abstract String attributeValue(String s);
	
	/**
	 * 获取子元素
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @param name
	 * @return
	 */
	public Element element(String name);
	
	/**
	 * 获取子元素列表
	 * @author yuangenping
	 * @date 2018年10月11日
	 * @version V1.0.0
	 * @param name
	 * @return
	 */
	public List<Element> elements(String name);
	
	/**
	 * 获取元素命名空间url
	 * @author yuangenping
	 * @date 2018年10月11日
	 * @version V1.0.0
	 * @return
	 */
	public String getNamespaceURI();
	
	/**
	 * 添加元素属性
	 * @author yuangenping
	 * @date 2018年10月16日
	 * @version V1.0.0
	 * @param name
	 * @param value
	 */
	public void addAttribute(String name, String value);
}
