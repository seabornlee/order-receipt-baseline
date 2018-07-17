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

		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			// calculate sales tax @ rate of 10%
			totSalesTx += lineItem.getSalesTax();

			// calculate total amount of lineItem = price * quantity + 10 % sales tax
			tot += lineItem.totalAmount() + lineItem.getSalesTax();
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
		output.append("Total Amount").append('\t').append(tot);
		return output.toString();
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