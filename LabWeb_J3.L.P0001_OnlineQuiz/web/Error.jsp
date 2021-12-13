<%-- 
    Document   : error
    Created on : June 7, 2021, 9:50:30 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link href="css/logCss.css" rel="stylesheet" type="text/css"/>-->
        <link href="css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/headerCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="conponent/header.jsp"/>
            <div class="content">
                <span>${error}</span>
            </div>
        </div>
    </body>
</html>
