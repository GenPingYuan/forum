package com.forum.common.xml.dom4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.forum.common.xml.Element;
import org.springframework.util.Assert;

import com.forum.common.xml.Attribute;
import com.forum.common.xml.Element;
import com.forum.common.xml.model.ElementMap;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public class ElementDom4j extends NodeDom4j implements Element {
	private org.dom4j.Element element;

	public ElementDom4j(org.dom4j.Element element) {
		super(element);
		this.element = element;
	}

	@Override
	public Attribute attribute(String s) {
		return new AttributeDom4j(element.attribute(s));
	}

	@Override
	public String attributeValue(String s) {
		return element.attributeValue(s);
	}
	
	public Map<String, Object> toMap(){
		return elementToMap(this.element);
	}
	
	@SuppressWarnings("unchecked")
	private ElementMap elementToMap(org.dom4j.Element element){
		Assert.notNull(element, "入参元素不能为空");
		List<org.dom4j.Element> list = element.elements();
		ElementMap dto = new ElementMap();
		dto.setName(element.getName());
		List<org.dom4j.Attribute> attributes = element.attributes();
		if(attributes != null && attributes.size() > 0) {
			Map<String, String> attrs = new HashMap<>();
			for (org.dom4j.Attribute attr : attributes) {
				attrs.put(attr.getName(), attr.getText());
			}
			dto.setAttr(attrs);
		}
		
		if(!list.isEmpty()) {
			for (org.dom4j.Element ele : list) {
				ElementMap sub = elementToMap(ele);
				Object value = dto.get(sub.getName());
				if(value == null) {
					dto.put(sub.getName(), sub);
				}else if (value instanceof ElementMap) {
					List<ElementMap> subList = new ArrayList<>();
					subList.add((ElementMap)value);
					subList.add(sub);
					dto.put(sub.getName(), subList);
				}else if(value instanceof List) {
					((List<ElementMap>) value).add(sub);
				}
			}
		}else {
			dto.setText(element.getText());
		}
		return dto;
	}
	
	public Element element(String name) {
		org.dom4j.Element element = this.element.element(name);
		if(element == null) {
			return null;
		}
		return new ElementDom4j(this.element.element(name));
	}
	
	@SuppressWarnings("unchecked")
	public List<Element> elements(String name) {
		List<org.dom4j.Element> elements = name == null ? this.element.elements(): this.element.elements(name);
		if(elements == null ||elements.isEmpty()) {
			return null;
		}
		List<Element> list = new ArrayList<>(elements.size());
		for (org.dom4j.Element element : elements) {
			list.add(new ElementDom4j(element));
		}
		return list;
	}

	@Override
	public Element addElement(String name) {
		return new ElementDom4j(this.element.addElement(name));
	}
	
	public String getNamespaceURI() {
		return this.element.getNamespaceURI();
	}
	
	public void addAttribute(String name, String value) {
		this.element.addAttribute(name, value);
	}
}
