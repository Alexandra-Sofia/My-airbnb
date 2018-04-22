<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 27/4/2017
  Time: 3:55 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <title>Sign in</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="scripts/angular.js"></script>
    <script src="scripts/sign-up.js"></script>
	<style>
.milky{color:white;}
.milk{color:red;}
.bread{color:green;}
.cheese{color:yellow;}
</style>
<script>

</script>
</head>

<body>
    <jsp:include page="/inc/header.jsp"/>
    <div class="container" style="height: 80%" ng-app="FormController"  ng-controller="sign-in">
        <div class="row text-center">
        
			<!--<div ng-app="myShoppingList" ng-controller="myCtrl">
			  <ul>
				<li ng-class="x.ShowClass? '{{x.Class}}' : ''" ng-repeat="x in products" ng-click="ChangeStyle(x);">{{x.Name}}</li>
			  </ul>
			</div>-->

            <c:if test="${requestScope.layout=='error'}">
                <h1>error in password or username</h1>
            </c:if>

            <h7>Φόρμα εγγραφής</h7>
            <form name="myForm" action="${pageContext.request.contextPath}/newuser" onsubmit="return validateForm()" method="post">
                <div class="myForm">
                    Username: <br><input  class="form-input" type="text" name="username" ng-model="Form.UserName"> <br>
                    Password: <br><input type="password" class="form-input" name="password" ng-model="Form.Password"> <br>
                    Confirm Password <br><input type="password" class="form-input" name="password-confirm" ng-model="Form.PasswordConfirmation"> <br>
                    Firstname: <br><input type="text" class="form-input" name="name" ng-model="Form.Name"> <br>
                    Lastname: <br><input type="text" class="form-input" name="surname" ng-model="Form.SurName"> <br>
                    email: <br>
                    <input type="text" class="form-input" name="e-mail" ng-model="Form.Email"> <br>
                    Telephone: <br>
                    <input type="text" class="form-input" name="phone-number" ng-model="Form.Phone"> <br>
                    <input type="checkbox" name="landlord" value="landlord" ng-model="Form.LandLord" >
                    I want to be a host <br>(To add apartment you have to wait for administration confirmation)
                    <%--<input type="checkbox" name="visitor" value="visitor" checked="checked" ng-model="Form.Visitor">
                    Θέλω να ενοικιάσω χώρο για διαμονή <br>--%>
                   <%-- <a ng-click="LogFields();">Check</a> --%>
                </div>
                <button type="submit">Sign me up</button>
            </form>
    </div>
    <jsp:include page="/inc/footer.jsp"/>
</body>
</html>
