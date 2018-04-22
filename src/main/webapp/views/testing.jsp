<%--
  Created by IntelliJ IDEA.
  User: gloman
  Date: 28/4/2017
  Time: 2:55 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,entities.myCalendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><html>

<head>
    <title>Testing Page!</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <script src="scripts/forming.js"/>
    <script>

    </script>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>
    <div class="container" style="height:250px; width:500px;">
        <%--<div class="row">
            <jsp:include page="/inc/calendar.jsp"/>
        </div>--%>
        <%--<c:import url="/calendar.inc"/>--%>
        <%--<div class="row text-center">
            <button id ="btn">Fetch</button>
            <div id="name">

            </div>
            <div id="summary">

            </div>
            <div id="location">

            </div>
            <div id="description">

            </div>
        </div>--%>
    </div>

</body>
</html>
