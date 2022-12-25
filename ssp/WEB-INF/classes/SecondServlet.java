import java.io.*;
import java.rmi.ServerException;

import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class SecondServlet extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServerException{    
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    Cookie ck[]=request.getCookies();  
    out.print("Hello "+ck[0].getValue());  
    out.close();  
    } 
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException{
        doGet(request,response);
    }
} 








