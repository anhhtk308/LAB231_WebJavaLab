<%-- 
    Document   : header
    Created on : June 7, 2021, 9:40:20 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="../css/headerCss.css" rel="stylesheet" type="text/css"/>
        <link href="../css/homeCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="header">
            <div class="header-top">
            </div>
            <div class="header-bot">
                <div class="header-bot-img">
                    <div class="header-menu-text"> 
                        <a href="Login.jsp" class="header-text"> Home</a>
                        <a href="TakeQuizController" class="header-text">Take Quiz</a>
                        <a href="MakeQuiz.jsp" class="header-text"> Make Quiz</a>
                        <a href="ManageQuizController" class="header-text"> Manage Quiz</a>
                        <c:if test="${not empty sessionScope.user}"> <a href="LogoutController" class="header-text"> Log Out</a> </c:if>
                    </div>     
                </div>    
            </div>    
        </div>

    </body>
</html>
