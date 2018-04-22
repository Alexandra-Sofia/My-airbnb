<%--
  Created by IntelliJ IDEA.
  User: panos
  Date: 30/9/2017
  Time: 5:41 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book-form</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>

    <div class="container" style="height: 80%" ng-app="FormController"  ng-controller="book-listing">

        <div class="row text-center">

            <c:if test="${requestScope.layout=='error'}">
                <h1>error in password or username</h1>
            </c:if>

            <h7>Φόρμα εγγραφής</h7>

            <form class="js-booking-form" name="BookForm">
                <div class="js-booking-form">
                    Όνομα Χρήστη: <br><input  class="form-input" type="text" name="username" ng-model="Form.UserName"> <br>
                    Κώδικός εισόδου <br><input type="password" class="form-input" name="password" ng-model="Form.Password"> <br>
                    Επιβεβαίωση κωδικού <br><input type="password" class="form-input" name="password-confirm" ng-model="Form.PasswordConfirmation"> <br>
                    Όνομα: <br><input type="text" class="form-input" name="name" ng-model="Form.Name"> <br>
                    Επώνυμο: <br><input type="text" class="form-input" name="surname" ng-model="Form.SurName"> <br>
                    Διεύθυνση ηλεκτρονικού ταχυδρομίου: <br>
                    <input type="text" class="form-input" name="e-mail" ng-model="Form.Email"> <br>
                    Τηλέφωνο επικοινωνίας: <br>
                    <input type="text" class="form-input" name="phone-number" ng-model="Form.Phone"> <br>
                    <input type="checkbox" name="landlord" value="landlord" ng-model="Form.LandLord" >
                </div>
                <button type="submit">Book Now</button>
            </form>

        </div>

    </div>

    <jsp:include page="/inc/footer.jsp"/>

</body>
</html>
