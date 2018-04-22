<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 27/4/2017
  Time: 12:03 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>${requestScope.APARTMENT.name} - Apartment</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="scripts/forming.js"></script>
    <script src="scripts/book-listing.js"></script>

</head>
<body>

    <jsp:include page="/inc/header.jsp"/>
    <div class="container-fluid" style="padding:0%">
        <div class="apartment-main  text-center">
            <img class='big-image' src="${requestScope.APARTMENT.xl_picture}" />
        </div>
    </div>
    <div class="container my-container">
        <div class="row"><div class="image-tag">
            <div class='col-lg-8 col-md-8 col-xs-8'><br></div>
            <div class='col-lg-4 col-md-4 col-xs-4'>
                <div class='host'>
                    <div class='col-lg-4 col-md-4 col-xs-4'>
                        <div class='atr-name'>Host</div>
                    </div>
                    <div class='col-lg-4 col-md-4 col-xs-4'>
                        <div class='atr-descr cute-font'>${requestScope.APARTMENT.host.name}</div>
                    </div>
                    <div class='col-lg-4 col-md-4 col-xs-4'>
                    <c:if test="${requestScope.HOST.has_profile_pic}">
                        <div class='host-pic'><img class='big-image' src="${requestScope.APARTMENT.host.thumbnail_url}" /></div>
                    </c:if>
                    </div>
                </div>
            </div>
        </div></div>
        <div class="row">
            <div class="col-lg-8 col-md-8 col-xs-12 text-center">
                <div class="apart-page-info">
                   <div class="category-tag">Information</div>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Name</div>
                      </div>
                      <div class="col-lg-10 col-md-10 col-xs-10">
                         <div class="atr-descr">${requestScope.APARTMENT.name}</div>
                      </div>
                   </div>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Summary</div>
                      </div>
                      <div class="col-lg-10 col-md-10 col-xs-10">
                         <div class="atr-descr">${requestScope.APARTMENT.summary}</div>
                      </div>
                   </div>
                   <%--
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Space</div>
                      </div>
                      <div class="col-lg-10 col-md-10 col-xs-10">
                         <div class="atr-descr">${requestScope.APARTMENT.space}</div>
                      </div>
                   </div>
                   --%>
                   <c:if test="${requestScope.APARTMENT.description}">
                        <div class='inforow'>
                       <div class='col-lg-2 col-md-2 col-xs-2'>
                           <div class='atr-name'>Description</div>
                       </div>
                       <div class='col-lg-10 col-md-10 col-xs-10'>
                           <div class='atr-descr'>${requestScope.APARTMENT.description}</div>
                            </div>
                        </div>
                   </c:if>
                   <%--
                   <c:if test="${requestScope.APARTMENT.experiences_offered}">
                       <div class='inforow'>
                      <div class='col-lg-2 col-md-2 col-xs-2'>
                          <div class='atr-name'>Experiences</div>
                      </div>
                      <div class='col-lg-10 col-md-10 col-xs-10'>
                          <div class='atr-descr'>${requestScope.APARTMENT.experiences_offered}</div>
                           </div>
                       </div>
                    </c:if>
                   <c:if test="${requestScope.APARTMENT.neighborhood_overview}">
                      <div class='inforow'>
                     <div class='col-lg-2 col-md-2 col-xs-2'>
                         <div class='atr-name'>Neighborhood</div>
                     </div>
                     <div class='col-lg-10 col-md-10 col-xs-10'>
                         <div class='atr-descr'>${requestScope.APARTMENT.neighborhood_overview}</div>
                          </div>
                      </div>
                   </c:if>

                    --%>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Property</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.property_type}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Room type</div>
                      </div>
                      <div class="col-lg-3 col-md-3 col-xs-3">
                         <div class="atr-descr">${requestScope.APARTMENT.room_type}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">People</div>
                      </div>
                      <div class="col-lg-1 col-md-1 col-xs-1">
                         <div class="atr-descr">${requestScope.APARTMENT.accommodates}</div>
                      </div>
                   </div>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Bedrooms</div>
                      </div>
                      <div class="col-lg-1 col-md-1 col-xs-1">
                         <div class="atr-descr">${requestScope.APARTMENT.bedrooms}</div>
                      </div>
                      <div class="col-lg-1 col-md-1 col-xs-1">
                         <div class="atr-name">Beds</div>
                      </div>
                      <div class="col-lg-1 col-md-1 col-xs-1">
                         <div class="atr-descr">${requestScope.APARTMENT.beds}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Bed type</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.bed_type}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Bathrooms</div>
                      </div>
                      <div class="col-lg-1 col-md-1 col-xs-1">
                         <div class="atr-descr">${requestScope.APARTMENT.bathrooms}</div>
                      </div>
                   </div>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Street</div>
                      </div>
                      <div class="col-lg-5 col-md-5 col-xs-5">
                         <div class="atr-descr">${requestScope.APARTMENT.street}</div>
                      </div>
                      <%--
                      <div class="col-lg-3 col-md-3 col-xs-3">
                         <div class="atr-name">Neighborhood</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.neighbourhood}</div>
                      </div>
                      --%>
                   </div>
                   <div class="inforow">
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Price</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.price}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Weekly price</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.weekly_price}</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-name">Monthly price</div>
                      </div>
                      <div class="col-lg-2 col-md-2 col-xs-2">
                         <div class="atr-descr">${requestScope.APARTMENT.monthly_price}</div>
                      </div>
                   </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-xs-12">
                <%--<img class="map" src="${pageContext.request.contextPath}/rsr/images/mapPins.jpg" />--%>
                <%--<div class="host"></div>--%>
                <div class="book-box js-book-box" data-listing-id="${requestScope.APARTMENT.id}" data-user-id="${sessionScope.userID}">
                    <div class="tag-bottom">Book now!</div>
                    <jsp:include page="/inc/calendar.jsp"/>
                    <div class="js-selection date-selected-container">
                        <div class="date-selected date-of-arrival"></div>
                        <div class="date-selected date-of-departure"></div>
                    </div>
                    <div class="js-message message"></div>
                    <a href="${pageContext.request.contextPath}/book-listing">
                        <button type="button" class="attention-button js-book-button">Book now</button>
                    </a>
                    <div>
                        <button class="js-clear clear-dates-button">Clear dates</button>
                    </div>
                </div>
            </div>
           <%-- <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d12581.834113000254!2d23.7360641!3d37.96642725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sel!2sgr!4v1494495440915" width="800" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
        --%></div>
    </div>

    <jsp:include page="/inc/footer.jsp"/>

</body>
</html>
