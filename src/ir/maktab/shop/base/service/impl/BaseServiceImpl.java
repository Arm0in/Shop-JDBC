package ir.maktab.shop.base.service.impl;

import ir.maktab.shop.base.domain.BaseEntity;
import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.base.service.BaseService;

import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>> implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> findAllById(Collection<ID> ids) {
        return repository.findAllById(ids);
    }
}
