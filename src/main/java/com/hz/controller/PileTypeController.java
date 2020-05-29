package com.hz.controller;

import com.hz.pojo.FoPiletype;
import com.hz.pojo.Page;
import com.hz.service.PileTypeService;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pileTypeController")
public class PileTypeController {
    @Resource
    private PileTypeService pileTypeService;
    @RequestMapping("getPileType")
    public String getPileType( @RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "5") int pagesize,
                               @RequestParam(value = "piletype_name",required = false) String piletype_name,HttpServletRequest request ){
        try {
            List<FoPiletype> pileTypeList = pileTypeService.getPileTypeList(currpageno,pagesize,piletype_name);
            int totalCount =  pileTypeService.getCount(piletype_name);
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            request.setAttribute("pileTypeList",pileTypeList);
            request.setAttribute("page",page);
            request.setAttribute("piletype_name",piletype_name);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "pile-type";
    }
    @RequestMapping("/addPiletype")
    @ResponseBody
    public JSONObject addStation(@RequestBody FoPiletype piletype){
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        piletype.setPiletype_createtime(sdf.format(new Date()));
        try {
            int i = pileTypeService.addPiletype(piletype);
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

    @RequestMapping("/updPiletypeInfo")
    public String updPiletype(@RequestParam("piletype_id") long piletype_id, Model model){
        try {
            FoPiletype piletype = pileTypeService.getPileTypeById(piletype_id);
            model.addAttribute("piletype",piletype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-type-upd";
    }
    @RequestMapping("/updPileType")
    @ResponseBody
    public  JSONObject updStation(@RequestBody FoPiletype piletype){
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
        piletype.setPiletype_createtime(sdf.format(new Date()));
        try {
            int i  = pileTypeService.updPileType(piletype);
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
}
