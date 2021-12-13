<%-- 
    Document   : SearchResultPage
    Created on : May 6, 2021, 3:10:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--page shows news search results by title-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .itemsNews{
                clear: both;
            }
            .title{
                padding-top: 15px;
            }
            .main{
                padding-top: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="content">
                <div class="main">
                    <c:forEach items="${list}" var="o">
                        <div class="itemsNews">
                            <div class="title">
                                <a href="HomeControl?id=${o.id}">${o.title}</a>
                            </div>
                            <div class="image_search">
                                <img src="images/${o.image}" alt=""/>
                            </div>
                            <div class="shorDes_search">
                                ${o.shortDes}
                            </div></div>
                        </c:forEach>
                </div>
                <jsp:include page="common/Right.jsp"/>
            </div>
            <div class="paging">
                <c:forEach begin="1" end="${maxPage}" var="i">
                    <a class="${i==index?"active":""}" href="SearchControl?index=${i}&txtSearch=${txt}">${i}</a>
                </c:forEach>
            </div>
            <jsp:include page="common/Footer.jsp"/>
        </div>
    </body>
</html>
