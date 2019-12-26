package org.katas.refactoring;

import java.util.List;

import static java.util.stream.Collectors.summingDouble;

class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

    Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    List<LineItem> getLineItems() {
        return lineItems;
    }

    double getTotSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    double getTotalAmountWithSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalAmountWithSalesTax).sum();
    }
}
