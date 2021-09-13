package com.aris.depo.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marka;
    private String model;
    private int quantity;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean deleted;
    private LocalDateTime creatDate;

    public Product() {

    }

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getMarka() {
        return marka;
    }

    public Product setMarka(String marka) {
        this.marka = marka;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Product setModel(String model) {
        this.model = model;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Product setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreatDate() {
        return creatDate;
    }

    public Product setCreatDate(LocalDateTime creatDate) {
        this.creatDate = creatDate;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", quantity=" + quantity +
                ", deleted=" + deleted +
                ", creatDate=" + creatDate +
                '}';
    }
}
