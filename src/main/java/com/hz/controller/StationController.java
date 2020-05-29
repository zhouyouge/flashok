package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.FoStation;
import com.hz.pojo.Page;
import com.hz.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/stationController")
public class StationController {
    @Resource
    private StationService stationService;
    @RequestMapping("/getStationType")
    public String getFoStation(@RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "8") int pagesize,
                               @RequestParam(value = "station_name",required = false) String station_name,
                               @RequestParam(value = "station_state",required = false) Integer station_state,HttpServletRequest request,
                               @RequestParam(value = "roleName",required = false)String roleName) {

        try {
            List<FoStation> stationList = stationService.getFoStationList(currpageno,pagesize,station_name,station_state);
            //总记录数
            int totalCount =  stationService.getStationCount(station_name,station_state);

            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            request.setAttribute("stationList",stationList);
            request.setAttribute("page",page);
            request.setAttribute("station_name",station_name);
            request.setAttribute("station_state",station_state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "station-type";
    }
    @RequestMapping("/getMapStation")
    @ResponseBody
    public JSONObject getMapStation(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<FoStation> stationList = stationService.getFoStationList(1,100000,null,null);
            jsonObject.put("stationList",stationList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("/updStationInfo")
    public String updStationInfo(@RequestParam("station_id") int station_id, Model model){
        try {
            FoStation station = stationService.getStationrById(station_id);
            model.addAttribute("station",station);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "station-upd";
    }
    @RequestMapping("/updStation")
    @ResponseBody
    public  JSONObject updStation(@RequestBody FoStation station){
        JSONObject jsonObject = new JSONObject();
        try {
            int i  = stationService.updStation(station);
            System.out.println(i+"ssssssssssssssssssssssssssss");
            if (i!=0){
                jsonObject.put("code","1");
            }else{
                jsonObject.put("code","2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jsonObject;
    }

    @RequestMapping("/addStation")
    @ResponseBody
    public JSONObject addStation(@RequestBody FoStation station){
        JSONObject jsonObject = new JSONObject();
        try {
            int i = stationService.addStation(station);
            System.out.println(i+"xxxxxxxxxxxxxxxxxx");
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
    @RequestMapping("/updState")
    @ResponseBody
    public JSONObject updState(@RequestParam("station_id") int station_id,
                                  @RequestParam("station_state") Integer station_state){
        JSONObject jsonObject = new JSONObject();
        if (station_state == 5){
            station_state = 1;
        }else if (station_state == 1){
            station_state = 5;
        }
        try {
            int i = stationService.updState(station_id,station_state);
            System.out.println(i+"xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
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

