<!DOCTYPE html>
<html>
<head>
</head>
<body>
 
  <h2>Jsp containing some info</h2><br>
<h4>Current Time: <%= new java.util.Date() %></h4>
<h4>Server: <%= application.getServerInfo() %></h4>
<h4>Session: <%= session.getId() %></h4> 
<form action="Jsp.jsp" method="post" >
    <input type="text" name="name" id="name" />
    <input type="submit" />
</form>
<h4>Parameters: <%= request.getParameter("name") %></h4>
</body>
</html>