package com.enigma.pocket.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String productId;

    public HistoryProduct() {}
    public HistoryProduct(Product product) {
        this.historyDate = product.getUpdatedAt();
        this.priceBuy = product.getProductPriceBuy();
        this.priceSell = product.getProductPriceSell();
        this.productId = product.getId();
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

//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }

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
