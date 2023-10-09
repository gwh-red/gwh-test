package com.gwh.fuyou.fz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

public class ReflectUtil {


    public static String generateGetMethod(String fieldName) {
        char firstChar = fieldName.charAt(0);
        String firstStr = String.valueOf(firstChar);
        return "get" + firstStr.toUpperCase() + fieldName.substring(1, fieldName.length());
    }

    public static Object getFieldValue(String fieldName, Object obj) throws RuntimeException {
        String getMethodName = generateGetMethod(fieldName);
        Class<?> clazz = obj.getClass();
        try {
            Method declaredMethod = MethodUtils.getAccessibleMethod(clazz, getMethodName, new Class[0]);
            return declaredMethod.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<String> getPrivateFields(Class<?> clazz) {
        return getPrivateFields(clazz, null);
    }

    public static List<String> getPrivateFields(Class<?> clazz, List<String> excludeFieldList) {
        Field[] declaredFields = FieldUtils.getAllFields(clazz);
        List<String> fieldNameList = new ArrayList<String>();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers)) {
                continue;
            }
            if (!Modifier.isPrivate(modifiers)) {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                continue;
            }
            String fieldName = field.getName();
            if ((excludeFieldList != null && !excludeFieldList.isEmpty()) && excludeFieldList.contains(fieldName)) {
                continue;
            }
            fieldNameList.add(fieldName);
        }
        HashSet<String> h = new HashSet<String>(fieldNameList);
        fieldNameList.clear();
        fieldNameList.addAll(h);
        return fieldNameList;
    }
}