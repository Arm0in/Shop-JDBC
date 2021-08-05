package ir.maktab.shop.base.service;

import ir.maktab.shop.base.domain.BaseEntity;

import java.util.Collection;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID> {
    E update(E e);

    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);

    List<E> findAllById (Collection<ID> ids);
}
