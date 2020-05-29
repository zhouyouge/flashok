package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.FoAdmin;
import com.hz.pojo.Page;
import com.hz.service.AdminService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/foAdmin")

public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("/getAdminList")
    public String getAdminList(@RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "5") int pagesize,
                               @RequestParam(value = "admin_name",required = false) String admin_name,
                               @RequestParam(value = "admin_state",required = false) Integer admin_state,
                               Model model){
        try {
            System.out.println(admin_state);
            List<FoAdmin> adminList = adminService.getAdminList(currpageno,pagesize,admin_name,admin_state);
            //总记录数
            int totalCount =  adminService.getAdminCount(admin_name,admin_state);
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            model.addAttribute("page",page);
            model.addAttribute("adminList",adminList);
            model.addAttribute("admin_name",admin_name);
            model.addAttribute("admin_state",admin_state);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin-list";
    }
    @RequestMapping("/insertAdmin")
    @ResponseBody
    public JSONObject insertAdmin(@RequestParam(value = "admin_name",required = false) String admin_name,
                                  @RequestParam(value = "admin_password",required = false) String admin_password,
                                  @RequestParam(value = "admin_remarks",required = false) String admin_remarks,
                                  @RequestParam(value = "admin_email",required = false) String admin_email,
                                  @RequestParam(value = "admin_pid",required = false) long admin_pid){
        JSONObject jsonObject = new JSONObject();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        FoAdmin foAdmin = new FoAdmin();
        foAdmin.setAdmin_addtime(time);
        foAdmin.setAdmin_name(admin_name);
        foAdmin.setAdmin_password(admin_password);
        foAdmin.setAdmin_remarks(admin_remarks);
        foAdmin.setAdmin_email(admin_email);
        foAdmin.setAdmin_pid(admin_pid);
        try {
            int i = adminService.insertAdmin(foAdmin);
            if (i!=0){
                jsonObject.put("code","1");
            }else{
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public JSONObject deleteAdmin(@RequestParam("adminid") long adminid){
        JSONObject jsonObject = new JSONObject();
        try {
            FoAdmin foAdmin = new FoAdmin();
            foAdmin.setAdmin_id(adminid);
            int i = adminService.deleteAdmin(foAdmin);
            System.out.println(i+"xxxxxxxxxxx");
            if (i != 0){
                jsonObject.put("code","1");
            }else{
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
//        return "forward:/statisticsController/getRoleList";
    }

    @RequestMapping("/deleteAdmins")
    @ResponseBody
    public String deleteAdmins(@RequestParam("idarr")String[] array
    ){
        JSONObject jsonObject = new JSONObject();
        try {
            int i = adminService.deleteAdmins(array);
            System.out.println(i+"cccccccccccc");
            if (i!=0){
                jsonObject.put("code","1");
            }else {
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
