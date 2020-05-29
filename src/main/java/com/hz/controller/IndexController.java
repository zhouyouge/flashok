package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/IndexController")
public class IndexController {
    @RequestMapping("/PanduanRole")
    @ResponseBody
    public JSONObject PanduanRole(@RequestParam("roleName")String roleName){
        JSONObject jsonObject = new JSONObject();
        if (roleName.equals("超级管理员") ){
            jsonObject.put("code",3);
        }else{
            jsonObject.put("code",2);
        }
        return jsonObject;
    }
}
