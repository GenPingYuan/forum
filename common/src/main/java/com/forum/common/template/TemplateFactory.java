package com.forum.common.template;

import com.forum.common.template.freemarker.FreemarkerUtil;

/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-13
 * @version V1.0.0
 */
public class TemplateFactory {
	public enum TemplateType{
		FREEMARKER
	}
	
	public static String formatTemplate(TemplateType type,String templateName,Object params) throws Exception{
		String result = null;
		switch (type) {
		case FREEMARKER:
			result = FreemarkerUtil.formatTemplate(templateName, params);
			break;

		default:
			break;
		}
		return result;
	}
}
