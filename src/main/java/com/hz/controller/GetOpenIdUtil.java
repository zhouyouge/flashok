package com.hz.controller;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

    /**
     * @author 小帅气
     * @create 2019-09-16-19:36
     */
 @Controller
 @RequestMapping("/GetOpenIdUtil")
public class GetOpenIdUtil {
        private static String appid = "wx6c4c3a5e9b31b035";
        private static String secret = "ef8160cba8391f1b76249567515fbf4d";
        private static String grant_type = "authorization_code";
        @RequestMapping("/getOpenId")
        @ResponseBody
        public static String getOpenId(@RequestParam("code") String js_code) {
            BufferedReader in = null;
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                    + appid + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=" + grant_type;
            try {
                URL weChatUrl = new URL(url);
                // 打开和URL之间的连接
                URLConnection connection = weChatUrl.openConnection();
                // 设置通用的请求属性
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
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
                JSONObject jsonObject = new JSONObject(jsonId);
                //从json字符串获取openid和session_key
                String openid = jsonObject.getString("openid");
                String session_key = jsonObject.getString("session_key");
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
}
