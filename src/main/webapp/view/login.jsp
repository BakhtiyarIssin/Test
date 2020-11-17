<%-- 
    Document   : index
    Created on : 30.05.2018, 11:38:56
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
        <h1>Start Page</h1>       
         
        
        <form name="loginForm"    method ="POST" action="controller" >
            <input type ="hidden" name="command" value ="login" />
            <label><input type ="text" name ="login"></label> login <br>
            <label><input type ="password" name ="password"></label> password <br>
            <br/> ${error}
            <br/> ${wrongAction}
            <br/> ${nullPage}
            <br/>
            <input type = "submit" value ="Ok" name ="Ok"><br>          
            
        </form>
        
        

    </body>
</html>
