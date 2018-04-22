<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 24/4/2017
  Time: 12:03 μμ
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./js/jquery-1.11.3.min.js" ></script>
    <script language="JavaScript" type="text/javascript" src="/js/jquery-ui-personalized-1.5.2.packed.js"></script>
    <script language="JavaScript" type="text/javascript" src="/js/sprinkle.js"></script>
    <script type="text/javascript" src="/WebApp/scripts/newListingForm.js"></script>


</head>
<script type="text/javascript">
    /*i dont like this version*/
    <%--app.admin.validation_path = '${pageContext.request.contextPath}/validate';--%>
</script>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    /*if(userName == null) response.sendRedirect("login.html");*/
%>

<body>
    <div class="container">
        <div id="top-header" class="basic-header" >
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <a href="${pageContext.request.contextPath}/">
                        <img class="logo" src="${pageContext.request.contextPath}/rsr/images/logo2.png" />
                        <h2 class="cute-font" style="display: inline">Hosting.gr as ${sessionScope.user}</h2>
                    </a>
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6 text-right">
                    <c:choose>
                        <c:when test = "${sessionScope.user == 'visitor' || sessionScope.user ==null}">
                            <a class=" " href="${pageContext.request.contextPath}/sign_up"><div class="top-button">Sign up</div></a>
                            <a class="loginbutton" href="#loginform"><div class="top-button">Login</div></a>

                            <%--a stylish popup!--%>
                            <form id="loginform" action="" hidden>
                                <div class="imgcontainer">
                                    <img src="${pageContext.request.contextPath}/rsr/images/avatar.jpg" alt="Avatar" class="avatar">
                                </div>
                                <div class="container">
                                    <label><b>Username</b></label>
                                    <input type="text" id="username" placeholder="Enter Username" name="login" required>

                                    <label><b>Password</b></label>
                                    <input type="password" id="password" placeholder="Enter Password" name="password" required>

                                    <div id="message" <%--style="display:none;"--%>>message goes here</div>

                                    <button name="login" id="login" <%--type="submit" onclick="Login()"--%>>Login</button>
                                    <input type="checkbox" checked="checked"> Remember me
                                </div>

                                <div class="container" style="background-color:#f1f1f1">
                                    <button type="button" class="cancelbtn">Cancel</button>
                                    <span class="psw">Forgot <a href="#">password?</a></span>
                                </div>

                            </form>

                        </c:when>
                        <c:when test = "${sessionScope.user != null}">
                           <%-- <a class=" " href="${pageContext.request.contextPath}/listings"><div class="top-button">Profile</div></a>--%>
                            <a class=" " href="${pageContext.request.contextPath}/profile"><div class="top-button mygreen">My Profile</div></a>
                            <a class=" " href="${pageContext.request.contextPath}/Logout"><div class="top-button">Logout</div></a>
                        </c:when>
                        <%--<c:otherwise>
                          <a class=" " href="${pageContext.request.contextPath}/Logout"><div class="top-button">Logout</div></a>
                        </c:otherwise>--%>
                    </c:choose>

                </div>
            </div>
         </div>
        <%--<div class="row" style="height:3px; background-color:#9dad49; margin: 0%;"></div>--%>
        <div class="row" style="margin: 0%;">
            <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                <li style="color: #ffffff;"><a href="#about">ALL LISTINGS</a></li>
            </ul>
            <%--<c:choose>
                <c:when test = "${sessionScope.user == 'visitor'}">
                    <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                        <li style="color: #ffffff;"><a href="#about">ALL LISTINGS</a></li>
                    </ul>
                </c:when>
                <c:when test = "${sessionScope.user == 'admin'}">
                    <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                        <li style="color: #ffffff;"><a href="#about">LISTINGS</a></li>
                        <li style="color: #ffffff;"><a href="#about">USERS</a></li>
                        <li style="color: #ffffff;"><a href="#about">RESERVATIONS</a></li>
                    </ul>
                </c:when>
                <c:when test = "${sessionScope.user != null }">
                    <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                        <li style="color: #ffffff;"><a href="#about">PROFILE</a></li>
                        <li style="color: #ffffff;"><a href="#about">RESERVATIONS</a></li>
                        <li style="color: #ffffff;"><a href="#about">LISTINGS</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="col-lg-12 col-md-12 hidden-xs myorange">
                        <li style="color: #ffffff;"><a href="#about">ERROR IN SESSION OBJECT</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>--%>
            <%--<ul class="col-lg-12 col-md-12 hidden-xs myorange">
                <li><a href="#about">Home</a></li>
                <li><a href="#news">News</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="#about">About</a></li>
            </ul>--%>
            <%--<ul class="col-xs-12 visible-xs-block">
                <li style="color: #ffffff;">MENU</li>
            </ul>--%>
        </div>
        <%--
        <div class="row" style="height:3px; background-color:#9dad49; margin: 0%;"></div>--%>
    </div>
    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/login.js"></script>
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
