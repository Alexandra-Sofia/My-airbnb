/**
 * Created by alex on 10/5/2017.
 */
window.name="calendar";

var month = ["January","February","March","April","May","June","July","August","September","October","November","December"];

$(document).ready(function(){
    $(".datepicker").each(function () {

        $(this).append("<div class='date-selected-container'>\n" +
            "            <div class='date-selected date-current'></div>\n" +
            "            </div>");
        $(this).append("<div class='date-text' style='display:none'>date</div>");
        $(this).append("<div class='month-year-picker row'>month</div>");
        $(this).append("<div class='calendar row'>calendar</div>");
        //build calendar
        buildCalendarMonth($(this).attr("id"),new Date());/*
        $(this).append("<div class='calendar'>calendar2</div>");*/
    })
});

function buildCalendarMonth(id,date){
    //clear it out
    $("#" +id).find(".date-text").html("");
    $("#" +id).find(".date-selected.date-current").html("");
    $("#" +id).find(".month-year-picker").html("");
    $("#" +id).find(".calendar").html("");
    //repopulate upper section
    //TODO:fix stupid day on top
    $("#" +id).find(".date-text").append(getConfigDate(date));
    $("#" +id).find(".date-selected.date-current").html(getDisplayDate(date));
    $("#" +id).find(".month-year-picker").append("<select class='month-dropdown col-lg-6 col-md-6 col-xs-6'></select>" +
                                                "<select class='year-dropdown col-lg-6 col-md-6 col-xs-6'></select>");
    //get first and last days
    var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
    var lastDay = new Date(date.getFullYear(), date.getMonth()+1, 0);
    var days = lastDay.getDate();
    var td=new Date();

    //populate month dropdown
    for(var i=0;i<12;i++) {
        if (date.getMonth() == i) {
            $("#" + id).find(".month-dropdown").append("<option selected value='" + i + "'>" + month[i] + "</option>");
        }
        else if ( td.getFullYear()==date.getFullYear() && i<td.getMonth()) {
            $("#" + id).find(".month-dropdown").append("<option disabled value='" + i + "'>" + month[i] + "</option>");
        }
        else{
            $("#" + id).find(".month-dropdown").append("<option value='" + i + "'>" + month[i] + "</option>");
        }
    }

    //populate year dropdown
    for(var i=td.getFullYear();i<td.getFullYear()+5; i++){
        if (date.getFullYear() == i) {
            $("#" + id).find(".year-dropdown").append("<option selected value='" + i + "'>" + i + "</option>");
        }
        else{
            $("#" + id).find(".year-dropdown").append("<option value='" + i + "'>" + i + "</option>");
        }
    }

    //add navigation buttons
    $("#" + id).find(".calendar").append("<div class='today-date-button row'>" +
                                                "<span class='prev-month col-lg-4 col-md-4 col-xs-4'><<</span>" +
                                                "<span class='today-month col-lg-4 col-md-4 col-xs-4'>Today</span>" +
                                                "<span class='next-month col-lg-4 col-md-4 col-xs-4'> >> </span></div>");


    //add day names
    $("#" + id).find(".calendar").append(/*"<div class='row'>" +*/
        "<div id='day' class='day'>"+"M"+"</div>"+
        "<div id='day' class='day'>"+"T"+"</div>"+
        "<div id='day' class='day'>"+"W"+"</div>"+
        "<div id='day' class='day'>"+"T"+"</div>"+
        "<div id='day' class='day'>"+"F"+"</div>"+
        "<div id='day' class='day'>"+"S"+"</div>"+
        "<div id='day' class='day'>"+"S"+"</div>"/* +
         "</div>"*/);

    //add duds
    var first=firstDay.getDay();
    if(first==0) first=7;
    for(var i=0;i<(7-(7-first)-1);i++){
        $("#" + id).find(".calendar").append("<div class='day-cube-gray'>@</div>");
    }

    //add calendar days
    var _year = date.getFullYear();
    var _month = date.getMonth() + 1;
    if(month < 10) month = "0"+month;
    for (var i = 0; i < days; i++) {

        if ( date.getMonth()==td.getMonth() && date.getFullYear()==td.getFullYear() && td.getDate() == (i + 1)) {
            $("#" + id).find(".calendar").append("<div id='date-block-" + (i + 1) + "-" + id + "' class='day-cube day-cube-current js-book-date' data-year='"+_year+"' data-month='"+_month+"' data-day='"+(i+1<10? "0":"")+(i+1)+"'>" + (i + 1) + "</div>");
        }
        else if( date.getMonth()<td.getMonth() && date.getFullYear()<td.getFullYear()){
            $("#" + id).find(".calendar").append("<div id='date-block-" + (i + 1) + "-" + id + "' class='day-cube-gray'>" + (i + 1) + "</div>");
        }
        else {
            if(td.getDay>i){ $("#" + id).find(".calendar").append("<div id='date-block-" + (i + 1) + "-" + id + "' class='day-cube-gray'>" + (i + 1) + "</div>");}
            else{ $("#" + id).find(".calendar").append("<div id='date-block-" + (i + 1) + "-" + id + "' class='day-cube  js-book-date' data-year='"+_year+"' data-month='"+_month+"' data-day='"+(i+1<10? "0":"")+(i+1)+"'>" + (i + 1) + "</div>");}
        }
    }

    //add dudds
    for(var i=0;i<(7-lastDay.getDay());i++){
        $("#" + id).find(".calendar").append("<div class='day-cube-gray'>#</div>");
    }

    //all calendar days

    //add click-events
    //.prev-month
    $(".prev-month").click(function(){
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year").html(), $("#" + id).find(".month").html()-2,1);
        buildCalendarMonth(pid, date);
    });
    //.next-month
    $(".next-month").click(function(){
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year").html(), $("#" + id).find(".month").html(),1);
        buildCalendarMonth(pid, date);
    });
    //.today-month
    $(".today-month").click(function(){
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year").html(), $("#" + id).find(".month").html()-1,1);
        buildCalendarMonth(pid, td);
    });
    //.cal-date-month
    /*$(".day-cube").click(function(){
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year").html(), $("#" + id).find(".month").html(),1);
        buildCalendarMonth(pid, date);
    });*/
    //.month dropdown
    $(".month-dropdown").change(function () {
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year").html(), $("#" + id).find(".month-dropdown option:selected").val(), 1);

        buildCalendarMonth(pid, date);
    });
    //.year-dropdown
    $(".year-dropdown").change(function () {
        var pid = $(this).closest(".datepicker").attr("id");
        var date = new Date($("#" + id).find(".year-dropdown option:selected").val(), $("#" + id).find(".month").html() - 1, 1);

        buildCalendarMonth(pid, date);
    });

    if(typeof refreshSelected == 'function'){
        refreshSelected($('.js-book-box'));
    }
}

function updateDay(id,date) {//change which day is highlighted
    //update classes
    /*$("#" + id).find(".day").html(day);
    $("#" + id).find(".day-*/
}

function getDisplayDate(date) {
    return "Today is " + date.getFullYear()+ "-"+(date.getMonth()+1<10? "0":"") + (date.getMonth() + 1) + "-"+(date.getDate()<10? "0":"") +date.getDate();

}
function getConfigDate(date){
    return "<span class='month'>" + (date.getMonth() + 1) + "</span>/<span class='dayS'>" + date.getDate() + "</span>/<span class='year'>" + date.getFullYear() + "</span>";
}

function getDate(id) {
    return $("#" + id).find(".year").html() + "/" + $("#" + id).find(".month").html() + "/" + $("#" + id).find(".day").html();
}
