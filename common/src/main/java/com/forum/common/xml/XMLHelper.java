package com.forum.common.xml;

import com.forum.common.xml.dom4j.DocumentDom4j;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public class XMLHelper {
	private XMLHelper() {}
	public static Document parseText(String text) throws Exception {
		return new DocumentDom4j(text);
	}
	public static Document createDocument() throws Exception {
		return new DocumentDom4j();
	}
}
