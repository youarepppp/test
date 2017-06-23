package com.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.entity.TestBean;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	
	
	@RequestMapping(value = "/d")
	public @ResponseBody String test(@RequestParam String bb){
		return "test"+bb;
		
	}
	

	@RequestMapping(value = "/u")
	public @ResponseBody String test(TestBean test,@RequestParam("file") MultipartFile[] taglocations, HttpServletRequest request, ModelMap model){
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 List<MultipartFile> taglocationss = multipartRequest.getFiles("taglocations"); 
		 String[] files = multipartRequest.getParameterValues("taglocations");
		System.out.println("uu");
		String path = request.getSession().getServletContext().getRealPath("upload"); 
		
		MultipartResolver resolver = new CommonsMultipartResolver(request

                .getSession().getServletContext());

        MultipartHttpServletRequest multipartRequest2 = resolver

                .resolveMultipart(request);

         MultipartFile file2 = multipartRequest2.getFile("cs");
		
		
		for(String file:files){
            File targetFile2 = new File(path, file);  
            if(!targetFile2.exists()){  
                targetFile2.mkdirs();  
            }  
      
            //保存  
            try {  
            	InputStream is = multipartRequest.getServletContext().getResourceAsStream(file.replace("blob:", ""));
            	 StringBuffer sb = new StringBuffer();  
                 int count = 0;  
                 while(true){  
                     int a = is.read();  
                     sb.append((char)a);  
                     if(a == '\r')  
                         count++;  
                     if(count==4){  
                         is.read();  
                         break;  
                     }  
                           
                 }  
            	MultipartFile  taglocation =multipartRequest.getFile(file);
            	taglocation.transferTo(targetFile2);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }
        }
		/*String fileName = file.getOriginalFilename();  
		File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  */
        /*String fileName2 = taglocation.getOriginalFilename();  
        File targetFile2 = new File(path, fileName2);  
        if(!targetFile2.exists()){  
            targetFile2.mkdirs();  
        }  
  
        //保存  
        try {  
        	taglocation.transferTo(targetFile2);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }*/
        for(MultipartFile taglocation:taglocationss){
        	String fileName2 = taglocation.getOriginalFilename();  
            File targetFile2 = new File(path, fileName2);  
            if(!targetFile2.exists()){  
                targetFile2.mkdirs();  
            }  
      
            //保存  
            try {  
            	taglocation.transferTo(targetFile2);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }
        }
        
        
		return "haha";
		
	}
	@RequestMapping(value = "/ttt")  
    public String ttt(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
			return "";
	}
	
	
	@RequestMapping(value = "/upload.do")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file[], HttpServletRequest request, ModelMap model) {  
  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  


        for(MultipartFile taglocation:file){
        String fileName2 = taglocation.getOriginalFilename();  
        File targetFile2 = new File(path, fileName2);  
        if(!targetFile2.exists()){  
            targetFile2.mkdirs();  
        }  
  
        //保存  
        try {  
        	taglocation.transferTo(targetFile2);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        }
        
        
        /*String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  */
  
        return "result";  
    }  
	
}
