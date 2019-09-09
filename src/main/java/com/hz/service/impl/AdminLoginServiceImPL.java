package com.hz.service.impl;

import com.hz.dao.AdminLoginMapper;
import com.hz.pojo.FoAdmin;
import com.hz.service.AdminLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminLoginService")
public class AdminLoginServiceImPL implements AdminLoginService {
    @Resource
    private AdminLoginMapper adminLoginMapper;
    @Override
    public FoAdmin adminLogin(String adminName,String adminPassword) throws Exception {
        return adminLoginMapper.adminLogin(adminName,adminPassword);
    }
    @Override
    public int enrollAdmin(FoAdmin foAdmin)throws Exception{
        return adminLoginMapper.enrollAdmin(foAdmin);
    }

    @Override
    public FoAdmin panduanName(String adminEmail) throws Exception {
        return adminLoginMapper.panduanName(adminEmail);
    }

}
