package com.hz.controller;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoState;
import com.hz.pojo.Page;
import com.hz.service.StationAdminService;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/stationAdminController")
public class StationAdminController {
    @Resource
    private StationAdminService stationAdminService;
    @RequestMapping("/stationAdminlist")
    public String getFoStationList(@RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "10") int pagesize,
                               @RequestParam(value = "station_name",required = false) String station_name,HttpServletRequest request) {

        try {
            List<FoAdmin> stationAdminList = stationAdminService.getStationAdminList(currpageno,pagesize,station_name);
            //总记录数
            int totalCount =  stationAdminService.getStationCount(station_name);
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            request.setAttribute("stationAdminList",stationAdminList);
            request.setAttribute("page",page);
            request.setAttribute("station_name",station_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "station-admin";
    }



    @RequestMapping("/updAdminStateInfo")
    public String updAdminStateInfo(@RequestParam("state_id") String state_id, Model model){
        try {
            System.out.println("進入updAdminStateInfo........."+state_id);
            long id = Long.parseLong(state_id);
            FoState state = stationAdminService.getAdminStateById(id);
            long admin_id = state.getAdmin_id();
            FoAdmin admin = stationAdminService.getAdminByID(admin_id);
            model.addAttribute("state",state);
            model.addAttribute("admin",admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "station-admin-upd";
    }


    @RequestMapping("/updAdminState")
    @ResponseBody
    public JSONObject updAdminState(  @RequestParam("state_id") String state_ids,
                                     @RequestParam("admin_id") long admin_id
                                   ){
        String [] state_id = state_ids.split(",");
        JSONObject jsonObject = new JSONObject();
         try {
           int i = stationAdminService.updAdminState(state_id,admin_id);
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

    @RequestMapping("/updStateAdmin")
    @ResponseBody
    public JSONObject updState(@RequestParam("admin_name") String admin_name,
                               @RequestParam("admin_state") Integer admin_state){
        JSONObject jsonObject = new JSONObject();
        if (admin_state == 2){
            admin_state = 1;
        }else if (admin_state == 1){
            admin_state = 2;
        }
        try {
            int i = stationAdminService.updStateAdmin(admin_name,admin_state);
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
