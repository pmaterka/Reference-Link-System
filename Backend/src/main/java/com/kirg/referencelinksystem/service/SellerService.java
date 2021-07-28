package com.kirg.referencelinksystem.service;

import com.kirg.referencelinksystem.data.SellerRepository;
import com.kirg.referencelinksystem.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> findAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Optional<Seller> findSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public boolean existsSellerById(Long id) {
        return sellerRepository.existsById(id);
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }
}
