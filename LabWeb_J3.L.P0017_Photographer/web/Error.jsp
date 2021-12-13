<%-- 
    Document   : Error
    Created on : Mar 13, 2020, 9:28:48 PM
    Author     : DonOzOn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="main">
                <div class="left">
                    <h1>${error}</h1>
                </div>
                <div class="right">
                    <jsp:include page="common/Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="common/Footer.jsp"/>
    </body>
</html>
