<%-- 
    Document   : index
    Created on : 03.06.2018, 18:54:38
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hi</h1>
        
       
        
        <a href = "${pageContext.request.contextPath}/view/login.jsp">enter</a>
        
        <a href = "${pageContext.request.contextPath}/view/register.jsp">register</a>
        
        
    </body>
</html>
