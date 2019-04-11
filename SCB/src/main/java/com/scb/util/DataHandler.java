package com.scb.util;

import com.scb.entity.Record;
import com.scb.entity.Source;
import com.scb.rule.IRule;

public class DataHandler {
	private static IRule rule;

	public static Record process(Source s) {
		return getRule().select(s);
	}

	private static IRule getRule() {
		return rule;
	}

	public void setRule(IRule rule_) {
		DataHandler.rule = rule_;
	}

}
