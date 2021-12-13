<%-- 
    Document   : HomePage
    Created on : May 6, 2021, 2:48:14 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--The page displays the latest news and the top 5 news next-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="content">
                <div class="main">
                    <div class="title">
                        ${currentNews.title}
                    </div>
                    <div class="image">
                        <img src="images/${currentNews.image}" alt=""/>
                    </div>
                    <div class="text">
                        ${currentNews.description}
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${currentNews.author} | ${dateConvert}
                    </div>
                </div>
                <jsp:include page="common/Right.jsp"/>
            </div>
            <jsp:include page="common/Footer.jsp"/>
        </div>
    </body>
</html>
