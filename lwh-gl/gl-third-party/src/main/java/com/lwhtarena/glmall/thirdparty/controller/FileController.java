package com.lwhtarena.glmall.thirdparty.controller;

import com.lwhtarena.common.utils.R;
import com.lwhtarena.glmall.thirdparty.file.FastDFSFile;
import com.lwhtarena.glmall.thirdparty.util.FastDFSClient;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwh
 * @Title: FileController
 * @Package com.lwhtarena.glmall.thirdparty.controller
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/29 11:21
 */
@RestController
public class FileController {

    /**
     * @RestController 在做文件处理时，需要consumes = MediaType.MULTIPART_FORM_DATA处理，要不然会出现失败异常
     * 或者使用@Controller亦可
     * @param file
     * @return
     */
//    @RequestMapping(value = "/fdfs/upload",method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping(value = "/fdfs/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R fdfsUpload(@RequestParam(value = "file",required = false) MultipartFile file){

        Map<String, String> respMap = new HashMap<>();
        try {
            //1. 创建图片文件对象(封装)
            //2. 调用工具类实现图片上传
            FastDFSFile fastdfsfile = new FastDFSFile(
                    /**原来的文件名  1234.jpg**/
                    file.getOriginalFilename(),
                    /**文件本身的字节数组**/
                    file.getBytes(),
                    StringUtils.getFilenameExtension(file.getOriginalFilename())
            );
            String[] upload = FastDFSClient.upload(fastdfsfile);

            /**
             * upload[0] group1
             * upload[1] M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
             * 3. 拼接图片的全路径返回
             * http://192.168.211.132:8080/group1/M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
             */
            respMap.put("host",FastDFSClient.getTrackerUrl());
            respMap.put("fdfs",FastDFSClient.getTrackerUrl()+"/"+upload[0]+"/"+upload[1]);
            respMap.put("policy","/"+upload[0]+"/"+upload[1]);


            return R.ok().put("data",respMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("data",respMap);
    }

    /**
     * 返回 图片的全路径
     *
     * @param file 页面的文件对象
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            //1. 创建图片文件对象(封装)
            //2. 调用工具类实现图片上传

            //String substring = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            FastDFSFile fastdfsfile = new FastDFSFile(
                    file.getOriginalFilename(),//原来的文件名  1234.jpg
                    file.getBytes(),//文件本身的字节数组
                    StringUtils.getFilenameExtension(file.getOriginalFilename())
            );
            String[] upload = FastDFSClient.upload(fastdfsfile);

            //  upload[0] group1
            //  upload[1] M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
            //3. 拼接图片的全路径返回

            // http://192.168.211.132:8080/group1/M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg

            // http://192.168.211.132:8080  +
            System.out.println("====="+FastDFSClient.getTrackerUrl());
            return FastDFSClient.getTrackerUrl()+"/"+upload[0]+"/"+upload[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/testupload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String testupload(@RequestParam("file") MultipartFile file){
        String fileName=file.getOriginalFilename();
        System.out.println("file:"+fileName);
        return "ok";
    }
}
