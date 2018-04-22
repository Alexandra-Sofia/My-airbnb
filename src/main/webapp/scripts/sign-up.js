/**
 * Created by alex on 15/5/2017.
 */
 
var app = angular.module("FormController", []); 
app.controller("sign-in", function($scope) {
	$scope.Form = $scope.Form || {};
	$scope.Form.Visitor = true;
	$scope.Form.LandLord = false;
	$scope.Form.Name = '';
	$scope.ValidateForm =  validateForm;
	
	$scope.LogFields = function(){
		console.log($scope.Form);
		if($scope.ValidateForm())
			document.forms["myForm"].submit();
	};
	
});
function validateForm() {
	var x = document.forms["myForm"]["username"].value;
	if (x == "") {
		alert("Userame must be filled out");
		return false;
	}
	x = document.forms["myForm"]["password"].value;
	if (x == "") {
		alert("Password must be filled out");
		return false;
	}
	var x1 = document.forms["myForm"]["password-confirm"].value;
	if (x1 != x) {
		alert("Wrong password");
		return false;
	}
	x = document.forms["myForm"]["name"].value;
	if (x == "") {
		alert("Name must be filled out");
		return false;
	}
	x = document.forms["myForm"]["surname"].value;
	if (x == "") {
		alert("Surname must be filled out");
		return false;
	}
	x = document.forms["myForm"]["e-mail"].value;
	if (x == "") {
		alert("E-mail must be filled out");
		return false;
	}
	x = document.forms["myForm"]["phone-number"].value;
	if (x == "") {
		alert("Phone-number must be filled out");
		return false;
	}
}
