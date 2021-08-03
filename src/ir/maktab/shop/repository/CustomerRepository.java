package ir.maktab.shop.repository;

import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Integer> {
    public Customer findByUserName(String username, String password);
}
