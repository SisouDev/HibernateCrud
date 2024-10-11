package org.hibernate.model;

import jakarta.persistence.*;
import org.hibernate.utils.enums.ORDER_STATUS;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ORDER_STATUS status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    private LocalDateTime orderDate;
    private Integer totalQuantity;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Order() {
    }

    public Order(ORDER_STATUS status, User user, List<Product> products, LocalDateTime orderDate, Integer totalQuantity, Double totalPrice, Address address) {
        this.status = status;
        this.user = user;
        this.products = products;
        this.orderDate = orderDate;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.address = address;
    }

    public ORDER_STATUS getStatus() {
        return status;
    }

    public void setStatus(ORDER_STATUS status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && getStatus() == order.getStatus() && Objects.equals(getUser(), order.getUser()) && Objects.equals(getProducts(), order.getProducts()) && Objects.equals(getOrderDate(), order.getOrderDate()) && Objects.equals(getTotalQuantity(), order.getTotalQuantity()) && Objects.equals(getTotalPrice(), order.getTotalPrice()) && Objects.equals(getAddress(), order.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getUser(), getProducts(), getOrderDate(), getTotalQuantity(), getTotalPrice(), getAddress());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", user=" + user +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", address=" + address +
                '}';
    }
}
