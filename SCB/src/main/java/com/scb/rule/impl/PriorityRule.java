package com.scb.rule.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.scb.entity.Record;
import com.scb.entity.Source;
import com.scb.rule.IRule;

public class PriorityRule implements IRule {
	private static HashMap<String, String> dataMap = new HashMap<String, String>();
	static {
		dataMap.put("LME", "LastTradingDate,DeliveryDate,Market,Label");
		dataMap.put("PRIME", "Tradable");
	}

	@Override
	public Record select(Source s) {
		Record return_ = new Record();
		ConcurrentHashMap<String, Record> data = s.getData();
		Set<String> keySet = dataMap.keySet();
		for (String from : keySet) {
			Record r = data.get(from);
			if (r == null) {
				r = new Record();
			}
			List<String> fieldsMethod = new ArrayList<String>();
			String[] field_list = dataMap.get(from).split(",");
			for (String method : field_list) {
				fieldsMethod.add(method);
			}
			for (String name : fieldsMethod) {
				try {
					Method getMethod = Record.class.getMethod("get" + name);
					Method setMethod = Record.class.getMethod("set" + name, String.class);
					Object invoke = getMethod.invoke(r);
					setMethod.invoke(return_, invoke);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}

		}
		return return_;

	}

}
