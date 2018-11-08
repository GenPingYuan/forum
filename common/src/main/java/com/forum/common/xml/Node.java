package com.forum.common.xml;

import java.util.List;
import java.util.Map;

/**
 * @Copyright Copyright (c) 2018 版权归作者及其公司所有
 * @author yuangenping
 * @date 2018年9月21日
 * @version V1.0.0
 */
public interface Node {
	/**
	 * 根据xpath查找节点
	 * @author yuangenping
	 * @date 2018年9月30日
	 * @version V1.0.0
	 * @param xpath
	 * @param namespaceURIs
	 * @return
	 */
	public List<Node> selectNodes(String xpath, Map<String, String> namespaceURIs);
	
	/**
	 * 根据xpath查找节点
	 * @author yuangenping
	 * @date 2018年9月30日
	 * @version V1.0.0
	 * @param xpath
	 * @return
	 */
	public List<Node> selectNodes(String xpath);
	
	/**
	 * 根据xpath查找单个节点
	 * @author yuangenping
	 * @date 2018年10月8日
	 * @version V1.0.0
	 * @param xpath
	 * @return
	 */
	public Node selectSingleNode(String xpath);
	
	/**
	 * 根据xpath查找单个节点
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @param xpath
	 * @param namespaceURIs
	 * @return
	 */
	public Node selectSingleNode(String xpath, Map<String, String> namespaceURIs);
	/**
	 * 获取doc
	 * @author yuangenping
	 * @date 2018年9月21日
	 * @version V1.0.0
	 * @return
	 */
	public Document getDocument();
	
	/**
	 * 获取父元素
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @return
	 */
	public Element getParent();
	
	/**
	 * 获取节点文本
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @return
	 */
	public String getText();
	
	/**
	 * 设置节点文本
	 * @author yuangenping
	 * @date 2018年10月16日
	 * @version V1.0.0
	 * @param text
	 */
	public void setText(String text);
	
	/**
	 * 获取节点名称
	 * @author yuangenping
	 * @date 2018年10月9日
	 * @version V1.0.0
	 * @return
	 */
	public String getName();
}
