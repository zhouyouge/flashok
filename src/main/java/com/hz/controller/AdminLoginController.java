package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.service.AdminLoginService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/adminlogin")
public class AdminLoginController {
    @Resource
    private AdminLoginService adminLoginService;
    @RequestMapping("/login")
    @ResponseBody
    public String AdminLogin(@RequestParam("username")String adminname,
                             @RequestParam("userpwd")String adminpassword
                            ){
        JSONObject jsonObject = new JSONObject();
        try {
            FoAdmin foAdmin = adminLoginService.adminLogin(adminname,adminpassword);
            if(foAdmin.getAdmin_name()!=null){
                jsonObject.put("mesg","登录成功");
                jsonObject.put("code","1");
            }else{
                jsonObject.put("mesg","密码错误");
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
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
        foAdmin.setAdmin_name(adminName);
        foAdmin.setAdmin_password(adminPassword);
        foAdmin.setAdmin_email(adminEmail);
        foAdmin.setAdmin_addtime(time);
        try {
            int i = adminLoginService.enrollAdmin(foAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login.html";
    }

//    @RequestMapping("/panduanName")
//    @ResponseBody
//    public String panduanName(@RequestParam("account")String account){
//            String msg = null;
//        try {
//            FoAdmin foAdmin = adminLoginService.panduanName(account);
//            if (foAdmin.getAdminEmail()!=null){
//                msg = "邮箱已被占用";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return msg;
//    }
}
