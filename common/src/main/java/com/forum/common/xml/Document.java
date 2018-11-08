package com.forum.common.xml;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public interface Document extends Branch{
	/**
	 * 解析xml内容
	 * @author yuangenping
	 * @date 2018年9月21日
	 * @version V1.0.0
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public Document parser(String text)throws Exception;
	
	/**
	 * 获取根节点
	 * @author yuangenping
	 * @date 2018年9月21日
	 * @version V1.0.0
	 * @return
	 */
	public Element getRoot();
	
	
}
