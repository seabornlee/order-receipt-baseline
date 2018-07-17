package org.katas.refactoring;

public class LineItem {
    private static final double SALES_RATE = .10;
    private String desc;
	private double price;
	private int quantity;

	public LineItem(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

    public double getSalesTax() {
        return totalAmount() * SALES_RATE;
    }

    public double getTotalAmountWithSalesTax() {
        return totalAmount() + getSalesTax();
    }
}