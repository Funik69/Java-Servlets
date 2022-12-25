import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ncount extends HttpServlet {
    static int count=0;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {   
        count++;
        String show="No of Count is";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(show + count);}

}