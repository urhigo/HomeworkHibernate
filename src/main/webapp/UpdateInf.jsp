<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.06.2023
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${listPet}
<form action="UpdatePet" method="post">
    <p>Old id: "${id}"<input type="radio" name="oldId" value="${id}" checked></p>
    <p>Type: <input type="text" name="id" value="${id}"></p>
    <p>Type: <input type="text" name="type" value="${type}"></p>
    <p>Name: <input type="text" name="name" value="${name}"></p>
    <p>Age: <input type="text" name="age" value="${age}"></p>
    <input type="submit">
</form>
<h3>Start page</h3>
<a href="index.jsp">Home</a>

  </body>
</html>
