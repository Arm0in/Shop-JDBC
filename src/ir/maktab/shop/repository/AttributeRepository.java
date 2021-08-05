package ir.maktab.shop.repository;

import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.domain.Attribute;

import java.util.List;

public interface AttributeRepository extends BaseRepository<Attribute, Integer> {
    List<Attribute> findProductAttributesById(Integer id);
}
