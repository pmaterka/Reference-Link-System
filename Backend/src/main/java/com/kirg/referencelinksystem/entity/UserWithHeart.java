package com.kirg.referencelinksystem.entity;

import com.kirg.referencelinksystem.enums.userEnums.LifeQuality;
import com.kirg.referencelinksystem.enums.userEnums.UserSituation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
public class UserWithHeart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String phoneNum;

    @NotEmpty
    private String email;

    private UserSituation userSituation;

    private LifeQuality lifeQuality;

    @OneToMany
    private List<ReferenceLink> referenceLinkList;

    @NotEmpty
    private String birthDate;

    @NotEmpty
    @OneToOne
    private Address address;

    @OneToMany
    private List<Offer> whatDoIOffer;

    private BigDecimal heartPoints=BigDecimal.ZERO;


    public BigDecimal getHeartPoints() {
        return heartPoints;
    }

    public void setHeartPoints(BigDecimal heartPoints) {
        this.heartPoints = heartPoints;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSituation getUserSituation() {
        return userSituation;
    }

    public void setUserSituation(UserSituation userSituation) {
        this.userSituation = userSituation;
    }

    public LifeQuality getLifeQuality() {
        return lifeQuality;
    }

    public void setLifeQuality(LifeQuality lifeQuality) {
        this.lifeQuality = lifeQuality;
    }

    public List<ReferenceLink> getReferenceLinkList() {
        return referenceLinkList;
    }

    public void setReferenceLinkList(List<ReferenceLink> referenceLinkList) {
        this.referenceLinkList = referenceLinkList;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Offer> getWhatDoIOffer() {
        return whatDoIOffer;
    }

    public void setWhatDoIOffer(List<Offer> whatDoIOffer) {
        this.whatDoIOffer = whatDoIOffer;
    }


}
