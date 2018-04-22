<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<head>
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="rsr/bootstrap/css/*.css">
    <link rel="stylesheet" type="text/css" href="rsr/styles/myStyle.css">

</head>

<body>


    <jsp:include page="/inc/header.jsp"/>

    <h2>This is index.jsp</h2>
    <h2>${pageContext.request.contextPath}</h2>
    <h2>request.getContextPath()</h2>


   <%-- <form action="src/main/resources/scripts/forming.js">
        First name:<br>
        <input type="text" name="firstname" value="Mickey">
        <br>
        Last name:<br>
        <input type="text" name="lastname" value="Mouse">
        <br><br>
        <input type="submit" value="Submit">
    </form>
--%>

    <%-- <div class="row " style="color: #e38d13">
          <jsp:include page="/views/home.jsp"/>
      </div>
  --%>

    <%--<jsp:include page="/inc/footer.jsp"/>--%>

</body>
</html>
