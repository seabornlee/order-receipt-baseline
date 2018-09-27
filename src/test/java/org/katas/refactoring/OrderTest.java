package org.katas.refactoring;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OrderTest {
    @Test
    public void 计算总共销售税() {
        Order order = new Order(null, null, Arrays.asList(
                new LineItem("milk", 10, 2),
                new LineItem("cake", 8, 1)
        ));
        double totalSalesTax = order.getTotalSalesTax();
        assertThat(totalSalesTax).isEqualTo(2.8);
    }

    @Test
    public void 计算含税的总金额() {
        Order order = new Order(null, null, Arrays.asList(
                new LineItem("milk", 10, 2),
                new LineItem("cake", 8, 1)
        ));
        double totalSalesTax = order.getTotalAmountWithSalesTax();
        assertThat(totalSalesTax).isEqualTo(30.8);
    }
}