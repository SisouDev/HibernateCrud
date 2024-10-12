package org.hibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.utils.enums.PRODUCT_TYPE;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private PRODUCT_TYPE type;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "DATE")
    private LocalDate createdAt;

    public Product() {
    };

    public Product(String name, String description, Double price, PRODUCT_TYPE type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PRODUCT_TYPE getType() {
        return type;
    }

    public void setType(PRODUCT_TYPE type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && getType() == product.getType() && Objects.equals(getCreatedAt(), product.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getType(), getCreatedAt());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }
}
