package org.katas.refactoring;

public class LineItem {
	public static final double TAX_RATE = .10;
	private String desc;
	private double p;
	private int qty;

	public LineItem(String desc, double p, int qty) {
		super();
		this.desc = desc;
		this.p = p;
		this.qty = qty;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return p;
	}

	public int getQuantity() {
		return qty;
	}

	double totalAmount() {
		return p * qty;
	}

	double getSalesTax() {
		return totalAmount() * TAX_RATE;
	}
}