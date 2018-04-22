$(document).ready(function(){
    $("#info").click(function(e){
        var username=$("#my-username").data("username");
        $.ajax({
            url:"infoRequest",
            method:"get",
            data:{
                username:username
            },
            dataType: 'json',
            success:function(data){
                /*debugger;*/
                    $(".user-info").each(function () {

                        $(this).append("<div class='inforow'>"+
                                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                                "<div class=\"atr-name\">username</div></div>" +
                                            "<div class=\"col-lg-10 col-md-10 col-xs-10\">"+
                                                "<div class=\"atr-descr\">"+data.userinfo.username+
                                            "</div></div></div>");
                        $(this).append("<div class='inforow'>"+
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class=\"atr-name\">Name</div></div>" +
                            "<div class=\"col-lg-10 col-md-10 col-xs-10\">"+
                            "<div class=\"atr-descr\">"+data.userinfo.name+
                            "</div></div></div>");
                        $(this).append("<div class='inforow'>"+
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class=\"atr-name\">Lastname</div></div>" +
                            "<div class=\"col-lg-10 col-md-10 col-xs-10\">"+
                            "<div class=\"atr-descr\">"+data.userinfo.lastname+
                            "</div></div></div>");
                        $(this).append("<div class='inforow'>"+
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class=\"atr-name\">Host Id</div></div>" +
                            "<div class=\"col-lg-10 col-md-10 col-xs-10\">"+
                            "<div class=\"atr-descr\">"+data.userinfo.host_id+
                            "</div></div></div>");

                    });
            }

        });
        e.preventDefault();

    });
});
