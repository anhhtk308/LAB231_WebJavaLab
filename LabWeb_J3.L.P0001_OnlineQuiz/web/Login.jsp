<%-- 
    Document   : login
    Created on : June 7, 2021, 9:55:35 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/logCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/headerCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="conponent/header.jsp" %>
            <div class="content">
                <div class="login-left">
                    <div class="login-text">Login Form</div>
                    <div> <span class="login-text1">User Name : </span>
                    </div>
                    <div><span class="login-text1" >Password : </span> 
                    </div>
                </div>
                <div class="login-right">
                    <form action="LoginController" method="post">
                    <div class="div-input">
                        <div>  <input name="username" value="${userName}" required="" maxlength="20"></div>
                        <div>  <input name="password" type="password" required="" maxlength="20"></div>
                        <span class="gen-text4">${mess}</span><br>
                        <button type="submit">Sign In</button>
                        <a href="Register.jsp"> Register</a>
                    </div>
                    </form>   
                </div>  
            </div>    
        </div>
    </body>
</html>
