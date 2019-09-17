package com.hz.controller;

import com.hz.pojo.FoPile;
import com.hz.service.PileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/pileController")
public class PileController {
    @Resource
    private PileService pileService;
    @RequestMapping("/getState")
    public String getFoPile(HttpServletRequest request) {
        List<FoPile> pileList = null;
        try {
            pileList = pileService.getFoPileList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("pileList", pileList);
        return "pile-state";
    }

    @RequestMapping("/getPile")
    public String updPileInfo(Model model){
        List<FoPile> piles =null;
        try {
            piles = pileService.getPiles();
            model.addAttribute("piles",piles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pile-pile";
    }

}
