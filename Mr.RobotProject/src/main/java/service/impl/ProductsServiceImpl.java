package service.impl;

import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductsRepository;
import service.ProductsService;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Products create(Products products) {
        Products createdProducts = products;
        return productsRepository.saveAndFlush(createdProducts);
    }

    @Override
    public List<Products> showAll() {
        return productsRepository.findAll();
    }

    @Override
    public Products showById(int id) {
        return productsRepository.findOne(id);
    }

    @Override
    public Products update(Products products) throws ClassNotFoundException {
        return productsRepository.saveAndFlush(products);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        productsRepository.delete(id);
    }
}
