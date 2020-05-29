package com.hz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.*;
import com.hz.service.OrderService;
import com.hz.service.PayRecordService;
import com.hz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/getUserList")
    public String getUserList(@RequestParam(value = "user_wechat_name",required = false)String user_wechat_name,
                              @RequestParam(value = "user_state",required = false)Integer user_state,
                              @RequestParam(value = "datemin",required = false,defaultValue = "0000-00-00")String datemin,
                              @RequestParam(value = "datemax",required = false,defaultValue = "9999-00-00")String datemax,
                              @RequestParam(value = "currpageno",required = false,defaultValue = "1")int currpageno,
                              @RequestParam(value = "pagesize",required = false,defaultValue = "8") int pagesize,
                              Model model){
        try {
            int totalCount = userService.getUserCount(user_wechat_name,datemin,datemax,user_state);
            Page page = new Page();
            page.setCurrPageNo(currpageno);
            page.setPageSize(pagesize);
            page.setTotalCount(totalCount);
            List<FoUser> foUserList = userService.getUserList(user_wechat_name,user_state,datemin,datemax,currpageno,pagesize);
            model.addAttribute("foUserList",foUserList);
            model.addAttribute("page",page);
            model.addAttribute("user_wechat_name",user_wechat_name);
            model.addAttribute("user_state",user_state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/member-list.html";
    }


    //获取用户openid
    private static String appid = "wx03fa2c9acde4862f";
    private static String secret = "cc695109c66c60d264315bf25b89e194";
    private static String grant_type = "authorization_code";
    public static  String openid;
    @ResponseBody
    @RequestMapping("/getOpenId")
    public static String getOpenId(@RequestParam("code") String js_code) {
        BufferedReader in = null;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + appid + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=" + grant_type;
        try {
            URL weChatUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = weChatUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

            String jsonId = sb.toString();
            System.out.println(jsonId);
            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonId);
            //从json字符串获取openid和session_key
            openid = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
//            System.out.println(openid);
            return openid;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        return null;
    }
    //添加用户
    @RequestMapping("/addUser")
    @ResponseBody
    public JSONObject addUser(@RequestParam(value = "userinfo",required = false)String userinfo){
        JSONObject jsonObject = new JSONObject();
//        System.out.println(userinfo);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String addtime = sdf.format(date);
        try {
            System.out.println(openid);
            FoUser foUser2 = userService.getUserByOpenId(openid);
            if (foUser2 == null){
                JSONObject jsonObject1 = JSON.parseObject(userinfo);
                String user_wechat_name = (String)jsonObject1.get("nickName");//获取昵称,
                Integer user_sex = (Integer) jsonObject1.get("gender");
                String country = (String)jsonObject1.get("country");
                String province = (String)jsonObject1.get("province");
                String city = (String)jsonObject1.get("city");
                String user_addr = country+""+province+""+city;
                String user_wechat_iocn = (String)jsonObject1.get("avatarUrl");
//                System.out.println(user_wechat_name);
                //小程序登录
                FoUser foUser1 = new FoUser();
                foUser1.setUser_openid(openid);
//                System.out.println(foUser1.getUser_openid());
                foUser1.setUser_createtime(addtime);
                foUser1.setUser_addr(user_addr);
                foUser1.setUser_sex(user_sex);
                foUser1.setUser_wechat_name(user_wechat_name);
                foUser1.setUser_wechat_iocn(user_wechat_iocn);
//                System.out.println(foUser1.getUser_wechat_iocn());
               if (openid != null){
                   int i = userService.addUser(foUser1);
               }
//                System.out.println(i);
            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject ;
    }
    //充值
    @RequestMapping("/updateUserMoney")
    @ResponseBody
    public void updateUserMoney(@RequestParam("pushMoney")int pushMoney){
        try {
//            System.out.println(openid);
//            System.out.println(pushMoney);
//            System.out.println(oldUser_money);
            FoUser foUser2 = userService.getUserByOpenId(openid);
            Double oldUser_money = foUser2.getUser_money();
            double user_money = oldUser_money + pushMoney;
            int i = userService.updateUserMoney(openid,user_money);
            if (i!=0){
                System.out.println("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //充值记录

    @Resource
    private PayRecordService payRecordService;
    @ResponseBody
    @RequestMapping("/addPayRecord")
    public void addPayRecord(@RequestParam("pushMoney")int pushMoney){
        System.out.println(pushMoney);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:MM:ss");
        String addTime = sdf.format(date);

        FoPayrecord foPayrecord = new FoPayrecord();
        foPayrecord.setPayrecord_time(addTime);
        foPayrecord.setPayrecord_money(pushMoney);
        foPayrecord.setFoUser(new FoUser());
        foPayrecord.getFoUser().setUser_openid(openid);
        try {
            int i = payRecordService.addPayRecord(foPayrecord);
            System.out.println(i+"xxxxxxxxxxxxxxxxx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //用户订单
    private String startTime;
    @Resource
    private OrderService orderService;
    @RequestMapping("/addOrder")
    @ResponseBody
    public JSONObject addOrder(@RequestParam("pile_code")String pile_code){
        try {
//            System.out.println(pile_code);
//            JSONObject jsonObject = JSON.parseObject(time);
//            Double hour = jsonObject.getDouble("hour");
//            Double minute = jsonObject.getDouble("minute");
//            Double second = jsonObject.getDouble("second");
//            String pushTime = hour+":"+minute+":"+second;
//            if (minute<30){
//                hour = hour +0.5;
//            }else if (minute>=30&&minute<=60){
//                hour = hour+1;
//            }
//            System.out.println(openid);
//            FoPile foPile = new FoPile();
//            try {
//                foPile = orderService.getOrderCost(pile_code);
//            }catch (NullPointerException e){
//                System.out.println("发生异常的原因为 :"+e.getMessage());
//            }
//        int pile_electric_type = foPile.getPile_electric_type();
////            System.out.println(pile_electric_type);
//        double acprice = foPile.getStation().getState_acprice();
////            System.out.println(acprice);
//        double order_service = foPile.getStation().getStation_service();
////            System.out.println(order_service);
//        double dcprice = foPile.getStation().getState_dcprice();
////            System.out.println(dcprice);
//        double order_cost = foPile.getStation().getStation_cost();
////            System.out.println(order_cost);
//        if (pile_electric_type == 1){
//            order_money = order_service+dcprice*hour;
//        }else if (pile_electric_type == 2){
//            order_money = order_service+acprice*hour;
//        }
//        FoUser foUser = userService.getUserByOpenId(openid);
//        double user_money = foUser.getUser_money();
//        user_money = user_money-order_money;
//        int s = userService.updateUserMoney(openid,user_money);
////        System.out.println(s);


        //订单开始时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        startTime = sdf.format(date);


        FoOrder foOrder = new FoOrder();
        foOrder.setOrder_starttime(startTime);
        foOrder.setFoPile(new FoPile());
        foOrder.getFoPile().setPile_code(pile_code);
//        System.out.println(foOrder.getFoPile().getPile_code());
        foOrder.setFoUser(new FoUser());
        foOrder.getFoUser().setUser_openid(openid);
//        System.out.println(foOrder.getFoUser().getUser_openid());
         int i = orderService.addOrder(foOrder);
//            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //结束订单
    @RequestMapping("/endOrder")
    @ResponseBody
    public JSONObject endOrder(@RequestParam("time")String time,
                         @RequestParam("pile_code")String pile_code){
        System.out.println(time);
        //订单金额和充电时间
        JSONObject jsonObject = JSON.parseObject(time);
        int hour = jsonObject.getInteger("hour");
        int minute = jsonObject.getInteger("minute");
        int second = jsonObject.getInteger("second");
        String pushTime = hour+":"+minute+":"+second;
        double hours = hour;
        if (minute<30){
            hours = hours +0.5;
        }else if (minute>=30&&minute<=60){
            hours = hours+1;
        }
        FoPile foPile = new FoPile();

        try {
            foPile = orderService.getOrderCost(pile_code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int pile_electric_type = foPile.getPile_electric_type();
//            System.out.println(pile_electric_type);
        double acprice = foPile.getStation().getState_acprice();
//            System.out.println(acprice);
        double order_service = foPile.getStation().getStation_service();
//            System.out.println(order_service);
        double dcprice = foPile.getStation().getState_dcprice();
//            System.out.println(dcprice);
        double order_cost = foPile.getStation().getStation_cost();
//            System.out.println(order_cost);

        double order_money = 0;
        if (pile_electric_type == 1){
            order_money = order_service+dcprice*hours;
        }else if (pile_electric_type == 2){
            order_money = order_service+acprice*hours;
        }
        FoUser foUser = null;
        try {
            foUser = userService.getUserByOpenId(openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        double user_money = foUser.getUser_money();
        user_money = user_money-order_money;
        try {
            int s = userService.updateUserMoney(openid,user_money);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //结束时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String endTime = sdf.format(date);
        FoOrder foOrder = new FoOrder();
        foOrder.setOrder_service(order_service);
        foOrder.setOrder_cost(order_cost);
        foOrder.setOrder_time(pushTime);
        foOrder.setOrder_endtime(endTime);
        foOrder.setOrder_starttime(startTime);
        foOrder.setOrder_money(order_money);
        try {
            int i = orderService.updateOrderState(foOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject js = new JSONObject();
        js.put("order_money",order_money);
        System.out.println(js);
        return js;
    }

    //修改用户状态
    @RequestMapping("/updateState")
    @ResponseBody
    public JSONObject updateState(@RequestParam("user_id") int user_id,
                                  @RequestParam("user_state") int user_state){
        System.out.println(user_id);
        System.out.println(user_state);
        JSONObject jsonObject = new JSONObject();
        if (user_state == 0){
            user_state = 1;
        }else if (user_state == 1){
            user_state = 0;
        }
        try {
            int i = userService.updatState(user_id,user_state);
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
    @RequestMapping("/userShow")
    public String userShow(@RequestParam("user_id")int user_id,
                               Model model){
        try {
            FoUser user = userService.userShow(user_id);
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "member-show.html";
    }
    @RequestMapping("/getUserByOpenId")
    @ResponseBody
    public JSONObject getUserByOpenId(@RequestParam("openid")String openid) {
        JSONObject jsonObject = new JSONObject();
        try {
            FoUser foUser = userService.getUserByOpenId(openid);
            double money = foUser.getUser_money();
//            System.out.println(money);
            jsonObject.put("money",money);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    //后台添加用户
    @RequestMapping("/addUserbgc")
    @ResponseBody
    public JSONObject addUserbgc(@RequestBody(required = false) FoUser foUser){
        //后台添加用户
        Date date = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String addtime = sfd.format(date);
        foUser.setUser_createtime(addtime);
        JSONObject jsonObject = new JSONObject();
        try {
            int i = userService.addUser(foUser);
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

    //获取用户订单
    @RequestMapping("/getUserOrderList")
    @ResponseBody
    public JSONObject getUserOrderList(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<FoOrder> foUserOrderList = orderService.getUserOrderList(openid);
            jsonObject.put("foUserOrderList",foUserOrderList);
            System.out.println(jsonObject);
//            jsonObject.toJSONString(foUserOrderList);
//            System.out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
