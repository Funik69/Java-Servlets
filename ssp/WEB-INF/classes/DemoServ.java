import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class DemoServ extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter pw=res.getWriter();  
  
String name=req.getParameter("name"); 
        String branch=req.getParameter("branch"); 
        String rollno=req.getParameter("rollno"); 
        pw.println("Welcome "+name);  
        pw.println("your roll no is "+rollno);
        pw.println("you are from " +branch+ " Branch");
  
pw.close();  
}} 