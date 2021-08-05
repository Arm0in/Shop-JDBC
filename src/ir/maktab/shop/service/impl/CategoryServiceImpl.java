package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Category;
import ir.maktab.shop.repository.CategoryRepository;
import ir.maktab.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category, Integer, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
