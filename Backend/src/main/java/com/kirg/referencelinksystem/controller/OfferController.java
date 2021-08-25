package com.kirg.referencelinksystem.controller;

import com.kirg.referencelinksystem.entity.Offer;
import com.kirg.referencelinksystem.entity.Product;
import com.kirg.referencelinksystem.service.OfferService;
import com.kirg.referencelinksystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/offer")
public class OfferController {

    private OfferService offerService;
    private ProductService productService;

    public OfferController(OfferService offerService, ProductService productService) {
        this.offerService = offerService;
        this.productService = productService;
    }

    @GetMapping
    public List<Offer> findAll() {
        return offerService.findAll();
    }

    @PostMapping
    public Offer save(@Valid @RequestBody Offer offer) {
        return offerService.save(offer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> update (@Valid @RequestBody Offer offer, @PathVariable Long id) {
        Offer beforeUpdate = offerService.getById(id);
        beforeUpdate.setName(offer.getName());
        beforeUpdate.setOfferArea(offer.getOfferArea());
        beforeUpdate.setOfferCategory(offer.getOfferCategory());
        beforeUpdate.setOfferCost(offer.getOfferCost());
        beforeUpdate.setDescription(offer.getDescription());
        beforeUpdate.setOfferReason(offer.getOfferReason());
        beforeUpdate.setOfferrorGroup(offer.getOfferrorGroup());
        beforeUpdate.setOptionNeedOffer(offer.getOptionNeedOffer());
        beforeUpdate.setProductList(offer.getProductList());
        beforeUpdate.setIsUrgent(offer.getIsUrgent());
        Offer afterUpdate = offerService.save(beforeUpdate);
        return ResponseEntity.ok(afterUpdate);
    }

    @GetMapping("/{id}")
    public Optional<Offer> findById(@PathVariable Long id) {
        return offerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offerService.deleteById(id);
    }


}
