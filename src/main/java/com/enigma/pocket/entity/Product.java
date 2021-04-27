package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_products")
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String productName;
    private Double productPriceBuy;
    private Double productPriceSell;
    private String productImage;
    private Integer productStatus;
    private Timestamp createdAt;

    private Timestamp updatedAt;


    @OneToMany(mappedBy = "product")
    private List<HistoryProduct> historyProducts = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(Double productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public Double getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(Double productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<HistoryProduct> getHistoryProducts() {
        return historyProducts;
    }

    public void setHistoryProducts(List<HistoryProduct> historyProducts) {
        this.historyProducts = historyProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productPriceBuy=" + productPriceBuy +
                ", productPriceSell=" + productPriceSell +
                ", productImage='" + productImage + '\'' +
                ", productStatus=" + productStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
