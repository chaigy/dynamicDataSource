package com.cgy.mvc.dynamic;

public class DynamicDataSourceHandler {
	
	/**
	 * 	设置数据源的标示信息
	 */
	private static final ThreadLocal<String> contextHandler = new ThreadLocal<>();
	
	
	public static String getDataType() {
		return contextHandler.get();
	}
	
	public static void setDataType(String dataType) {
		contextHandler.set(dataType);
	}
	
	public static void clear() {
		contextHandler.remove();
	}
}
