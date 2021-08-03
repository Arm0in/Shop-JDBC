package ir.maktab.shop.service;

import ir.maktab.shop.base.service.BaseService;
import ir.maktab.shop.domain.Admin;
import ir.maktab.shop.domain.Customer;

public interface AdminService extends BaseService<Admin, Integer> {
    Admin login(String username, String password);
}
