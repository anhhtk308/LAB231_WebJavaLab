<%-- 
    Document   : Right
    Created on : May 6, 2021, 3:09:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--The right part of the page contains the short description of the latest news, the text entry to search and a list of the next 5 latest news.-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <div class="right">
        <div class="newst">
            <div class="titleNews">
                Digital News
            </div>
            <div class="contentNews">
                ${top1.shortDes}
            </div>
            <div class="titleNews">
                Search
            </div>
            <form action="SearchControl" method="post">
                <input class="searchBox" type="text" name="txtSearch" required size="15" value="${txt}">
                <input class="searchButton" type="submit" name="btnGo" value="Go">
            </form>
            <div class="titleNews">
                Last Articles
            </div>
                <c:forEach items="${top5}" var="o">
                <div class="lastArticles">
                    <a href="HomeControl?id=${o.id}">${o.title}</a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
