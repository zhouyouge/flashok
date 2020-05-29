package com.hz.controller;

import com.hz.service.CountAllService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/countController")
public class CountAllController {
    @Resource
    private CountAllService countAllService;
    @RequestMapping("/all")
    public String countAll(Model model){
        try {
            int pileCount = countAllService.getPileAll();
            int pileActive = countAllService.getPileActive();
            int pileRun = countAllService.getPileRun();
            int pileOut = countAllService.getPileOut();
            int pileRepair = countAllService.getPileRepair();
            int stationCount = countAllService.getStationAll();
            int stationActive = countAllService.getgetStationActive();
            int stationBuild = countAllService.getgetStationBuild();
            double payrecordMoney = countAllService.getPayrecordMoney();
            int userCount = countAllService.getUserAll();

            model.addAttribute("pileCount",pileCount);
            model.addAttribute("pileActive",pileActive);
            model.addAttribute("pileRun",pileRun);
            model.addAttribute("pileOut",pileOut);
            model.addAttribute("pileRepair",pileRepair);

            model.addAttribute("stationCount",stationCount);
            model.addAttribute("stationActive",stationActive);
            model.addAttribute("stationBuild",stationBuild);
            model.addAttribute("payrecordMoney",payrecordMoney);
            model.addAttribute("userCount",userCount);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "countAll";
    }

}
