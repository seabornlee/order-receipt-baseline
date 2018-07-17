package org.katas.refactoring;

import java.util.List;

import static java.util.stream.Collectors.summingDouble;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotSalesTax() {
        return getLineItems().stream().collect(summingDouble(LineItem::getSalesTax));
    }

    public double getTotalAmountWithSalesTax() {
        return getLineItems().stream().collect(summingDouble(LineItem::getTotalAmountWithSalesTax));
    }
}
