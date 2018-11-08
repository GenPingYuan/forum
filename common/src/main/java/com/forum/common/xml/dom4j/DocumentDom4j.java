package com.forum.common.xml.dom4j;

import java.util.HashMap;
import java.util.Map;

import com.forum.common.xml.Document;
import com.forum.common.xml.Element;
import org.dom4j.DocumentHelper;


/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public class DocumentDom4j extends NodeDom4j implements Document {
	private org.dom4j.Document doc;
	public DocumentDom4j()throws Exception {
		this(DocumentHelper.createDocument());
	}
	public DocumentDom4j(org.dom4j.Document doc) {
		super(doc);
		this.doc = doc;
	}
	public DocumentDom4j(String text)throws Exception {
		this(DocumentHelper.parseText(text));
	}
	
	@Override
	public Document parser(String text)throws Exception{
		this.doc = DocumentHelper.parseText(text);
		return this;
	}
	
	@Override
	public Element getRoot() {
		return new ElementDom4j(this.doc.getRootElement());
	}
	@Override
	public Element addElement(String name) {
		return new ElementDom4j(this.doc.addElement(name));
	}
	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		Element root = getRoot();
		map.put(root.getName(), root.toMap());
		return map;
	}
}
