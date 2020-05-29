package com.hz.controller;

import com.hz.pojo.*;
import com.hz.service.PileStateService;
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
@RequestMapping("/pileStateController")
public class PileStateController {
        @Resource
        private PileStateService pileStateService;
        @RequestMapping("/getPile")
        public String getFoPileState(@RequestParam(value = "currpageno",required = false,defaultValue = "1") int currpageno,
                                   @RequestParam(value = "pagesize",required = false,defaultValue = "5") int pagesize,
                                   @RequestParam(value = "pile_code",required = false) String pile_code,
                                   @RequestParam(value = "pile_state",required = false) Integer pile_state,HttpServletRequest request) {

            try {
                List<FoPile> pileList = pileStateService.getFoPileList(currpageno,pagesize,pile_code,pile_state);
                //总记录数
                int totalCount =  pileStateService.getPileCount(pile_code,pile_state);

                Page page = new Page();
                page.setPageSize(pagesize);
                page.setCurrPageNo(currpageno);
                page.setTotalCount(totalCount);
                request.setAttribute("pileList",pileList);
                request.setAttribute("page",page);
                request.setAttribute("pile_code",pile_code);
                request.setAttribute("pile_state",pile_state);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "pile-state";
        }
        @RequestMapping("/addinfo")
        public String addinfo(HttpServletRequest request){
            try {
                List<FoPiletype> piletypes = pileStateService.getPiletype();
                List<FoStation> stations = pileStateService.getStation();
                request.setAttribute("piletypes",piletypes);
                request.setAttribute("stations",stations);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "pile-state-add";
        }
        @RequestMapping("/addPileState")
        @ResponseBody
        public JSONObject addPileState(@RequestBody FoPile pile){
            JSONObject jsonObject = new JSONObject();
            try {
                int i = pileStateService.addPileState(pile);
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
    @RequestMapping("/updinfo")
    public String getPileById(@RequestParam("pile_id")String pile_id, Model model){
        try {
            long id = Long.parseLong(pile_id);
           FoPile pile = pileStateService.getPileById(id);
            List<FoPiletype> piletypes = pileStateService.getPiletype();
            List<FoStation> stations = pileStateService.getStation();
           model.addAttribute("pile",pile);
           model.addAttribute("piletypes",piletypes);
           model.addAttribute("stations",stations);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-state-upd";
    }
    @RequestMapping("/updPileState")
    @ResponseBody
    public JSONObject updPileState(@RequestBody FoPile pile){
        JSONObject jsonObject = new JSONObject();
        System.out.println(pile.getPile_code());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        pile.setPile_creationtime(sdf.format(new Date()));
        try {
            int i = pileStateService.updPileState(pile);
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
}
