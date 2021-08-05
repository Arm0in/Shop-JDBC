package ir.maktab.shop.service;

import ir.maktab.shop.base.service.BaseService;
import ir.maktab.shop.domain.Attribute;

import java.util.List;

public interface AttributeService extends BaseService<Attribute, Integer> {
    List<Attribute> findProductAttributesById(Integer productId);
}
