package com.hz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.pojo.JSONOBJECTA;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class Test {
    private static final String url = "http://192.168.1.112";
    public static void  test3() {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//                Map<String, Object> data = new HashMap<String, Object>();
//                data.put("StartChargeSeq", "123123");
//                data.put("pile_code", "123");
//                data.put("pile_state","0");
//
//                System.out.println(new StringEntity(objectMapper.writeValueAsString(data)));
//               HttpPost httpPost = new HttpPost(url+"/servlet/End");
//                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
//                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
//                        ContentType.create("text/json", "UTF-8")));
//                client = HttpClients.createDefault();
//                response = client.execute(httpPost);
//                HttpEntity entity = response.getEntity();
//                String result = EntityUtils.toString(entity);
//                System.out.println(result);


                // 创建一个提交数据的容器
                List<BasicNameValuePair> parames = new ArrayList<>();
                parames.add(new BasicNameValuePair("StartChargeSeq", "123123"));
                parames.add(new BasicNameValuePair("pile_code", "123"));
//                parames.add(new BasicNameValuePair("choose_type", "1"));
                parames.add(new BasicNameValuePair("pile_state", "0"));
                HttpPost httpPost = new HttpPost(url+"/servlet/OrC");
                httpPost.setEntity(new UrlEncodedFormEntity(parames, "utf-8"));
                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity,"utf-8");



//                JSONObject jsonObject = JSON.parseObject(result);
////                System.out.println(jsonObject.get("code"));
////                System.out.println(jsonObject.get("msg"));



                JSONOBJECTA jsonobjecta = JSON.parseObject(result,new TypeReference<JSONOBJECTA>() {} );
                System.out.println(jsonobjecta.getCode());
                System.out.println(jsonobjecta.getMsg());
//                System.out.println(jsonobjecta.getStartime());
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static int time = 60*60*60;
    public static Calendar c;
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime;
    public static void main(String[] args) {
//        test3();
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
//                long hour = midTime/60/60%60;
//                long minute = midTime/60%60;
//                long second = midTime%60;
//                System.out.println(second);
//                if (second==10){
//                    timer.cancel();
//                }
//            }
//        },0,1000);



        //初始化变量
//        Date before=new Date();
//        Date now= new Date();
////定时循环
//        long second =0;
//        long minute =0;
//        long hour =0;
////       while (hour<2){
//           while (minute<=60){
//               while(second<60) {//循环时间){
//                   // 计算循环总时长
//                   now = new Date();
//                   // 现在的时间减去开始的时间可以计算出来使用的时间
//                   second = (now.getTime() - before.getTime()) / 1000;
//                   //循环内容
//                   System.out.println(second);
//               }
//               minute++;
//               System.out.println(minute);
//           }
////           hour++;
////       }
//    }
//        long startTime =  System.currentTimeMillis();
//
//        long endTime =  System.currentTimeMillis();
//        long usedTime = (endTime-startTime)/1000;
//        System.out.println(usedTime);
    }
}

