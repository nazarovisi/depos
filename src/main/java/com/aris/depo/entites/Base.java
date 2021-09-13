package com.aris.depo.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "base")
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean deleted;
    private LocalDateTime createDate;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "id_shipping", referencedColumnName = "id")
    private ShippingProduct shippingProduct;

    public Base() {

    }

    public long getId() {
        return id;
    }

    public Base setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Base setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Base setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Base setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public ShippingProduct getShippingProduct() {
        return shippingProduct;
    }

    public Base setShippingProduct(ShippingProduct shippingProduct) {
        this.shippingProduct = shippingProduct;
        return this;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                ", shippingProduct=" + shippingProduct +
                '}';
    }
}
