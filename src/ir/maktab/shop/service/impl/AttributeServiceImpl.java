package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Attribute;
import ir.maktab.shop.repository.AttributeRepository;
import ir.maktab.shop.service.AttributeService;

import java.util.List;

public class AttributeServiceImpl extends BaseServiceImpl<Attribute, Integer, AttributeRepository> implements AttributeService {
    public AttributeServiceImpl(AttributeRepository repository) {
        super(repository);
    }

    @Override
    public List<Attribute> findProductAttributesById(Integer productId) {
        return repository.findProductAttributesById(productId);
    }
}
