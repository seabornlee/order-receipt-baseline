package org.katas.refactoring;

import java.util.List;

public class Order {
    String nm;
    String addr;
    List<LineItem> li;

    public Order(String nm, String addr, List<LineItem> li) {
        this.nm = nm;
        this.addr = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return nm;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return li;
    }

    double getTotalAmountWithSalesTax() {
        double totalAmountWithSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
// calculate total amount of lineItem = price * quantity + 10 % sales tax
totalAmountWithSalesTax += lineItem.totalAmount() + lineItem.getSalesTax();
        }
        return totalAmountWithSalesTax;
    }

    double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            // calculate sales tax @ rate of 10%
            totalSalesTax += lineItem.getSalesTax();
        }
        return totalSalesTax;
    }
}
