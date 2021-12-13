<%-- 
    Document   : Right
    Created on : Mar 13, 2020, 9:28:36 PM
    Author     : DonOzOn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/right.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="header-right">
            <h4>Share this page</h4>
        </div>
        <div class="social">
            <div>
                <ul>
                    <li><img src="image/${contact.iconFace}"><a href="${contact.faceUrl}"><span> Share on Facebook</span></a></li>
                    <li><img src="image/${contact.iconTwitter}"><a href="${contact.twitterUrl}"><span> Share on Twitter</span></a></li>
                    <li><img src="image/${contact.iconGoogle}"><a href="${contact.googleUrl}"><span> Share on Google</span></a></li>
                </ul>
            </div>

        </div>
    </body>
</html>
