package com.scb.rule;

import com.scb.entity.Record;
import com.scb.entity.Source;

public interface IRule {
	public Record select(Source s);
}
