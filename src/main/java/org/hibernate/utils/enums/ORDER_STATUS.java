package org.hibernate.utils.enums;

public enum ORDER_STATUS {
    PENDING("Pending"),
    PROCESSING("Processing"),
    APPROVED("Approved"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private String value;

    private ORDER_STATUS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
