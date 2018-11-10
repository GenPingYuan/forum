package com.forum.common.xml.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 * 封装了XML转换成object，object转换成XML的代码
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author yuangenping
 * @date 2017-12-12
 * @version V1.0.0
 */
public class XMLUtil{
	public static final String encoding = "UTF-8";
	/**
	 * 将对象直接转换成String类型的 XML输出
	 * @author yuangenping
	 * @date 2016-12-12
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj)throws Exception {
		// 创建输出流
		StringWriter sw = null;
		String xml = null;
		try {
			sw = new StringWriter();
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
			xml = sw.toString();
		} catch (JAXBException e) {
			throw e;
		}finally{
			if(sw != null){
				sw.close();
			}
		}
		return xml;
	}

	/**
	 * 将xml字符串转成对象
	 * @author yuangenping
	 * @date 2017-11-23
	 * @version V1.0.0
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T  convertToBean(Class<T> clazz, String xmlStr)throws Exception {
		Object xmlObject = null;
		StringReader sr = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			// 进行将Xml转成对象的核心接口
			Unmarshaller unmarshaller = context.createUnmarshaller();
			sr = new StringReader(xmlStr);
			xmlObject = unmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			throw e;
		}finally{
			if(sr != null){
				sr.close();
			}
		}
		return (T)xmlObject;
	}
	
	/**
	 * 将XML转换成w3c Element对象
	 * @author yuangenping
	 * @date 2017-12-12
	 * @version V1.0.0
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Element convertToElement(String xml)throws Exception{
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml.toString()))).getDocumentElement();
	}
}