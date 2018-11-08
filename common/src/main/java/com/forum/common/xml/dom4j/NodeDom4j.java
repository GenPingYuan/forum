package com.forum.common.xml.dom4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.XPath;

import com.forum.common.xml.Document;
import com.forum.common.xml.Element;
import com.forum.common.xml.Node;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public class NodeDom4j implements Node{
	private org.dom4j.Node node;
	public NodeDom4j(org.dom4j.Node node) {
		this.node = node;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Node> selectNodes(String xpath,Map<String, String> namespaceURIs) {
		XPath xPath2 = this.node.createXPath(xpath);
		if(namespaceURIs != null) {
			xPath2.setNamespaceURIs(namespaceURIs);
		}
		List<org.dom4j.Node> list = xPath2.selectNodes(this.node);
		List<Node> nodes = new ArrayList<>(list.size());
		for (org.dom4j.Node node : list) {
			nodes.add(new NodeDom4j(node));
		}
		return nodes;
	}
	
	@Override
	public List<Node> selectNodes(String xpath) {
		return selectNodes(xpath, null);
	}
	
	public Node selectSingleNode(String xpath) {
		return selectSingleNode(xpath, null);
	}
	
	public Node selectSingleNode(String xpath,Map<String, String> namespaceURIs) {
		XPath xPath2 = this.node.createXPath(xpath);
		if(namespaceURIs != null) {
			xPath2.setNamespaceURIs(namespaceURIs);
		}
		return new NodeDom4j(xPath2.selectSingleNode(this.node));
	}
	
	@Override
	public String toString() {
		return this.node == null ? null : this.node.asXML();
	}

	@Override
	public Document getDocument() {
		return new DocumentDom4j(this.node.getDocument());
	}
	
	public Element getParent() {
		return new ElementDom4j(this.node.getParent());
	}
	
	public String getText() {
		return this.node.getText();
	}
	
	public void setText(String text) {
		this.node.setText(text);
	}
	
	public String getName() {
		return this.node.getName();
	}
	
	
}
