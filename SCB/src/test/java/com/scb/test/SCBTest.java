package com.scb.test;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.scb.entity.Record;
import com.scb.entity.Source;
import com.scb.rule.IRule;
import com.scb.rule.impl.PriorityRule;
import com.scb.util.Constants;
import com.scb.util.DataHandler;
import com.scb.util.Publisher;
import com.scb.util.Util;
import junit.framework.Assert;

public class SCBTest {
	@Test
	public void testOneNullInput() {
		boolean isfine = true;
		try {
			Record record = new Record();
			ConcurrentHashMap<String, Record> data = new ConcurrentHashMap<String, Record>();
			data.put("LME", record);
			Source s = new Source();
			s.put(data);
			IRule r = new PriorityRule();
			DataHandler handler = new DataHandler();
			handler.setRule(r);
			Record return_ = DataHandler.process(s);
			Publisher.pulish(return_);
		} catch (Exception e) {
			isfine = false;
		}
		Assert.assertTrue(isfine);
	}

	@Test
	public void testTwoNullInput() {
		boolean isfine = true;
		try {
			Record record1 = new Record();
			Record record2 = new Record();
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
		} catch (Exception e) {
			isfine = false;
		}
		Assert.assertTrue(isfine);
	}

	@Test
	public void testMutipleInput() {

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

		Record record3 = new Record();

		ConcurrentHashMap<String, Record> data = new ConcurrentHashMap<String, Record>();
		data.put("LME", record1);
		data.put("PRIME", record2);
		data.put("123", record3);

		Source s = new Source();
		s.put(data);
		IRule r = new PriorityRule();
		DataHandler handler = new DataHandler();
		handler.setRule(r);
		Record return_ = DataHandler.process(s);

		Publisher.pulish(return_);

	}

}
