/**
 * Created by alex on 18/6/2017.
 */
/*function Login() {
    var $f = $('form'),
        $login = $f.find('#username'),
        $pass = $f.find('#password');

    $f.submit(function() {

        $('#ip').remove();
        $f.attr('action', app.admin.validation_path);
        return true;
    });
}*/


$(document).ready(function(){
    $("#login").click(function(e){
       /* $("#message").text("Hello world!");*/
        var username =$("#username").val();
        var password =$("#password").val();
        $.ajax({
            url:"loginRequest",
            method:"get",
            data:{
                username:username,
                password:password
            },
            success:function(results){
                if(results != null && results!= ""){
                    showMessage(results);
                    $("#message").css("display","block");
                    if(results=="ADMIN"){
                        window.location.href="administration";
                    }
                    window.setTimeout(function(){window.location.reload()} , 2000);
                }
                else{
                    $("#message").css("display",none);
                    $("#message").html("");
                    alert("Some exception occured!Please try again.");
                }
            }
        });
        e.preventDefault();

    });
});
//function to display message to users
function showMessage(results){
    if(results=="SUCCESS" /*| results=="ADMIN"*/){
        $("#message").text("Login Successfull");
    }
    else if(results=="FAILURE"){
        $("#message").text("Wrong Password or Username");
    }
    else if(results=="ADMIN"){
        $("#message").text("admin");
    }
}