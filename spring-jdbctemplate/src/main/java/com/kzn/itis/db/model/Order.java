package com.kzn.itis.db.model;


public class Order {

    public Order(String name, int customerId, int salesPersonalId) {
        this.name = name;
        this.customerId = customerId;
        SalesPersonalId = salesPersonalId;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int SalesPersonalId;

    public int getSalesPersonalId() {
        return SalesPersonalId;
    }

    public void setSalesPersonalId(int salersPersonalId) {
        SalesPersonalId = salersPersonalId;
    }

    private int totalAmount;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
