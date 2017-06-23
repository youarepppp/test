<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.io.File"%>
<%
//System.out.println("test");

Enumeration em = request.getParameterNames();
while (em.hasMoreElements()) {
   String name = (String) em.nextElement();
   String value = request.getParameter(name);
   System.out.println(name+"       "+value);
}


if (request.getContentLength() > 0) {            
    InputStream inputStream = null;
    FileOutputStream outputStream = null;               
 try {                
     inputStream = request.getInputStream();
     // 给新文件拼上时间毫秒，防止重名
     long now = System.currentTimeMillis();
     File file = new File("d:/", "file-" + now + ".txt");
     file.createNewFile();
     
     outputStream = new FileOutputStream(file);
     
     byte temp[] = new byte[1024];
     int size = -1;
     while ((size = inputStream.read(temp)) != -1) { // 每次读取1KB，直至读完
         outputStream.write(temp, 0, size);
     }                
 } catch (Exception e) {
	System.out.println("false");
 } finally {
     outputStream.close();
     inputStream.close();
 }
}        

%>
