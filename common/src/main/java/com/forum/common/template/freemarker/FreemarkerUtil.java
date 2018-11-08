package com.forum.common.template.freemarker;

import java.io.StringWriter;
import java.util.ResourceBundle;


import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-13
 * @version V1.0.0
 */
public class FreemarkerUtil {
	private static Configuration cfg = null;
	private FreemarkerUtil(){
		
	}
	public static String formatTemplate(String templateName,Object params) throws Exception{
		if(cfg == null){
			// 通过Freemaker的Configuration读取相应的ftl
			cfg = new Configuration(Configuration.VERSION_2_3_0);
			// 设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/templates/freemarker");
			//设置公用java bean变量
			ResourceBundle variables = ResourceBundle.getBundle("templates/freemarker"+"/variables");
			for (String key : variables.keySet()) {
				cfg.setSharedVariable(key, Class.forName(variables.getString(key)).newInstance());
			}
		}
		StringWriter swriter = new StringWriter();
		// 在模板文件目录中找到名称为name的文件
		Template temp = cfg.getTemplate(templateName);
		temp.process(params, swriter);
		return swriter.toString();
	}
}
