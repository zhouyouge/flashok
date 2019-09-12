package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoRole;
import com.hz.pojo.Page;
import com.hz.service.StatisticsService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;

@Controller
@RequestMapping("/statisticsController")
public class StatisticsController {
    @Resource
    private StatisticsService statisticsService;
    @RequestMapping("/getRoleList")
    public String getAdminList(Model model,
                               @RequestParam(value = "currpageno",required = false,defaultValue = "1")int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "5")int pagesize){
        try {
            List<FoRole> foRoleList = statisticsService.getRoleList(currpageno,pagesize);
            Page page = new Page();
            page.setCurrPageNo(currpageno);
            page.setPageSize(pagesize);
            model.addAttribute(foRoleList);
            model.addAttribute(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin-role.html";
    }
    @RequestMapping("/deleteRole")
    @ResponseBody
    public JSONObject deleteRole(@RequestParam("roleid") long role_id){
        JSONObject jsonObject = new JSONObject();
        try {
            FoRole foRole = new FoRole();
            foRole.setRole_id(role_id);
            int i = statisticsService.deleteRole(foRole);
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

    @RequestMapping("/insertRole")
    @ResponseBody
    public JSONObject insertRole(@RequestParam(value = "role_description",required = false)String role_description,
                             @RequestParam(value = "roleName",required = true)String role_name){
        JSONObject jsonObject = new JSONObject();
        FoRole foRole = new FoRole();
        foRole.setRole_name(role_name);
        foRole.setRole_description(role_description);
        try {
            int i = statisticsService.insertRole(foRole);
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

    @RequestMapping("/deleteRoles")
    @ResponseBody
    public String deleteRoles(@RequestParam("idarr")String[] array
                                  ){
        JSONObject jsonObject = new JSONObject();
        try {
            int i = statisticsService.deleteRoles(array);
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
