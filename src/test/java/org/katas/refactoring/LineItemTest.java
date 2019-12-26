package org.katas.refactoring;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineItemTest {

    @Test
    public void getSalesTax() {
        LineItem lineItem = new LineItem("", 2, 5);
        double salesTax = lineItem.getSalesTax();
        assertEquals(1, salesTax, Double.MIN_VALUE);
    }
}