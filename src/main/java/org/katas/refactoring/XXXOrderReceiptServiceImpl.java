package org.katas.refactoring;

import java.math.BigDecimal;

public class XXXOrderReceiptServiceImpl implements OrderReceiptService {
    private Store store;

    @Override
    public String printReceipt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(header());
        stringBuilder.append(customerInformation());
        stringBuilder.append(prouducts());
        stringBuilder.append(amount());
        stringBuilder.append(salesTax());
        return stringBuilder.toString();
    }

    private BigDecimal salesTax() {
        return null;
    }

    private BigDecimal amount() {
        return null;
    }

    private String prouducts() {
        return null;
    }

    private String customerInformation() {
        return null;
    }

    private String header() {
        if (store.isCompanyOwned()) {
            return "--------xxx直营店---------";
        } else {
            return "=========xxx加盟店=========";
        }
    }

}
