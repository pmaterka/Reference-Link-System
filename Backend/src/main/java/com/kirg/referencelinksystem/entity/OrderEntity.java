package com.kirg.referencelinksystem.entity;



import com.kirg.referencelinksystem.enums.offerEnums.OfferPayment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @NotNull
    private BigDecimal grandTotal;

    private LocalDate dateOfOrder = LocalDate.now();

    @OneToOne
    private Address address;

    @OneToOne
    private UserWithHeart userWithHeart;

    private OfferPayment offerPayment;

    @OneToMany
    private List<Offer> offers;


    public Long getId() {
        return id;
    }



    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserWithHeart getUserWithHeart() {
        return userWithHeart;
    }

    public void setUserWithHeart(UserWithHeart userWithHeart) {
        this.userWithHeart = userWithHeart;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public OfferPayment getOfferPayment() {
        return offerPayment;
    }

    public void setOfferPayment(OfferPayment offerPayment) {
        this.offerPayment = offerPayment;
    }
}
