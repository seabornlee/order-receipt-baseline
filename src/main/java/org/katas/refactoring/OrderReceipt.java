package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt implements OrderReceiptService {
	public static final char SPLITTER = '\t';
	private Order o;

	public OrderReceipt(Order o) {
		this.o = o;
	}

	@Override
	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
//        output.append("Date - " + order.getDate();
		output.append(o.getCustomerName());
		output.append(o.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

		// prints lineItems
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : o.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append(SPLITTER);
			output.append(lineItem.getPrice());
			output.append(SPLITTER);
			output.append(lineItem.getQuantity());
			output.append(SPLITTER);
			output.append(lineItem.totalAmount());
			output.append('\n');

			// calculate sales tax @ rate of 10%
			totSalesTx += lineItem.getSalesTax();

			// calculate total amount of lineItem = price * quantity + 10 % sales tax
			tot += lineItem.totalAmount() + lineItem.getSalesTax();
		}

		// prints the state tax
		output.append("Sales Tax").append(SPLITTER).append(totSalesTx);

		// print total amount
		output.append("Total Amount").append(SPLITTER).append(tot);
		return output.toString();
	}

}