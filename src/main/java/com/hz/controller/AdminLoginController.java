package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.service.AdminLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/adminlogin")
public class AdminLoginController {
    @Resource
    private AdminLoginService adminLoginService;
    @RequestMapping("/login")
    public String AdminLogin(){
        try {
            FoAdmin foAdmin = adminLoginService.adminLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/enrolladmin")
    public String enrollAdmin(@RequestParam(value = "adminName",required = true)String adminName,
                              @RequestParam(value = "adminPassword",required = true) String adminPassword,
                              @RequestParam(value = "adminEmail",required = true) String adminEmail){
        FoAdmin foAdmin = new FoAdmin();
        foAdmin.setAdminName(adminName);
        foAdmin.setAdminPassword(adminPassword);
        foAdmin.setAdminEmail(adminEmail);
        try {
            int i = adminLoginService.enrollAdmin(foAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
