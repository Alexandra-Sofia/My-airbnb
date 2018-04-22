<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28/6/2017
  Time: 6:43 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Admin</title>
    <head>
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    </head>
</head>
<body>
    <jsp:include page="/inc/admin-header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-xs-12">
                <div class="vertical-menu">
                    <a href="#" class="active">Users</a>
                    <a href="#">Listings</a>
                    <a href="#">Reservationss</a>
                </div>
            </div>
            <div class="col-lg-9 col-md-9 col-xs-12">
                <div class="category-tag">Sorry! Page is currently under constraction</div>
                <img class="map" src="${pageContext.request.contextPath}/rsr/images/giphy.webp" />
            </div>
        </div>
    </div>
</body>
</html>
