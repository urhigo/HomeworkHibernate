<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.06.2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>RESULT</h3>
${listPet}
<br>
<h3>Write new information</h3>
<form action="ControlValue" method="post">
  <p>Id: <input type="text" name="id" value=""></p>
  <input type="submit">
</form>
<h3>Start page</h3>
<a href="index.jsp">Home</a>

</body>
</html>
