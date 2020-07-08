package org.katas.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StoreTest {

    @Test
    public void testIsCompanyOwned() {
        Store store = new Store();
        store.setType(Store.TYPE_COMPANY_OWNED);
        store.setLocation("China");
        assertTrue(store.isCompanyOwned());
    }

    @Test
    public void testIsNotCompanyOwned() {
        Store store = new Store();
        store.setType("00");
        assertFalse(store.isCompanyOwned());

        store.setType(Store.TYPE_COMPANY_OWNED);
        store.setLocation("USA");
        assertFalse(store.isCompanyOwned());
    }
}