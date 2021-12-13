<%-- 
    Document   : takeQuiz
    Created on : June 7, 2021, 10:45:18 AM
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
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <span class="gen-text4">You are not allowed to do this funtion!!</span>
                    </c:when>
                    <c:otherwise>
                        <div class="wel-num-score">
                            <span class="gen-text1">Welcome<span> 
                                    <span class="gen-text3">${sessionScope.user.getUserName()}</span>
                                    </div>                
                                    <div>
                                        <span class="gen-text2">Enter number of question:</span>
                                    </div>
                                    <form action="TakeQuizController" method="post">
                                        <div>
                                            <input type="number" name="number" class="input-takeQ" required="" min="1" max="${numOfQuestion}">
                                        </div>  
                                        <div class="div-but1">
                                            <button type="submit" class="but-takeQ">Start</button>
                                        </div>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                            </div>    
                            </div>
                            </body>
                            </html>
