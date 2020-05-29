package com.hz.controller;

import com.hz.pojo.FoParameter;
import com.hz.pojo.FoPiletype;
import com.hz.pojo.Page;
import com.hz.service.PileParaService;
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
@RequestMapping("pileParaController")
public class PileParaController {
    @Resource
    private PileParaService pileParaService;
    @RequestMapping("/getPileType")
    public String getFoStation(@RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                               @RequestParam(value = "pagesize",required = false,defaultValue = "5") int pagesize,
                               @RequestParam(value = "piletype_name",required = false) String piletype_name,
                               @RequestParam(value = "parameter_electricity",required = false) String parameter_electricity,HttpServletRequest request) {

        try {
            List<FoParameter> pileTypeList = pileParaService.getParameterList(piletype_name,parameter_electricity,currpageno,pagesize);
            //总记录数
            int totalCount =  pileParaService.getCount(piletype_name,parameter_electricity);
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            request.setAttribute("pileTypeList",pileTypeList);
            request.setAttribute("page",page);
            request.setAttribute("piletype_name",piletype_name);
            request.setAttribute("parameter_electricity",parameter_electricity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-para";
    }
    @RequestMapping("/addinfo")
    public String addinfo(HttpServletRequest request){

        try {
            List<FoPiletype> piletypes = pileParaService.piletype();

           request.setAttribute("piletypes",piletypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-para-add";
    }
    @RequestMapping("/addType")
    @ResponseBody
    public JSONObject addType(@RequestBody FoParameter type){
        JSONObject jsonObject = new JSONObject();
        try {
            int i = pileParaService.addType(type);
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
    @RequestMapping("/updTypeInfo")
    public String updTypeInfo(@RequestParam("parameter_id") int parameter_id, Model model){
        try {
            FoParameter type = pileParaService.getParameterById(parameter_id);
            model.addAttribute("type",type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-para-upd";
    }
    @RequestMapping("/updType")
    @ResponseBody
    public  JSONObject updType(@RequestBody FoParameter type){
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        type.setParameter_creationtime(sdf.format(new Date()));
        try {
            int i  = pileParaService.updType(type);
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
