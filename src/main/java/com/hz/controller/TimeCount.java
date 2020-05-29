package com.hz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.FoOrder;
import com.hz.service.OrderService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/timeCount")
public class TimeCount {
//    public static Calendar c;
//    public static long endTime;
//    public static Date date;
//    public static long startTime;
//    public static long midTime;
//    public long hour;
//    public long minute;
//    public long second;
//    @ResponseBody
//    @RequestMapping("/ztimeCount")
//    public JSONObject ztimeCount(@RequestParam(value = "timeChoose",required = false)String timeChoose){
//        System.out.println(timeChoose);
//        JSONObject jsonObject = new JSONObject();
//        int times = Integer.parseInt(timeChoose);
//        c = Calendar.getInstance();
//        endTime = c.getTimeInMillis();
//        date = new Date();
//        startTime = date.getTime();
//        midTime = (endTime-startTime)/1000;
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                midTime++;
//                hour = midTime/60/60%60;
//                minute = midTime/60%60;
//                second = midTime%60;
//                if (hour==times){
//                    timer.cancel();
//                }
//            }
//        },0,1000);
//        jsonObject.put("hour",hour);
//        jsonObject.put("minute",minute);
//        jsonObject.put("second",second);
//        return jsonObject;
//    }
    private String begintime;
    private String chooseTime;
    private String pile;
    @ResponseBody
    @RequestMapping("/beginTime")
    public JSONObject beginTime(@RequestParam(value = "timeChoose",required = false)String timeChoose,
                                @RequestParam("pile_code")String pile_code){
        System.out.println(pile_code);
        pile = pile_code;
        JSONObject jsonObject = new JSONObject();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        begintime = sdf.format(date);
        chooseTime = timeChoose;
        jsonObject.put("begintime",begintime);
        return jsonObject;
    }
    @Resource
    private OrderService orderService;
    @ResponseBody
    @RequestMapping("/endTime")
    public JSONObject endTime(@RequestParam("openid")String user_openid){
        System.out.println(user_openid);
        JSONObject jsonObject = new JSONObject();
       Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String endTime = sdf.format(date);
        boolean boo = false;
        try {
            List<FoOrder> foOrderList = orderService.getOrderListByOpenid(user_openid);
            for (FoOrder foOrder:foOrderList){
                if (foOrder.getOrder_state()==0){
                    boo = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        try {
            Date date1 =  simpleDateFormat.parse(begintime);
            Date date2 =  simpleDateFormat.parse(endTime);
            Integer d =  getBetweenSecond(date1,date2);
            System.out.println(d);


            String str =  secToTime(d);
            System.out.println(str);

            jsonObject.put("timeout",str);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        jsonObject.put("chooseTime",chooseTime);
        jsonObject.put("boo",boo); //true已经有正在进行的订单，false没有
        jsonObject.put("pile",pile);
        return jsonObject;
    }


    /**
     * 两个时间只差
     * @param startDate
     * @param endDate
     * @return 秒数
     */
    public static Integer getBetweenSecond(Date startDate, Date endDate) {
        Integer seconds = 0;
        try {
            if(startDate!=null&&endDate!=null) {
                long ss = 0;
                if(startDate.before(endDate)) {
                    ss = endDate.getTime() - startDate.getTime();
                }else {
                    ss = startDate.getTime() - endDate.getTime();
                }
                seconds = Integer.valueOf((int) (ss/(1000))) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seconds;
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }
    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

}
