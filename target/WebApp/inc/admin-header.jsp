<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 24/4/2017
  Time: 12:03 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="rsr/styles/myStyle.css"/>
    <link rel="stylesheet" type="text/css" href="rsr/styles/jquery.fancybox.min.css"/>
    <link rel="stylesheet" type="text/css" href="rsr/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="rsr/styles/datepicker.css"/>
    <link href='http://fonts.googleapis.com/css?family=Merienda+One' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>
<script type="text/javascript">
    var app = app || {};
    app.admin = app.admin || {};
    app.admin.session_message = 'session';
    app.admin.remote_addr = '${pageContext.request.remoteAddr}';
    app.admin.validation_path = '${pageContext.request.contextPath}/validate';


</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/login.js"></script>

<body>
    <div class="container">
        <div id="top-header" class="basic-header" >
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <%--<a href="${pageContext.request.contextPath}/">--%>
                        <img class="logo" src="${pageContext.request.contextPath}/rsr/images/logo2.png" />
                        <h2 class="cute-font" style="display: inline">Hosting.gr Administration Console</h2>
                    <%--</a>--%>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 text-right">
                    <a class=" " href="${pageContext.request.contextPath}/Logout"><div class="top-button">Logout</div></a>
                </div>
            </div>
         </div>
        <%--<div class="row" style="height:3px; background-color:#9dad49; margin: 0%;"></div>--%>
        <div class="row" style="margin: 0%;">
            <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                <li style="color: #ffffff;"><a href="#about">ALL LISTINGS</a></li>
            </ul>
        </div>
        <%--
        <div class="row" style="height:3px; background-color:#9dad49; margin: 0%;"></div>--%>
    </div>
    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
</body>

<script>
    // When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function() {scrollFunction()};

    function scrollFunction() {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("myBtn").style.display = "block";
        } else {
            document.getElementById("myBtn").style.display = "none";
        }
    }

    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }
</script>

</html>
