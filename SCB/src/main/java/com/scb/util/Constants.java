package com.scb.util;

import java.util.concurrent.ConcurrentHashMap;

public class Constants {
	public static final ConcurrentHashMap<String, String> EXCHANGE_CODE_MAPPING = new ConcurrentHashMap<String, String>();

	static {
		EXCHANGE_CODE_MAPPING.put("LME_PB", "PB");
	}
}
