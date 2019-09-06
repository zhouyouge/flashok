package com.hz.service.impl;

import com.hz.dao.AdminLoginMapper;
import com.hz.pojo.FoAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminLoginServiceImPL {
    @Resource
    private AdminLoginMapper adminLoginMapper;
    public FoAdmin adminLogin() throws Exception {
        return adminLoginMapper.adminLogin();
    }

    public int enrollAdmin(FoAdmin foAdmin)throws Exception{
        return adminLoginMapper.enrollAdmin(foAdmin);
    };

}
