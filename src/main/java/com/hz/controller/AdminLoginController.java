package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.FoAdmin;
import com.hz.service.AdminLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/AdminLoginController")
@ResponseBody
public class AdminLoginController {
    @Resource
    AdminLoginService adminLoginService;
    @RequestMapping("/AdminLogin")
    public JSONObject AdminLogin(@RequestParam("username")String username,
                                 @RequestParam("userpwd")String userpwd){
        JSONObject jsonObject = new JSONObject();
        try {
            FoAdmin foAdmin = adminLoginService.adminLogin(username,userpwd);
            if (foAdmin != null){
                if (foAdmin.getAdmin_state() == 1){
                    String roleName = foAdmin.getFoRole().getRole_name();
                    jsonObject.put("code",1);
                    jsonObject.put("msg",roleName);
                }else if (foAdmin.getAdmin_state() == 2){
                    jsonObject.put("code",2);
                }
            }else{
                jsonObject.put("code",3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
