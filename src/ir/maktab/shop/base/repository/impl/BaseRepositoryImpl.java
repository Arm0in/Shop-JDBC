package ir.maktab.shop.base.repository.impl;

import ir.maktab.shop.base.domain.BaseEntity;
import ir.maktab.shop.base.repository.BaseRepository;

import java.sql.Connection;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements BaseRepository<E, ID> {

    protected final Connection connection;

    public BaseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
}
