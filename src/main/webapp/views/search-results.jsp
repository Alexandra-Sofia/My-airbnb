<%--
  Created by IntelliJ IDEA.
  User: gloman
  Date: 27/4/2017
  Time: 12:04 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Search</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>
   <div class="container">
       <div class="row">
           <div class="col-lg-3 col-md-3 col-xs-0">
                   <div class="row text-center">
                       <div id="search-box-home" class="search-box">
                           <%--<div class="row">
                               <div class="htitle">Insert your criteria here to search for accomondations</div>
                           </div>--%>
                           <div class="row">
                               <div class="htitle">Change Criteria</div>
                               <c:forEach begin="0" end="5" varStatus="loop" var="k">
                                   <div class="col-lg-12 col-md-12 col-xs-12">
                                       <div class="top-margin">
                                           <h7>Attribute ${k}:</h7>
                                           <select id="soflow">
                                               <c:forEach begin="0" end="3" varStatus="loop" var="i">
                                                   <option value="${i}">${i}</option>
                                               </c:forEach>
                                           </select>
                                       </div>
                                   </div>
                               </c:forEach>
                           </div>
                       </div>
                       <a class=" " href="${pageContext.request.contextPath}/search"><button type="button" class="attention-button">SEARCH</button></a>
                   </div>
           </div>

           <div class="col-lg-9 col-md-9 col-xs-12">
               <div class="search-list">

                   <div class="category-tag">Results in [Location goes here]</div>
                    <%-- ΑΡΧΗ PAGING --%>
                         <c:if test="${requestScope.SEARCHRESULTS.size() > requestScope.PAGESIZE}">
                         <div class="pager">
                              <select>
                                <c:forEach var="page" begin="1" end="${requestScope.SEARCHRESULTS.size()/requestScope.PAGESIZE}">
                                  <option value="${page}">page${page}</option>
                              </c:forEach>
                              </select>
                         </div>
                         </c:if>
                     <%-- ΤΕΛΟΣ PAGING --%>
                    <c:forEach items="${requestScope.SEARCHRESULTS}" var="row" begin="${0 + (requestScope.PAGE -1) * requestScope.PAGESIZE}"
                            end="${requestScope.PAGESIZE*requestScope.PAGE <= requestScope.SEARCHRESULTS.size() ? requestScope.PAGESIZE*requestScope.PAGE-1 : requestScope.SEARCHRESULTS.size() -1}" varStatus="status">
                        <%--<c:choose>
                            <c:when test="${not empty row.id}">${row.id},${row.name}
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>--%>
                        <div class="col-lg-4 col-md-4 col-xs-6">
                            <div class="one-one" data-map-coordinates data-latitude="${row.latitude}" data-longitude="${row.longitude}">
                                <a class="" href="${pageContext.request.contextPath}/apartment?id=${row.id}">
                                    <div class="apartment">
                                        <img style="height: inherit" src="${row.picture}" />
                                    </div>
                                </a>
                                <div class="info-synopsis">
                                    <div class="info-synopsis-row info-synopsis-name">${row.name}</div>
                                    <div class="info-synopsis-row info-synopsis-type">${row.room_type}</div>
                                    <div class="info-synopsis-row info-synopsis-city">${row.city}</div>
                                    <div class="info-synopsis-row info-synopsis-price">${row.price}</div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>

               </div>
           </div>

       </div>
   </div>


    <jsp:include page="/inc/footer.jsp"/>
</body>
</html>
