package com.hz.controller;

//import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/UpLoadImgController")
public class UpLoadImgController {
//    @RequestMapping("/imgs1")
//    @ResponseBody
//    public String uploaderImgs(@RequestParam("file") MultipartFile file, HttpServletRequest request){
//
//        //获取文件名
//        String originalFilename = file.getOriginalFilename();
//        //realPath上传路径
//        String realPath = "D:/public/imgs/";//request.getServletContext().getRealPath("/public/imgs/");
//        //上传的真实文件名
//        String uploadFileName = System.currentTimeMillis()+"_"+ originalFilename;
//
//        System.out.println(realPath+uploadFileName);
//
//        File file1 = new File(realPath);
//        // 创建父文件夹
//        if(!file1.exists()){
//            file1.mkdirs();
//        }
//        File file2 = new File(realPath+uploadFileName);
//        // 把上传的文件复制到文件对象中
//        try {
//            file.transferTo(file2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return uploadFileName;
//
//    }
//
//    /**
//     * 获取上传凭证
//     * @return  upToken凭证
//     * http://127.0.0.1:60/webuploader/getUptoken
//     */
//    @RequestMapping("/getUptoken")
//    @ResponseBody
//    public String getUptoken(){
//        String accessKey = "CRfZdVOEIPoKguhCp7gaBqYIE_O3IXIkrY1F6kIQ";
//        String secretKey = "MnNPuYknrHD_Zj0AvlCClFoeknsr-oeDLNvSF4Hd";
//        //存储空间的名字
//        String bucket = "lionsystem";
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        return upToken;
//    }
//
//    @RequestMapping("/imgs")
//    @ResponseBody
//    public static String uploadQiniu(MultipartFile file) {
//        //构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(Zone.zone2());
//        //...其他参数参考类注释
//        UploadManager uploadManager = new UploadManager(cfg);
//        //...生成上传凭证，然后准备上传
//        String accessKey = "CRfZdVOEIPoKguhCp7gaBqYIE_O3IXIkrY1F6kIQ";
//        String secretKey = "MnNPuYknrHD_Zj0AvlCClFoeknsr-oeDLNvSF4Hd";
//        //存储空间的名字
//        String bucket = "lionsystem";
//        //默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = null;
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        System.out.println(upToken+"========putRet.key");
//        try {
//            Response response = uploadManager.put(file.getBytes(), key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet+"========putRet");
//            System.out.println(putRet.key+"========putRet.key");
//            return putRet.key;
//        } catch (QiniuException ex) {
//            Response r = ex.response;
//            System.err.println(r.toString());
//            try {
//                System.err.println(r.bodyString());
//            } catch (QiniuException ex2) {
//                //ignore
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return "success";
//    }
}
