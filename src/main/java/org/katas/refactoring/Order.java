package org.katas.refactoring;

import java.util.List;

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

    double getTotSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getTotSalesTax).sum();
    }

    double getTotalAmountWithTax() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalAmountWithTax).sum();
    }

}
