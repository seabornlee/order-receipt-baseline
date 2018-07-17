package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(getHeader());
        output.append(getCustomerInformation());
		output.append(getLineItems());
		output.append("Sales Tax").append('\t').append(getTotSalesTax());
		output.append("Total Amount").append('\t').append(getTotalAmountWithSalesTax());
		return output.toString();
	}

	private double getTotSalesTax() {
		double totSalesTax = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			// calculate sales tax @ rate of 10%
			totSalesTax += lineItem.getSalesTax();
		}
		return totSalesTax;
	}

	private double getTotalAmountWithSalesTax() {
		double totalAmountWithSalesTax = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			totalAmountWithSalesTax += lineItem.totalAmount() + lineItem.getSalesTax();
		}
		return totalAmountWithSalesTax;
	}

	private StringBuilder getLineItems() {
		StringBuilder builder = new StringBuilder();
		for (LineItem lineItem : order.getLineItems()) {
			builder.append(getLineItem(lineItem));
		}
		return builder;
	}

	private StringBuilder getLineItem(LineItem lineItem) {
		StringBuilder output = new StringBuilder();
		output.append(lineItem.getDescription());
		output.append('\t');
		output.append(lineItem.getPrice());
		output.append('\t');
		output.append(lineItem.getQuantity());
		output.append('\t');
		output.append(lineItem.totalAmount());
		output.append('\n');
		return output;
	}

	private String getCustomerInformation() {
		return order.getCustomerName() + order.getCustomerAddress();
	}

	private String getHeader() {
		return "======Printing Orders======\n";
	}
}