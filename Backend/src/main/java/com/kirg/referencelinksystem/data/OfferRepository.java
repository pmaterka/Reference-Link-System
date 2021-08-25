package com.kirg.referencelinksystem.data;


import com.kirg.referencelinksystem.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

}
