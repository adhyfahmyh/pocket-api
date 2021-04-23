package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "m_history_prices")
public class HistoryProduct {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp historyDate;
    private Integer priceBuy;
    private Integer priceSell;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"historyProducts"})
    private Product product;

    public HistoryProduct() {}
    public HistoryProduct(Product product) {
        this.historyDate = product.getUpdatedAt();
        this.priceBuy = product.getProductPriceBuy();
        this.priceSell = product.getProductPriceSell();
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Timestamp historyDate) {
        this.historyDate = historyDate;
    }

    public Integer getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Integer priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Integer getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Integer priceSell) {
        this.priceSell = priceSell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", historyDate=" + historyDate +
                ", priceBuy=" + priceBuy +
                ", priceSell=" + priceSell +
//                ", productId='" + productId + '\'' +
                '}';
    }
}
