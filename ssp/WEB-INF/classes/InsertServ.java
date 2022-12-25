import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsertServ extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Get the data from the request
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String roll = request.getParameter("roll");

    // Insert the data into the database
    Connection conn = null;
    try {
      // Establish a connection to the database
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");

      // Create a statement
      String sql = "INSERT INTO users (name, age, roll) VALUES (?, ?, ?)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, name);
      statement.setInt(2, age);
      statement.setString(3, roll);

      // Execute the statement
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("A new user was inserted successfully!");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } finally {
      // Close the connection
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }

    // Display the data back to the user
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Insert Servlet</title></head>");
    out.println("<body>");
    out.println("<h1>Student Details:</h1>");
    out.println("Name: " + name + "<br>");
    out.println("Roll no: " + roll + "<br>");
    out.println("year: " + age);
    out.println("</body></html>");
  }
}