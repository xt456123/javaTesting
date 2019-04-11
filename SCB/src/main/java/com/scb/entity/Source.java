package com.scb.entity;

import java.util.concurrent.ConcurrentHashMap;

public class Source {
	private ConcurrentHashMap<String, Record> record_list = new ConcurrentHashMap<String, Record>();

	public void put(ConcurrentHashMap<String, Record> map) {
		record_list = map;
	}

	public ConcurrentHashMap<String, Record> getData() {
		return record_list;
	}

	public void putData(ConcurrentHashMap<String, Record> record_list) {
		this.record_list = record_list;
	}

}
