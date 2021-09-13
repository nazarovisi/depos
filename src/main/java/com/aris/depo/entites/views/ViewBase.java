package com.aris.depo.entites.views;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "view_base")
public class ViewBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long idShipping;
    private long numberShipping;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean deleted;
    private LocalDateTime createDate;

    public ViewBase() {

    }

    public long getId() {
        return id;
    }

    public ViewBase setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ViewBase setName(String name) {
        this.name = name;
        return this;
    }

    public long getIdShipping() {
        return idShipping;
    }

    public ViewBase setIdShipping(long idShipping) {
        this.idShipping = idShipping;
        return this;
    }

    public long getNumberShipping() {
        return numberShipping;
    }

    public ViewBase setNumberShipping(long numberShipping) {
        this.numberShipping = numberShipping;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public ViewBase setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public ViewBase setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    @Override
    public String toString() {
        return "viewBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idShipping=" + idShipping +
                ", numberShipping=" + numberShipping +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                '}';
    }
}
