package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
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
        output.append(getSalesTax());
        output.append(getTotalAmount());

        return output.toString();
    }

    private String getHeader() {
        return "======Printing Orders======\n";
    }

    private String getTotalAmount() {
        StringBuilder output = new StringBuilder();
        output.append("Total Amount").append('\t').append(order.getTotalAmountWithSalesTax());
        return output.toString();
    }

    private String getSalesTax() {
        StringBuilder output = new StringBuilder();
        output.append("Sales Tax").append('\t').append(order.getTotSalesTax());
        return output.toString();
    }

    private String getLineItems() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : order.getLineItems()) {
            appendLineItem(output, lineItem);
        }
        return output.toString();
    }

    private void appendLineItem(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private String getCustomerInformation() {
        StringBuilder builder = new StringBuilder();
        builder.append(order.getCustomerName())
                .append(order.getCustomerAddress());
        return builder.toString();
    }

}