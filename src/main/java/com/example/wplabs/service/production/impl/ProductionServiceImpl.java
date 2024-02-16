package com.example.wplabs.service.production.impl;

import com.example.wplabs.entity.ProductionEntity;
import com.example.wplabs.repository.ProductionRepository;
import com.example.wplabs.service.production.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }


    @Override
    public List<ProductionEntity> findAll() {
        return productionRepository.findAll();
    }
}
