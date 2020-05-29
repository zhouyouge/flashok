package com.hz.controller;


import com.hz.pojo.FoPayrecord;
import com.hz.pojo.Page;
import com.hz.service.PayRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/payRecord")
public class PayRecordController {
    @Resource
    private PayRecordService payRecordService;
    @RequestMapping("/getPayRecordList")
    public String getFayRecordList(Model model,
                                   @RequestParam(value = "currpageno",defaultValue = "1")int currpageno,
                                   @RequestParam(value = "pagesize",defaultValue = "3")int pagesize,
                                   @RequestParam(value = "user_wechat_name",required = false)String user_wechat_name){
        try {
            List<FoPayrecord> payrecordList = payRecordService.getFoPayrecordList(currpageno,pagesize,user_wechat_name);
            int totalCount = payRecordService.getPayRecordCount();
            Page page = new Page();
            page.setPageSize(pagesize);
            page.setCurrPageNo(currpageno);
            page.setTotalCount(totalCount);
            model.addAttribute("page",page);
            model.addAttribute("payrecordList",payrecordList);
            model.addAttribute("user_wechat_name",user_wechat_name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "payrecord";
    }
}
