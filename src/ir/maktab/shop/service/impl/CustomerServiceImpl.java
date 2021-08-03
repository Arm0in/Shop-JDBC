package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.repository.CustomerRepository;
import ir.maktab.shop.service.CustomerService;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Integer, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
