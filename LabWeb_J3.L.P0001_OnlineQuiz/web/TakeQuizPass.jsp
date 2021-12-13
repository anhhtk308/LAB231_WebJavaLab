<%-- 
    Document   : takeQuizAnser
    Created on : June 7, 2021, 10:59:49 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/headerCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/takeQuizCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="conponent/header.jsp" %>
            <div class="content">
                <div class="div-score">
                    <span class="gen-text2">Your score</span>
                    <span class="gen-text3">${point} (${pointP}%) -  </span>
                    <c:choose>
                        <c:when test="${point>'5'}">
                            <span class="gen-text3">   passed </span>
                        </c:when>    
                        <c:otherwise>
                            <span class="gen-text4">   not passed </span>
                        </c:otherwise>
                    </c:choose>
                </div>  
                <div>
                    <span class="gen-text2">Take another test</span>
                    <form class="form-class" action="TakeQuizController" method="get">
                        <button type="submit" >Start</button>
                    </form>
                </div>                   
            </div>    
        </div>
    </body>
</html>
