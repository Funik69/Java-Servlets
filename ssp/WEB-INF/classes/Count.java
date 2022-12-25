import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Count extends HttpServlet {
	String filename="counter.txt";
	 int hitCount;

	public void init()
	{
		try{
			FileReader fileReader= new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String initial=bufferedReader.readLine();
			hitCount=Integer.parseInt(initial);

		}catch(FileNotFoundException e){hitCount=0;}
		catch(IOException e){hitCount=0;}
		catch(NumberFormatException e){hitCount=0;}
	}
	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		hitCount++;
		String title="Number of times servlet access is : ";
		String docType
            = "<!doctype html public \"-//w3c//dtd html 4.0 "
              + "transitional//en\">\n";
		PrintWriter out = response.getWriter();
		out.println(docType+ "<html>\n"
		+ "<head><title>" + title + "</title></head>\n"
		+ "<body>\n"
		+ "<h1>" + title + "</h1>\n"
		+ "<h2>" + hitCount
		+ "</h2>\n"
		+ "</body>"
		+ "</html>");
		out.close();
	}

	public void destroy(){
		try{
			FileWriter fileWriter=new FileWriter(filename);
			String countStr= Integer.toString(hitCount);
			fileWriter.write(countStr);
			fileWriter.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
