package org.katas.refactoring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderReceiptTest {
    @Test
    public void shouldPrintCustomerInformationOnOrder() {
        // given
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        // when
        String output = receipt.printReceipt();

        // then
        assertThat(output).contains("Mr X");
        assertThat(output).contains("Chicago, 60601");
    }

    @Test
    public void shouldPrintLineItems() {
        // given
        List<LineItem> lineItems = asList(
                new LineItem("milk", 10.0, 2),
                new LineItem("biscuits", 5.0, 5),
                new LineItem("chocolate", 20.0, 1)
        );
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        // when
        String output = receipt.printReceipt();

        // then
        assertThat(output).contains("milk\t10.0\t2\t20.0\n");
        assertThat(output).contains("biscuits\t5.0\t5\t25.0\n");
        assertThat(output).contains("chocolate\t20.0\t1\t20.0\n");
    }

    @Test
    public void shouldPrintSalesTaxInformation() {
        // given
        Order order = new Order(null, null, Collections.<LineItem>emptyList()) {

            @Override
            double getTotalAmountWithSalesTax() {
                return 22;
            }

            @Override
            double getTotalSalesTax() {
                return 2;
            }
        };

        OrderReceipt receipt = new OrderReceipt(order);

        // when
        String output = receipt.printReceipt();

        // then
        assertThat(output).contains("Sales Tax\t2");
        assertThat(output).contains("Total Amount\t22");
    }

    @Test
    public void shouldPrintSalesTaxInformationWithMockito() {
        // given
        Order order = mock(Order.class);
        when(order.getTotalSalesTax()).thenReturn(2d);
        when(order.getTotalAmountWithSalesTax()).thenReturn(22d);

        OrderReceipt receipt = new OrderReceipt(order);

        // when
        String output = receipt.printReceipt();

        // then
        assertThat(output).contains("Sales Tax\t2");
        assertThat(output).contains("Total Amount\t22");
    }
}
