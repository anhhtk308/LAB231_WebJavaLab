<%-- 
    Document   : newjsp
    Created on : Mar 17, 2020, 11:52:03 PM
    Author     : anhnb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="jquery-2.0.3.js"></script>
<script type="text/javascript" src="jquery.countdownTimer.js"></script>
<link rel="stylesheet" type="text/css" href="jquery.countdownTimer.css" />
    </head>
    <body>
        Today's date: <%= (new java.util.Date()).toLocaleString()%>
        
        <span id="seconds_timer">60 sec</span>
        <script>   $(function(){
	$("#seconds_timer").countdowntimer({
	});
});</script>
      
    </body>
</html>
