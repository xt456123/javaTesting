package com.scb.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Record implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7754504696969896319L;
	private String source;
	private String lastTradingDate;
	private String deliveryDate;
	private String market;
	private String label;
	private String exchangeCode;
	private String tradable = "TRUE";

	public Record() {
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLastTradingDate() {
		return lastTradingDate;
	}

	public void setLastTradingDate(String lastTradingDate) {
		this.lastTradingDate = lastTradingDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public String getTradable() {
		return tradable;
	}

	public void setTradable(String tradable) {
		this.tradable = tradable;
	}

	@Override
	public String toString() {
		return "Record [lastTradingDate=" + lastTradingDate + ", deliveryDate=" + deliveryDate + ", market=" + market
				+ ", label=" + label + ", tradable=" + tradable + "]";
	}

}
