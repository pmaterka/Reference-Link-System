package com.kirg.referencelinksystem.service;

import com.kirg.referencelinksystem.data.BrandRepository;
import com.kirg.referencelinksystem.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> findBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public boolean existsBrandById(Long id) {
        return brandRepository.existsById(id);
    }

    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
