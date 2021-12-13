<%-- 
    Document   : Error
    Created on : May 6, 2021, 3:10:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1>${error}</h1>
                </div>
                <jsp:include page="common/Right.jsp"/>
            </div>
            <jsp:include page="common/Footer.jsp"/>
        </div>
    </body>
</html>
