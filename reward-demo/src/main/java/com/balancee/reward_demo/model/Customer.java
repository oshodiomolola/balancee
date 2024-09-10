package com.balancee.reward_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "Created at is mandatory")
    private LocalDateTime createdAt;

    @Column(name = "total_cashback", nullable = false)
    @NotNull(message = "Total cashback is mandatory")
    private double totalCashback;

    public Customer() {
    }

    public Customer(String name, String email, LocalDateTime createdAt, double totalCashback) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.totalCashback = totalCashback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotalCashback() {
        return totalCashback;
    }

    public void setTotalCashback(double totalCashback) {
        this.totalCashback = totalCashback;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", totalCashback=" + totalCashback +
                '}';
    }
}
