package org.katas.refactoring;

public class Store {

    public static final String TYPE_COMPANY_OWNED = "01";
    private String location;

    public String getType() {
        return type;
    }

    private String type;


    boolean isCompanyOwned() {
        return TYPE_COMPANY_OWNED.equals(getType()) &&
                                 "China".equals(location);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
