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
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${galery.name}</h3>
                    </div>
                    <c:if test="${error != null}">
                        <h3 style="margin-bottom: 600px"> ${error}</h3>
                    </c:if>
                    <c:if test="${error == null}">
                        <div class="main-img">
                            <div class="imageGaler">
                                <img src="image/${mainImage}" id="imgC" alt="First">
                            </div>
                            <img id="play" class="play" src="image/play.png" alt="ccc"/> 

                        </div>

                        <div class="contentGalery">
                            <ul >
                                <c:if test="${index <= maxPage}">
                                    <c:forEach items="${listImage}" var="o">
                                        <li class="span4">
                                            <a href=""><img src="image/${o.imageUrl}"></a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                            </ul>

                            <div class="paging">
                                <c:forEach begin="1" end="${maxPage}" var="i">
                                    <a class="${i==index?"active":""}" href="GalleryController?index=${i}&galeryID=${galeryID}">${i}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="right">
                    <jsp:include page="common/Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="common/Footer.jsp"/>

        <script>
            var index = 1;
            var timeNext;
            changeImage = function () {
                var imgs = [];
            <c:forEach items="${listImage}" var="o">
                imgs.push("${o.imageUrl}");
            </c:forEach>
                document.getElementById('imgC').src = "image/" + imgs[index];
                index++;
                if (index === imgs.length) {
                    index = 0;
                }
                console.log("image/" + imgs[index]);
            };
            var playing = false;
            var getButton = document.getElementById('play');
            function pause() {
                getButton.src = "image/play.png";
                playing = false;
                clearInterval(timeNext);
            }
            function play() {
                getButton.src = "image/pause.png";
                playing = true;
                timeNext = setInterval(changeImage, 1000);
            }
            getButton.onclick = function () {
                if (playing === true) {
                    pause();
                } else {
                    play();
                }
            };
        </script>
    </body>
</html>
