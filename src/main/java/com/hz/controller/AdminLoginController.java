package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.service.AdminLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String enrollAdmin(@RequestParam(value = "name")String adminName,
                              @RequestParam(value = "password") String adminPassword,
                              @RequestParam(value = "account") String adminEmail){
        FoAdmin foAdmin = new FoAdmin();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        System.out.println(time);
        foAdmin.setAdminName(adminName);
        foAdmin.setAdminPassword(adminPassword);
        foAdmin.setAdminEmail(adminEmail);
        foAdmin.setAdminAddtime(time);
        try {
            int i = adminLoginService.enrollAdmin(foAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login.html";
    }
    @RequestMapping("/panduanName")
    public String panduanName(){
        return "";
    }
}
