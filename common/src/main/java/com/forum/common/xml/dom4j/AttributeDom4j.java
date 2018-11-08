package com.forum.common.xml.dom4j;

import com.forum.common.xml.Attribute;

import javax.xml.namespace.QName;


/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public class AttributeDom4j extends NodeDom4j implements Attribute{

	private org.dom4j.Attribute attr;
	public AttributeDom4j(org.dom4j.Attribute attr) {
		super(attr);
	}
	@Override
	public QName getQName() {
		org.dom4j.QName qName= attr.getQName();
		return new QName(qName.getNamespaceURI(),qName.getName(),qName.getNamespacePrefix());
	}
	@Override
	public String getNamespacePrefix() {
		return attr.getNamespacePrefix();
	}
	@Override
	public String getNamespaceURI() {
		return attr.getNamespaceURI();
	}
	@Override
	public String getQualifiedName() {
		return attr.getQualifiedName();
	}
	@Override
	public String getValue() {
		return attr.getValue();
	}
	@Override
	public void setValue(String s) {
		attr.setValue(s);
	}
	@Override
	public Object getData() {
		return attr.getData();
	}
	@Override
	public void setData(Object obj) {
		attr.setData(obj);
	}

}
