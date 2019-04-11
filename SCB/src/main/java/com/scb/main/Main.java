package com.scb.main;

import java.util.concurrent.ConcurrentHashMap;

import com.scb.entity.Source;
import com.scb.rule.IRule;
import com.scb.rule.impl.PriorityRule;
import com.scb.util.Constants;
import com.scb.util.DataHandler;
import com.scb.util.Publisher;
import com.scb.util.Util;
import com.scb.entity.Record;

public class Main {
	public static void main(String[] args) {
		tellStory1();
		tellStory2();
	}

	private static void tellStory1() {
		System.out.println("==========story1=========");
		Record record = new Record();
		record.setLastTradingDate("15-03-2018");
		record.setDeliveryDate("17-03-2018");
		record.setMarket("LME_PB");
		Util.convertaMarket(record);
		record.setLabel("Lead 13 March 2018");
		record.setSource("LME");
		ConcurrentHashMap<String, Record> data = new ConcurrentHashMap<String, Record>();
		data.put("LME", record);
		Source s = new Source();
		s.put(data);
		IRule r = new PriorityRule();
		DataHandler handler = new DataHandler();
		handler.setRule(r);
		Record return_ = DataHandler.process(s);
		
		Publisher.pulish(return_);

		System.out.println("==========story1=========");
		System.out.println();
	}

	private static void tellStory2() {
		System.out.println("==========story2=========");

		Record record1 = new Record();
		record1.setSource("LME");
		record1.setLastTradingDate("15-03-2018");
		record1.setDeliveryDate("17-03-2018");
		record1.setMarket("LME_PB");
		record1.setLabel("Lead 13 March 2018");
		Util.convertaMarket(record1);

		Record record2 = new Record();
		record2.setSource("PRIME");
		record2.setLastTradingDate("14-03-2018");
		record2.setDeliveryDate("18-03-2018");
		record2.setMarket(Constants.EXCHANGE_CODE_MAPPING.get("LME_PB"));
		record2.setLabel("Lead 13 March 2018");
		record2.setExchangeCode("PB_03_2018");
		record2.setTradable("FALSE");
		Util.convertaMarket(record2);

		ConcurrentHashMap<String, Record> data = new ConcurrentHashMap<String, Record>();
		data.put("LME", record1);
		data.put("PRIME", record2);

		Source s = new Source();
		s.put(data);
		IRule r = new PriorityRule();
		DataHandler handler = new DataHandler();
		handler.setRule(r);
		Record return_ = DataHandler.process(s);

		Publisher.pulish(return_);

		System.out.println("==========story2=========");
	}
}
