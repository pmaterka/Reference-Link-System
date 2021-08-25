package com.kirg.referencelinksystem.controller;

import com.kirg.referencelinksystem.entity.Offer;
import com.kirg.referencelinksystem.entity.Product;
import com.kirg.referencelinksystem.entity.UserWithHeart;
import com.kirg.referencelinksystem.entity.UserWithHeart;
import com.kirg.referencelinksystem.service.UserWithHeartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userwithheart")
public class UserWithHeartController {
    private UserWithHeartService userWithHeartService;

    public UserWithHeartController(UserWithHeartService userWithHeartService) {
        this.userWithHeartService = userWithHeartService;
    }

    @PostMapping
    public UserWithHeart addUserWithHeart(@Valid @RequestBody UserWithHeart userWithHeart) {
        return userWithHeartService.addUserWithHeart(userWithHeart);
    }

    //trzeba to przetestować
    @PutMapping("/{id}")
    public ResponseEntity<UserWithHeart> addHeartPoints (@Valid @RequestBody UserWithHeart userWithHeart, @PathVariable Long id) {
        UserWithHeart beforeUpdate = userWithHeartService.getById(id);
        List<Offer> offerList=beforeUpdate.getWhatDoIOffer();
        for (Offer offer : offerList) {
            List<Product> productList = offer.getProductList();
            beforeUpdate.setHeartPoints(userWithHeartService.addHeartPoints(productList));
        }
        UserWithHeart afterUpdate = userWithHeartService.addUserWithHeart(beforeUpdate);
        return ResponseEntity.ok(afterUpdate);
    }




}
