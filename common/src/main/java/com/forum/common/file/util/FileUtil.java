package com.forum.common.file.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;

/**
 * 文件处理工具类
 * @Copyright Copyright (c) 2017 版权归作者及其公司所有
 * @author li.ming
 * @date 2017-12-12
 * @version V1.0.0
 */
public class FileUtil extends FileUtils{
	/**
	 * 转换文件编码
	 * @author yuangenping
	 * @date 2018年9月26日
	 * @version V1.0.0
	 * @param filePath 源文件名
	 * @param charset 目标编码
	 * @throws IOException
	 */
	public static void changeFileEncoding(String filePath, String charset) throws IOException {
		changeFileEncoding(filePath, null, true, charset);
	}
	
	/**
	 * 转换文件编码
	 * @author yuangenping
	 * @date 2018年9月26日
	 * @version V1.0.0
	 * @param filePath 源文件名
	 * @param extensions 文件扩展名
	 * @param recursive 是否递归子目录
	 * @param charset 目标编码
	 * @throws IOException
	 */
	public static void changeFileEncoding(String filePath, String[] extensions, boolean recursive, String charset) throws IOException {
		File source = new File(filePath);
		Collection<File> files = null;
		if(source.isDirectory()) {
			files = FileUtils.listFiles(source, new String[] {"java"}, true);
		}else {
			files = new LinkedList<>();
			files.add(source);
		}
		for (File file : files) {
			FileUtils.writeStringToFile(file, FileUtils.readFileToString(file, EncodingDetect.getJavaEncode(file.getPath())), charset);
		}
	}
	public static void main(String[] args) throws IOException {
		String path = "E:\\Workspaces\\Eclipse\\spring-cloud\\spring-cloud-common\\src";
		String charset = "UTF-8";
		changeFileEncoding(path, new String[] {"java"}, true, charset);
	}
}
