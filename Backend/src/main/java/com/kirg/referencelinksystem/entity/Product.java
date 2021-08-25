package com.kirg.referencelinksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "The product name must not be null.")
    private String name;

    private String description;

    @NotNull
    @Min(value = 0, message = "The product unit must not be less than zero.")
    private Integer quantity;

    @NotNull
    @Min(value = 0, message = "The product price must not be less than zero.")
    private BigDecimal realPrice;

    @NotNull
    @Min(value = 0, message = "The product price must not be less than zero.")
    private BigDecimal offeredPrice;

    //potrzebne do weryfikacji przez admina
    private boolean approvedByAmin = false;

    public boolean isApprovedByAmin() {
        return approvedByAmin;
    }

    public void setApprovedByAmin(boolean approvedByAmin) {
        this.approvedByAmin = approvedByAmin;
    }

    public BigDecimal getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(BigDecimal offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal price) {
        this.realPrice = price;
    }



}
