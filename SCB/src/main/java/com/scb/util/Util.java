package com.scb.util;

import com.scb.entity.Record;

public class Util {
	public static void convertaMarket(Record record) {
		record.setMarket(Constants.EXCHANGE_CODE_MAPPING.get("LME_PB"));
	}
}
