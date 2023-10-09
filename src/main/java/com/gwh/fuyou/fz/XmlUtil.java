package com.gwh.fuyou.fz;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

	private static final ObjectMapper xmlMapper = new XmlMapper();

	public static <T> T xml2Bean(String xmlText, Class<T> clazz) throws Exception {
		return xmlMapper.readValue(xmlText, clazz);
	}

	public static <T> String bean2Xml(T bean) throws Exception{
		return xmlMapper.writeValueAsString(bean);
	}

}
