<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 21/3/2017
  Time: 4:27 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Home</title><%--
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rsr/bootstrap/css/*.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rsr/styles/myStyle.css">--%>

</head>

<body>
    <jsp:include page="/inc/header.jsp"/>
    <div class="container">
        <c:if test="${sessionScope.user != null && sessionScope.user!='visitor'}">
            <jsp:include page="/inc/insertListingForm.jsp"/>
        </c:if>
    </div>

    <%--<h2>${pageContext.request.contextPath}</h2>--%>

    <div id="search-thingy" class="container">

        <%--<div class="row">
            <div class="category-tag">SEARCH</div>
        </div>--%>
        <div class="row text-center">
            <div id="search-box-home" class="search-box">
                <%--<div class="row">
                    <div class="htitle">Insert your criteria here to search for accomondations</div>
                </div>--%>
                <div class="row">
                    <%--<div class="htitle">Search</div>--%>

                    <%--<c:forEach begin="0" end="2" varStatus="loop" var="k">--%>
                        <div class="col-lg-4 col-md-4 col-xs-12">
                            <div class="top-margin">
                                <%--<h7>Attribute ${k}:</h7>--%>
                                <h7 class="search-label">Location</h7>
                                <select id="search-field-location" name="location" class="myDropdown">
                                    <%--<c:forEach begin="0" end="3" varStatus="loop" var="i">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>--%>
                                    <c:forEach items="${requestScope.PLACES}" var="row" varStatus="status">
                                       <option value=" ${row}"> ${row}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-xs-12">
                            <div class="top-margin">
                                <%--<h7>Attribute ${k}:</h7>--%>
                                <h7 class="search-label">From</h7>
                                <input class="searchInput" id="dateFrom" name="dateFrom"/>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-xs-12">
                            <div class="top-margin">
                                <%--<h7>Attribute ${k}:</h7>--%>
                                <h7 class="search-label">To</h7>
                                <input class="searchInput" id="dateTo" name="dateTo" />
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-xs-12">
                            <div class="top-margin">
                                <%--<h7>Attribute ${k}:</h7>--%>
                                <h7 class="search-label">Visitors</h7>
                                <select id="search-field-visitor" name="visitors" class="myDropdown">
                                    <c:forEach begin="0" end="${requestScope.GUESTS[0]-1}" varStatus="loop" var="i">
                                        <option value="${i+1}">${i+1}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-xs-12">
                            <div class="top-margin">
                            <a class=" " href="${pageContext.request.contextPath}/search"><button type="button" class="attention-button js-search-btn mygreen">SEARCH</button></a>

                            </div>
                        </div>
                <%--</c:forEach>--%>
                </div>
               <%-- <a class=" " href="${pageContext.request.contextPath}/search"><button type="button" class="attention-button js-search-btn mygreen">SEARCH</button></a>
 --%>           </div>
        </div>
        <div class="row">
            <div class="category-tag">TOP RATED</div>
        </div>
    </div>
    <div id="popular" class="container">
            <div id=display" class="row">

                <c:forEach items="${requestScope.SUGGESTIONS}" var="row" begin="0" end="11" varStatus="status">
                    <%--<c:choose>
                        <c:when test="${not empty row.id}">${row.id},${row.name}
                        </c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>--%>
                    <div class="col-lg-4 col-md-4 col-xs-6">
                        <div class="one-one" data-map-coordinates data-latitude="${row.latitude}" data-longitude="${row.longitude}">
                            <a class=" " href="${pageContext.request.contextPath}/listing?id=${row.id}">
                                <div class="apartment">
                                    <img style="height: inherit" src="${row.picture}" />
                                </div>
                            </a>
                            <div class="info-synopsis">
                                <div class="info-synopsis-row info-synopsis-name">${row.name}</div>
                                <div class="info-synopsis-row info-synopsis-type">${row.room_type}</div>
                                <div class="info-synopsis-row info-synopsis-city">${row.city}</div>
                                <div class="info-synopsis-row info-synopsis-price">${row.price}</div>
                                <%--<div class="info-synopsiscountry">${row.country}</div>--%>
                            </div>
                        </div>
                    </div>

                </c:forEach>

                <%--<c:forEach begin="0" end="5" varStatus="loop">
                    <div class="col-lg-4 col-md-4 col-xs-6">
                         <div class="one-one">
                             <a class=" " href="${pageContext.request.contextPath}/apartment"><div class="apartment">
                                 <img style="height: inherit" src="${pageContext.request.contextPath}/rsr/images/room.jpg" /></div></a>
                             &lt;%&ndash;<div class="info-synopsis">&ndash;%&gt;
                             <div class="row"><div class="info-synopsis"> Cute Little Cottage, Middle-of-Nowhere</div></div>
                             <div class="row"><div class="info-synopsis"> 100$ </div></div>
                             <div class="row">
                                 <div class="info-synopsis">
                                 <img class="rating" src="${pageContext.request.contextPath}/rsr/images/star.png" />
                                 <img class="rating" src="${pageContext.request.contextPath}/rsr/images/star.png" />
                                 <img class="rating" src="${pageContext.request.contextPath}/rsr/images/star.png" />
                                 <img class="rating" src="${pageContext.request.contextPath}/rsr/images/star.png" />
                                 <img class="rating" src="${pageContext.request.contextPath}/rsr/images/star.png" />&nbsp;&nbsp;&nbsp;&nbsp;See reviews
                                </div>
                             </div>
                             &lt;%&ndash;</div>&ndash;%&gt;
                         </div>
                     </div>
                </c:forEach>--%>
            </div>
    </div>
    <div id="mapHolder" class="container">
        <div id=map-main" class="row text-center">
            <div class="col-lg-12 col-md-12 col-xs-12">
                <div class="map" id="map">
                    <!--
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d12581.834113000254!2d23.7360641!3d37.96642725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sel!2sgr!4v1494495440915" width="100%" height="100%" frameborder="0" style="border:0" allowfullscreen></iframe>
                    -->
                </div>
            </div>
        </div>

    </div>


    <jsp:include page="/inc/footer.jsp"/>

</body>
</html>
