package org.katas.refactoring;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void getTotalAmountWithSalesTax() {
        Order order = new Order("", "", Arrays.asList(
                new LineItem("", 2, 5),
                new LineItem("", 3, 4)));

        double totalAmountWithSalesTax = order.getTotalAmountWithSalesTax();

        assertEquals(24.2, totalAmountWithSalesTax, Double.MIN_VALUE);
    }
}