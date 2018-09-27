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

		printHeaders(output);
		printCustomerInformation(output);
		printsLineItems(output);
		printSalesTaxInformation(output);

		return output.toString();
	}

	private void printHeaders(StringBuilder output) {
		output.append("======Printing Orders======\n");
	}

	private void printCustomerInformation(StringBuilder output) {
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
	}

	private void printsLineItems(StringBuilder output) {
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');
		}
	}

	private void printSalesTaxInformation(StringBuilder output) {
		output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
		output.append("Total Amount").append('\t').append(order.getTotalAmountWithSalesTax());
	}

}