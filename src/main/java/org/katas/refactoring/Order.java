package org.katas.refactoring;

import java.util.List;

import static java.util.stream.Collectors.summingDouble;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> lineItems;

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

    double getTotSalesTax() {
        return getLineItems().stream().collect(summingDouble(LineItem::getSalesTax));
    }

    double getTotalAmountWithSalesTax() {
        return getLineItems().stream().collect(summingDouble(LineItem::getTotalAmountWithSalesTax));
    }
}
