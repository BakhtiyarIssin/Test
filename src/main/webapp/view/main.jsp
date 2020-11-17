<%-- 
    Document   : user_menu
    Created on : 30.05.2018, 18:27:00
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Hi</h1>
       <hr/>
            ${user} 
            
       <hr/>
       <h2>Hello World!</h2>
        <a href = "controller?command = logout">quit</a>

    </body>
</html>
