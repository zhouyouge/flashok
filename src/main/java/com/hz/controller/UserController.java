package com.hz.controller;

import com.hz.pojo.FoUser;
import com.hz.pojo.Page;
import com.hz.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/getUserList")
    public String getUserList(@RequestParam(value = "user_wechat_name",required = false)String user_wechat_name,
                              @RequestParam(value = "user_state",required = false)Integer user_state,
                              @RequestParam(value = "currpageno",required = false,defaultValue = "1")int currpageno,
                              @RequestParam(value = "pagesize",required = false,defaultValue = "8") int pagesize,
                              Model model){
        try {
            int totalCount = userService.getUserCount(user_wechat_name,user_state);
            Page page = new Page();
            page.setCurrPageNo(currpageno);
            page.setPageSize(pagesize);
            page.setTotalCount(totalCount);
            List<FoUser> foUserList = userService.getUserList(user_wechat_name,user_state,currpageno,pagesize);
            model.addAttribute("foUserList",foUserList);
            model.addAttribute("page",page);
            model.addAttribute("user_wechat_name",user_wechat_name);
            model.addAttribute("user_state",user_state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/member-list.html";
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public JSONObject addUser(@RequestBody FoUser foUser){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String addtime = sdf.format(date);
        foUser.setUser_createtime(addtime);
        JSONObject jsonObject = new JSONObject();
        try {
            int i = userService.addUser(foUser);
            if (i!=0){
                jsonObject.put("code","1");
            }else{
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject ;
    }
    @RequestMapping("/updateState")
    @ResponseBody
    public JSONObject updateState(@RequestParam("user_id") int user_id,
                                  @RequestParam("user_state") int user_state){
        JSONObject jsonObject = new JSONObject();
        if (user_state == 0){
            user_state = 1;
        }else if (user_state == 1){
            user_state = 0;
        }
        try {
            int i = userService.updatState(user_id,user_state);
            if (i!=0){
                jsonObject.put("code",1);
            }else{
                jsonObject.put("code",2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    @RequestMapping("/userShow")
    public String userShow(@RequestParam("user_id")int user_id,
                               Model model){
        try {
            FoUser user = userService.userShow(user_id);
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "member-show.html";
    }
    @RequestMapping("/yue")
    @ResponseBody
    public JSONObject getYue(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("yue",50);
        return jsonObject;
    }
}
