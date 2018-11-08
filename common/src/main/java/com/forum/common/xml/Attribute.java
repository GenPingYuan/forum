package com.forum.common.xml;

import javax.xml.namespace.QName;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public interface Attribute extends Node{
	public abstract QName getQName();

	public abstract String getNamespacePrefix();

	public abstract String getNamespaceURI();

	public abstract String getQualifiedName();

	public abstract String getValue();

	public abstract void setValue(String s);

	public abstract Object getData();

	public abstract void setData(Object obj);
}
