package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Admin;
import ir.maktab.shop.repository.AdminRepository;
import ir.maktab.shop.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    public Admin login(String username, String passwword) {
        return repository.findByUserName(username, passwword);
    }
}
