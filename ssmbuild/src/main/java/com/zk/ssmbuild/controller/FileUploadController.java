package com.zk.ssmbuild.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("fileUploadController")
public class FileUploadController {

    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, Model model) throws IOException {
        String originalFilename = file.getOriginalFilename();
        FileItem fileItem = file.getFileItem();
        InputStream inputStream = fileItem.getInputStream();
        File f=new File(originalFilename);
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        int b=0;
        while ((b=inputStream.read())!=-1){
            fileOutputStream.write(b);
        }
        inputStream.close();
        fileOutputStream.close();
        System.out.println(f.getAbsolutePath());
        model.addAttribute("fileName",originalFilename+" 文件上传成功");
        return "fileUpload";
    }

    @RequestMapping("goFileUpload")
    public String goFileUpload(Model model){

        return "goFileUpload";
    }

    @RequestMapping("/download")
    public String download(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String fileName = request.getParameter("fileName");
        //设置响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

        //要下载图片的地址
        String requestPath = request.getServletPath();
        String contextPath = request.getContextPath();
        String downloadPath = request.getServletContext().getRealPath("WEB-INF\\upload");


        logger.debug("访问路径"+requestPath);
        logger.debug("项目路径"+contextPath);
        logger.debug("下载文件路径"+downloadPath);
        File file = new File(downloadPath, fileName+"ss");
        String absolutePath = file.getAbsolutePath();
        logger.debug("下载文件绝对路径"+absolutePath);


        InputStream fileInputStream = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        int b=0;
        while ((b=fileInputStream.read())!=-1){
            out.write(b);
        }
        fileInputStream.close();
        out.close();

        return "OK";
    };


    @RequestMapping("/goDownload")
    public String goDownload() throws IOException {

        return "goDownload";
    };
}
