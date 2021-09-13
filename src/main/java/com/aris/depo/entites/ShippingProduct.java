package com.aris.depo.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipping_product")
public class ShippingProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long shippingNumber;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean deleted;
    private LocalDateTime createDate;
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product Product;

    public ShippingProduct() {

    }

    public long getId() {
        return id;
    }

    public ShippingProduct setId(long id) {
        this.id = id;
        return this;
    }

    public long getShippingNumber() {
        return shippingNumber;
    }

    public ShippingProduct setShippingNumber(long shippingNumber) {
        this.shippingNumber = shippingNumber;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public ShippingProduct setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public ShippingProduct setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShippingProduct setUser(User user) {
        this.user = user;
        return this;
    }

    public com.aris.depo.entites.Product getProduct() {
        return Product;
    }

    public ShippingProduct setProduct(com.aris.depo.entites.Product product) {
        Product = product;
        return this;
    }

    @Override
    public String toString() {
        return "ShippingProduct{" +
                "id=" + id +
                ", shippingNumber=" + shippingNumber +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                ", user=" + user +
                ", Product=" + Product +
                '}';
    }
}
