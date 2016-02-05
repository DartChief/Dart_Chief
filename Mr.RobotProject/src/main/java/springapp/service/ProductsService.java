package springapp.service;

import springapp.model.Products;

import java.util.List;

public interface ProductsService {

    Products create(Products products);
    List<Products> showAll();
    Products showById(int id);
    Products update(Products products) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
