package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.FoWarning;
import com.hz.pojo.Page;
import com.hz.service.WarningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/warningController")
public class WarningController {
    @Resource
    private WarningService warningService;
    @ResponseBody
    @RequestMapping("/addWarning")
    public String addWarning(@RequestParam("warning_type")String warning_types,
                             @RequestParam(value = "warning_pile_code",required = false)String warning_pile_code,
                             @RequestParam(value = "warning_images",required = false)String warning_images,
                             @RequestParam(value = "warning_beizhu",required = false)String warning_beizhu){

        String temp = warning_types.replace("\"","");
        System.out.println(temp);
        temp=temp.replace("[","");
        temp=temp.replace("]","");
        String[] warning_type = temp.split(",");
        int a = 0;
        for (int i = 0; i < warning_type.length; i++){
            try {
                a = warningService.addWarning(warning_type[i],warning_pile_code,warning_images,warning_beizhu);
                a++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(a);
        return "";
    }
    @RequestMapping("/getWarningList")
    public String getWarningList(
                                 @RequestParam(value = "station_name",required = false) String station_name,
                                 @RequestParam(value = "warning_state",required = false) Integer warning_state,
                                 @RequestParam(value = "currpageno",required = false,defaultValue = "1")int currpageno,
                                 @RequestParam(value = "pagesize" ,required = false,defaultValue = "8") int pagesize,
                                 Model model){
        try {
            int totalCount = warningService.getWarningCount(station_name,warning_state);
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setTotalCount(totalCount);
            page.setCurrPageNo(currpageno);
            List<FoWarning> foWarningList = warningService.getWarningList(station_name,warning_state,currpageno,pagesize);
            for (FoWarning ss:foWarningList){
                System.out.println(ss.getWarning_beizhu());
            }
            model.addAttribute("page",page);
            model.addAttribute("foWarningList",foWarningList);
            model.addAttribute("station_name",station_name);
            model.addAttribute("warning_state",warning_state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/warning-list.html";
    }
    @RequestMapping("/updateWarningState")
    @ResponseBody
    public JSONObject updateWarningState(@RequestParam("warning_state") Integer warning_state,
                                         @RequestParam("warning_ID")int warning_ID){
        JSONObject jsonObject = new JSONObject();
        try {
            if (warning_state == 0){
                warning_state =1;
            }else {
                warning_state =0;
            }
            int i = warningService.updateWarningState(warning_state,warning_ID);
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
    @RequestMapping("/deleteWarning")
    @ResponseBody
    public JSONObject deleteWarning(@RequestParam("warning_ids")int[] warning_ids){
        JSONObject jsonObject = new JSONObject();
        try {
            int i = warningService.deleteWarning(warning_ids);
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
}
