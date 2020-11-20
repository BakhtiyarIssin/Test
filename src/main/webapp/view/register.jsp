<%-- 
    Document   : register
    Created on : 04.06.2018, 16:01:22
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h2>Register</h2>    
          

        <form name="registerForm"    method ="POST" action="register" >
            <input type ="hidden" name="command" value ="register" />
            <label><input type ="text" name ="login"></label> login <br>
            <label><input type ="password" name ="password"></label> password <br>
            <c:out value="${sessionScope.password}" />
            <c:out value="${sessionScope.error}" />
            <c:out value="${sessionScope.userIsExist}" />
            <br/> ${wrongAction}
            <br/> ${nullPage}
            <br/>
            <input type = "submit" value ="Ok" name ="Ok"><br>

        </form>


        <c:out value="${requestScope.warning}"/>
        
        
    </body>
</html>
