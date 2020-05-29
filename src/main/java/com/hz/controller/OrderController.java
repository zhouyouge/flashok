package com.hz.controller;

import com.hz.pojo.FoOrder;
import com.hz.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/OrderController")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/getOrderList")
    public String getOrderList(Model model) {
        try {
            List<FoOrder> foOrderList = orderService.getOrderList();
            for (FoOrder ss:foOrderList){
                System.out.println(ss.getFoUser().getUser_wechat_name());
            }
            model.addAttribute(foOrderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "order-list.html";
    }

}