package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoRole;
import com.hz.service.StatisticsService;
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
    public String getAdminList(Model model){
        try {
            List<FoRole> foRoleList = statisticsService.getRoleList();
            model.addAttribute(foRoleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin-role.html";
    }
    @RequestMapping("/deleteRole/{role_id}")
    public String deleteRole(@PathVariable("role_id") long role_id){
//        JSONObject jsonObject = new JSONObject();
        try {
            FoRole foRole = new FoRole();
            foRole.setRole_id(role_id);
            int i = statisticsService.deleteRole(foRole);
            System.out.println(i+"xxxxxxxxxxx");
//            if (i != 0){
//                jsonObject.put("msg","删除成功");
//                jsonObject.put("code","1");
//            }else{
//                jsonObject.put("msg","删除失败");
//                jsonObject.put("code","2");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return jsonObject.toString();
        return "forward:/statisticsController/getRoleList";
    }

    @RequestMapping("/insertRole")
    public String insertRole(@RequestParam(value = "role_description",required = false)String role_description,
                             @RequestParam(value = "role_name",required = true)String role_name){
        FoRole foRole = new FoRole();
        foRole.setRole_name(role_name);
        foRole.setRole_description(role_description);
        try {
            int i = statisticsService.insertRole(foRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/statisticsController/getRoleList";
    }

    @RequestMapping("/deleteRoles")
    @ResponseBody
    public Model deleteRoles(@RequestParam("idarr")String[] array,
                             Model model){
        try {
            int i = statisticsService.deleteRoles(array);
            System.out.println(i+"cccccccccccc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
