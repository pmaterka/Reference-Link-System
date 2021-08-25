package com.kirg.referencelinksystem.entity;

import com.kirg.referencelinksystem.enums.offerEnums.*;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal offerCost;

    private boolean isUrgent;

    private OfferrorGroup offerrorGroup;

    private String description;

    private OptionNeedOffer optionNeedOffer;

    private OfferCategory offerCategory;

    private OfferArea offerArea;

    private OfferReason offerReason;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public OfferrorGroup getOfferrorGroup() {
        return offerrorGroup;
    }

    public void setOfferrorGroup(OfferrorGroup offerrorGroup) {
        this.offerrorGroup = offerrorGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOfferCost() {
        return offerCost;
    }

    public void setOfferCost(BigDecimal offerCost) {
        this.offerCost = offerCost;
    }

    public OptionNeedOffer getOptionNeedOffer() {
        return optionNeedOffer;
    }

    public void setOptionNeedOffer(OptionNeedOffer optionNeedOffer) {
        this.optionNeedOffer = optionNeedOffer;
    }

    public OfferCategory getOfferCategory() {
        return offerCategory;
    }

    public void setOfferCategory(OfferCategory offerCategory) {
        this.offerCategory = offerCategory;
    }

    public OfferArea getOfferArea() {
        return offerArea;
    }

    public void setOfferArea(OfferArea offerArea) {
        this.offerArea = offerArea;
    }

    public OfferReason getOfferReason() {
        return offerReason;
    }

    public void setOfferReason(OfferReason offerReason) {
        this.offerReason = offerReason;
    }


    public boolean getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
