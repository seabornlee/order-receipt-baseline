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

        appendHeader(output);
        appendCustomerInformation(output);
        appendLineItems(output);
        appendSalesTax(output);
        appendTotalAmount(output);

        return output.toString();
    }

    private void appendTotalAmount(StringBuilder output) {
        output.append("Total Amount").append('\t').append(getTotalAmountWithSalesTax());
    }

    private void appendSalesTax(StringBuilder output) {
        output.append("Sales Tax").append('\t').append(getTotSalesTax());
    }

    private double getTotSalesTax() {
        return order.getLineItems().stream().mapToDouble(l -> l.getSalesTax()).sum();
    }

    private double getTotalAmountWithSalesTax() {
        return order.getLineItems().stream().mapToDouble(l -> l.getTotalAmountWithSalesTax()).sum();
    }

    private void appendLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            appendLineItem(output, lineItem);
        }
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

    private void appendCustomerInformation(StringBuilder output) {
        output.append(order.getCustomerName()).append(order.getCustomerAddress());
    }

    private void appendHeader(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }

}