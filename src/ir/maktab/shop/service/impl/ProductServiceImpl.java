package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Product;
import ir.maktab.shop.repository.ProductRepository;
import ir.maktab.shop.service.ProductService;

import java.util.List;

public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductRepository> implements ProductService {
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
