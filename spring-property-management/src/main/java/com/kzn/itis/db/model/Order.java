package com.kzn.itis.db.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="orders")
public class Order implements Serializable {

    private int id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int customerId;

    @Column(name = "customerId")
    @Basic
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int salesPersonalId;

    @Column(name = "salesPersonalId")
    @Basic
    public int getSalesPersonalId() {
        return salesPersonalId;
    }

    public void setSalesPersonalId(int salesPersonalId) {
        this.salesPersonalId = salesPersonalId;
    }

    private int totalAmount;

    @Column(name = "totalAmount")
    @Basic
    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (customerId != order.customerId) return false;
        if (id != order.id) return false;
        if (salesPersonalId != order.salesPersonalId) return false;
        if (totalAmount != order.totalAmount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerId;
        result = 31 * result + salesPersonalId;
        result = 31 * result + totalAmount;
        return result;
    }
}
