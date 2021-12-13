<%-- 
    Document   : manageQuiz
    Created on : June 7, 2021, 10:25:47 AM
    Author     : DELL
--%>

<%@page import="dao.impl.QuizDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="css/generalCss.css" rel="stylesheet" type="text/css"/>
        <link href="css/headerCss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manaQuizCss.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="conponent/header.jsp" %>
            <div class="content">
                <c:choose>
                    <c:when test="${!sessionScope.user.isType()}">
                        <span class="gen-text4">You are not allowed to do this funtion!!</span>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <div>
                                <span class="gen-text2">Number of question:</span>
                                <span class="gen-text3">${totalQuestions}</span>
                            </div>
                            <table>
                                <tr>
                                    <th class="gen-text3" id="th1">Question</th>
                                    <th class="gen-text3">Date Created </th>
                                </tr>
                                <c:forEach items="${lstQuestions}" var="q">
                                    <tr>
                                        <td id="td1">
                                            <span class="gen-text2" > ${q.getContent()}</span>
                                        </td>
                                        <td>
                                            <span  class="gen-text2"> ${q.getDateFormat()} </span>

                                        </td>
                                        <td>
                                            <form id="formDelete" action="ManageQuizController" method="post">
                                                <input type="hidden" name="qid" value="${q.getId()}"/>
                                                <input type="button" onclick="isDelete()" value="Delete"/>
                                            </form>
                                        </td>    
                                    <tr>
                                    </c:forEach>
                                    <%
                                        Integer pageIndex = (Integer) request.getAttribute("pageIndex");
                                        Integer pageCount = (Integer) request.getAttribute("pageCount");
                                        Integer pageGap = (Integer) request.getAttribute("pageGap");
                                    %>
                                    <th class="paging"><%= dao.impl.QuizDAOImpl.pager(pageIndex, pageCount, pageGap)%></th>
                            </table>
                        </div>
                    </c:otherwise>
                </c:choose>
                <script src="js/question.js" type="text/javascript"></script>
            </div>    
        </div>
    </body>
</html>
