import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"+
        "<head><title>Hello World!</title>\n"+
        "<body>\n"+
        "<h1>Hello World!</h1>\n"+
        "</body></html>");}
}