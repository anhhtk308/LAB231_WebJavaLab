<%-- 
    Document   : HomePage
    Created on : Mar 13, 2020, 8:25:40 AM
    Author     : DonOzOn
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="./css/home.css" rel="stylesheet" type="text/css">-->
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="image/g28.jpg" alt="First">
                    </div>
                    <div class="description">
                        Lorem ipsum dolor sit amet
                    </div>
                    <div class="content">
                        <c:if test="${error != null}">
                            <h3>${error}</h3>
                        </c:if>

                        <c:if test="${error == null}">
                            <c:if test="${index > maxPage}">
                                <h3> Not found this page!!!</h3>
                            </c:if>
                            <ul >
                                <c:forEach items="${listGallery}" var="o">
                                    <li class="span4">
                                        <div class="image">
                                            <img src="image/${o.image}">
                                        </div>
                                        <h4>
                                            <a href="GalleryController?galeryID=${o.id}">${o.title}</a>
                                        </h4>
                                        <p>
                                            ${o.description}
                                        </p>
                                    </li>
                                </c:forEach>

                            </ul>

                        </c:if>
                        <div class="paging">
                            <c:forEach begin="1" end="${maxPage}" var="o">
                                <a class="${o==index?"active":""}" href="HomeControl?index=${o}">${o}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        ${contact.about}
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="common/Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="common/Footer.jsp"/>

    </body>
</html>
