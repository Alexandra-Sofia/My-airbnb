<%--
  Created by IntelliJ IDEA.
  User: gloman
  Date: 27/4/2017
  Time: 12:20 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Profile</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-12">
                <div class="vertical-menu">
                    <a id="info" class="active">My info</a>
                    <a href="#">My Reservations</a>
                    <a href="#">My Listings</a>

                </div>
            </div>
            <div class="col-lg-9 col-md-9 col-xs-12">
                <%
                    String userName = null;
                    Cookie[] cookies = request.getCookies();
                    if(cookies !=null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("user")) userName = cookie.getValue();
                        }
                    }
                %>
                <div class="user-info">


                </div>
                <%--<div class="category-tag"><%=userName%> profile informations</div>--%>
                <div id="my-username" data-username="<%=userName%>"></div>
            </div>

        </div>
        <div class="container">
            <c:if test="${sessionScope.user != null && sessionScope.user!='visitor'}">
                <jsp:include page="/inc/insertListingForm.jsp"/>
            </c:if>
        </div>

    </div>


    <jsp:include page="/inc/footer.jsp"/>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/profileinfo.js"></script>
</html>
