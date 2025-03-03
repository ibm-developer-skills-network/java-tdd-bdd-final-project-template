package com.productstore.service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "Price cannot be null")
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean available = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category = Category.UNKNOWN;

    public enum Category {
        UNKNOWN, 
        CLOTHS, 
        FOOD, 
        HOUSEWARES, 
        AUTOMOTIVE, 
        TOOLS
    }

    // Constructor with required fields
    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Constructor with all fields except id
    public Product(String name, String description, BigDecimal price, Boolean available, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}