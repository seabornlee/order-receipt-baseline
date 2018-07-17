package org.katas.refactoring;

import java.util.stream.Collectors;

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

    private StringBuilder getTotalAmount() {
        StringBuilder builder = new StringBuilder();
        builder.append("Total Amount").append('\t').append(getTotalAmountWithSalesTax());
        return builder;
    }

    private StringBuilder getSalesTax() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sales Tax").append('\t').append(getTotSalesTax());
        return builder;
    }

    private double getTotSalesTax() {
        return order.getLineItems().stream().mapToDouble(l -> l.getSalesTax()).sum();
    }

    private double getTotalAmountWithSalesTax() {
        return order.getLineItems().stream().mapToDouble(l -> getTotalAmountWithSalesTax(l)).sum();
    }

    private double getTotalAmountWithSalesTax(LineItem l) {
        return l.totalAmount() + l.getSalesTax();
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