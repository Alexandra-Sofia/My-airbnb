/**
 * Created by Alexandra on 24/4/2017.
 */
window.name="apartment";

$(document).ready(function() {
    //var ourRequest = new XMLHttpRequest();
    //ourRequest.open('GET', '/WebApp/rsr/apart.json?123');
    //ourRequest.onload = function () {
    //    var ourData = JSON.parse(ourRequest.responseText);
    //    console.log(ourData[0]);
    //    renderHTML(ourData);
    //};
    //ourRequest.send();
});

function renderHTML(data){
    $(".apartment-main").each(function () {
        $(this).append("<img class='big-image' src="+data[0].xl_picture_url+" />");
    });
    $(".image-tag").each(function () {
        $(this).append("<div class='col-lg-8 col-md-8 col-xs-8'><br></div>");
        $(this).append("<div class='col-lg-4 col-md-4 col-xs-4'><div class='host'><div class='col-lg-4 col-md-4 col-xs-4'>" +
            "<div class='atr-name'>Host</div>" +
            "</div>" +
            "<div class='col-lg-4 col-md-4 col-xs-4'>" +
            "<div class='atr-descr cute-font'>" + data[0].host_name + "</div>" +
            "</div>" +
            "<div class='col-lg-4 col-md-4 col-xs-4'>" +
            "<div class='host-pic'><img class='big-image' src=" + data[0].host_picture_url+" /></div>" +
            "</div></div></div>");
    });
    $(".apart-page-info").each(function () {
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Name</div>" +
                            "</div>" +
                            "<div class='col-lg-10 col-md-10 col-xs-10'>"+
                                "<div class='atr-descr'>"+data[0].name+"</div>" +
                            "</div>" +
                        "</div>");
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Summary</div>" +
                            "</div>" +
                            "<div class='col-lg-10 col-md-10 col-xs-10'>"+
                                "<div class='atr-descr'>"+data[0].summary+"</div>" +
                            "</div>" +
                        "</div>");
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Space</div>" +
                            "</div>" +
                            "<div class='col-lg-10 col-md-10 col-xs-10'>"+
                                "<div class='atr-descr'>"+data[0].space+"</div>" +
                            "</div>" +
                        "</div>");
        if(data[0].description!="none") {
            $(this).append("<div class='inforow'>" +
                                "<div class='col-lg-2 col-md-2 col-xs-2'>" +
                                    "<div class='atr-name'>Descrption</div>" +
                                "</div>" +
                                "<div class='col-lg-10 col-md-10 col-xs-10'>" +
                                    "<div class='atr-descr'>" + data[0].description + "</div>" +
                                "</div>" +
                            "</div>");
        }
        if(data[0].experiences_offered!="") {
            $(this).append("<div class='inforow'>" +
                                "<div class='col-lg-2 col-md-2 col-xs-2'>" +
                                    "<div class='atr-name'>Experiences</div>" +
                                "</div>" +
                                "<div class='col-lg-10 col-md-10 col-xs-10'>" +
                                    "<div class='atr-descr'>" + data[0].experiences_offered + "</div>" +
                                "</div>" +
                            "</div>");
        }
        if(data[0].neighborhood_overview!="") {
            $(this).append("<div class='inforow'>" +
                                "<div class='col-lg-2 col-md-2 col-xs-2'>" +
                                    "<div class='atr-name'>Neighborhood</div>" +
                                "</div>" +
                                "<div class='col-lg-10 col-md-10 col-xs-10'>" +
                                    "<div class='atr-descr'>" + data[0].neighborhood_overview + "</div>" +
                                "</div>" +
                            "</div>");
        }

        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Property</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-descr'>"+data[0].property_type+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Room type</div>" +
                            "</div>" +
                            "<div class='col-lg-3 col-md-3 col-xs-3'>"+
                                "<div class='atr-descr'>"+data[0].room_type+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>People</div>" +
                            "</div>" +
                            "<div class='col-lg-1 col-md-1 col-xs-1'>"+
                                "<div class='atr-descr'>"+data[0].accommodates+"</div>" +
                            "</div>" +
                        "</div>");
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Bedrooms</div>" +
                            "</div>" +
                            "<div class='col-lg-1 col-md-1 col-xs-1'>"+
                            "<div class='atr-descr'>"+data[0].bedrooms+"</div>" +
                            "</div>" +
                            "<div class='col-lg-1 col-md-1 col-xs-1'>"+
                            "<div class='atr-name'>Beds</div>" +
                            "</div>" +
                            "<div class='col-lg-1 col-md-1 col-xs-1'>"+
                            "<div class='atr-descr'>"+data[0].beds+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-name'>Bed type</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-descr'>"+data[0].bed_type+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-name'>Bathrooms</div>" +
                            "</div>" +
                            "<div class='col-lg-1 col-md-1 col-xs-1'>"+
                            "<div class='atr-descr'>"+data[0].bathrooms+"</div>" +
                            "</div>" +
                        "</div>");
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-name'>Street</div>" +
                            "</div>" +
                            "<div class='col-lg-5 col-md-5 col-xs-5'>"+
                                "<div class='atr-descr'>"+data[0].street+"</div>" +
                            "</div>" +
                            "<div class='col-lg-3 col-md-3 col-xs-3'>"+
                                "<div class='atr-name'>Neighborhood</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                                "<div class='atr-descr'>"+data[0].neighbourhood+"</div>" +
                            "</div>" +
                        "</div>");
        $(this).append("<div class='inforow'>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-name'>Price</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-descr'>"+data[0].price+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-name'>Weekly price</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-descr'>"+data[0].weekly_price+"</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-name'>Monthly price</div>" +
                            "</div>" +
                            "<div class='col-lg-2 col-md-2 col-xs-2'>"+
                            "<div class='atr-descr'>"+data[0].monthly_price+"</div>" +
                            "</div>" +
                        "</div>");

    });
    $(".host").each(function () {

    });

    /*var apartContainer=document.getElementById("name");
    apartContainer.insertAdjacentHTML('beforeend',data[0].name);*/
}

