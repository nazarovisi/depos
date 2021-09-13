package com.aris.depo.entites.views;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "view_shipping_product")
public class ViewShippingProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idUser;
    //    ----------------------User-----------------
    private String userSurname;
    private String userFirstname;
//    ----------------------Product-----------------
private String productMarka;
    private String productModel;
    private int productQuantity;
    private long idProduct;
    private long shippingNumber;
    private boolean deleted;
    private LocalDateTime createDate;

    public ViewShippingProduct() {

    }

    public long getId() {
        return id;
    }

    public ViewShippingProduct setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdUser() {
        return idUser;
    }

    public ViewShippingProduct setIdUser(long idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public ViewShippingProduct setUserSurname(String userSurname) {
        this.userSurname = userSurname;
        return this;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public ViewShippingProduct setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
        return this;
    }

    public String getProductMarka() {
        return productMarka;
    }

    public ViewShippingProduct setProductMarka(String productMarka) {
        this.productMarka = productMarka;
        return this;
    }

    public String getProductModel() {
        return productModel;
    }

    public ViewShippingProduct setProductModel(String productModel) {
        this.productModel = productModel;
        return this;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public ViewShippingProduct setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
        return this;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public ViewShippingProduct setIdProduct(long idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public long getShippingNumber() {
        return shippingNumber;
    }

    public ViewShippingProduct setShippingNumber(long shippingNumber) {
        this.shippingNumber = shippingNumber;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public ViewShippingProduct setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public ViewShippingProduct setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    @Override
    public String toString() {
        return "ViewShippingProduct{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", userSurname='" + userSurname + '\'' +
                ", userFirstname='" + userFirstname + '\'' +
                ", productMarka='" + productMarka + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productQuantity=" + productQuantity +
                ", idProduct=" + idProduct +
                ", shippingNumber=" + shippingNumber +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                '}';
    }
}
