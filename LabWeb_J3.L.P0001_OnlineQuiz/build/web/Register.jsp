<%-- 
    Document   : register
    Created on : June 7, 2021, 10:36:45 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/logCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/headerCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>

        <div class="container">
            <%@include file="conponent/header.jsp" %>
            <div class="content">
                <div class="login-left-logout">
                    <div class="login-text">Registration Form</div>
                    <div> <span class="login-text1">User Name: </span>
                    </div>
                    <div><span class="login-text1" >Password: </span> 
                    </div>
                    <div><span class="login-text1" >User Type: </span> 
                    </div>
                    <div><span class="login-text1" >Email: </span> 
                    </div>
                </div>
                <div class="login-right-logout">
                    <form action="RegisterController" method="post">
                        <div class="div-input-logout">
                            <div>  <input id="inputt" name="username" value="${userName}" required="" maxlength="20" ></div>
                            <div>  <input type="password" id="inputt" name="password" required="" maxlength="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"></div>
                            <div> <select name="userType">
                                    <option value="1" <c:if test="${userType == 1}"> selected</c:if>>Teacher</option>
                                    <option value="2" <c:if test="${userType == 2}"> selected</c:if>>Normal User</option>
                                </select></div>
                                    <div>  <input name="email" value="${email}" required="" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" maxlength="30"></div>
                            <span class="gen-text4">${mess}</span><br>
                            <button type="submit">Register</button>
                        </div>
                    </form>
                </div>    
            </div>    
        </div>
    </body>
</html>
