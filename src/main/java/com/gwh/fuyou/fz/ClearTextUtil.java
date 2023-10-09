package com.gwh.fuyou.fz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ClearTextUtil {

	public static final String SIGNATURE_SEPARATOR = "&";

	public static String generateClearText(Object obj){
		List<String> excludeFieldList = new ArrayList<>();
		excludeFieldList.add("signature");
		excludeFieldList.add("list");
		return generateClearText(obj, excludeFieldList);
	}

	public static String generateClearText(Object obj, List<String> excludeFieldList) {
		return generateClearText(obj, excludeFieldList, true);
	}

	public static String generateClearTextExcludeNullField(Object obj, List<String> excludeFieldList){
		return generateClearText(obj, excludeFieldList, false);
	}

	public static String generateClearText(Object obj, List<String> excludeFieldList, Boolean includeNullField){
		if(obj == null){
			throw new RuntimeException("参数不合法");
		}

		List<String> fieldList = ReflectUtil.getPrivateFields(obj.getClass(), excludeFieldList);
		if(fieldList==null || fieldList.isEmpty()){
			throw new RuntimeException("参与签名的字段异常");
		}

		Collections.sort(fieldList);
		StringBuffer sb = new StringBuffer();

		for (String fieldName : fieldList) {
			Object value = ReflectUtil.getFieldValue(fieldName, obj);
			String s = appendField(fieldName, value, includeNullField);
			sb.append(s);
		}

		return sb.substring(0, sb.length() - 1);
	}


	private static String appendField(String fieldName, Object value, Boolean includeNullField){
		StringBuffer sb = new StringBuffer();

		if(value == null || "".equals(value)){
			if(!includeNullField){
				return StringUtils.EMPTY;
			}
			sb.append(fieldName).append("=");
		}else{
			sb.append(fieldName).append("=").append(value);
		}

		sb.append("&");
		return sb.toString();
	}

}
