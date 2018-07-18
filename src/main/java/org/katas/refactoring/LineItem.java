package org.katas.refactoring;

public class LineItem {
	private static final double TAX_RATE = .10;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
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

    double getTotSalesTax() {
        return totalAmount() * TAX_RATE;
    }

    double getTotalAmountWithTax() {
        return totalAmount() + getTotSalesTax();
    }
}