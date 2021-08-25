package com.kirg.referencelinksystem.service;

import com.kirg.referencelinksystem.data.UserWithHeartRepository;
import com.kirg.referencelinksystem.entity.Product;
import com.kirg.referencelinksystem.entity.UserWithHeart;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserWithHeartService {
    private UserWithHeartRepository userWithHeartRepository;

    public UserWithHeartService(UserWithHeartRepository userWithHeartRepository) {
        this.userWithHeartRepository = userWithHeartRepository;
    }

    public UserWithHeart addUserWithHeart(UserWithHeart userWithHeart) {
        return userWithHeartRepository.save(userWithHeart);
    }

    public UserWithHeart getById(Long aLong) {
        return userWithHeartRepository.getById(aLong);
    }


    public BigDecimal addHeartPoints(List<Product> productList) {
        List<Product> list=productList;
        BigDecimal heartPointsToGain = BigDecimal.ZERO;
        for (Product product : list) {
            int isSmaller = product.getOfferedPrice().compareTo(product.getRealPrice());
            if (isSmaller < 0) {
                BigDecimal differance = product.getRealPrice()
                        .subtract(product.getOfferedPrice());
                heartPointsToGain = differance.add(heartPointsToGain);
            }

        }
        return  heartPointsToGain;
    }




}
