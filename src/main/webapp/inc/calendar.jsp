<%--
  Created by IntelliJ IDEA.
  User: gloman
  Date: 28/4/2017
  Time: 2:49 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,entities.myCalendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Calendar</title>
    <link rel="stylesheet" type="text/css" href="rsr/styles/myStyle.css">
    <link rel="stylesheet" type="text/css" href="rsr/bootstrap/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="scripts/calendar.js"></script>
    <%--<script>
        <%
            myCalendar C=new myCalendar();
            C.init();
            String x=C.getMonthName();
        %>
        function goback(){
            document.getElementById("main").innerHTML="I have no idea what I'm doing yeah!";
        }

        function gofront(){
            document.getElementById("main").innerHTML="Still no idea...";
        }
    </script>--%>
</head>
<body>
    <div id='dp-test' class="datepicker">

    </div>




        <%--<div class="calendar">
            <div class="row" >
                <div class="col-lg-3 col-md-3 col-xs-3">
                    &lt;%&ndash;<img class="little-button-left" src="${pageContext.request.contextPath}/rsr/images/arrow.png"/>&ndash;%&gt;
                        <input id="clickMe" type="button" value="prev" onclick="goback();" />
                </div>
                <div class="col-lg-6 col-md-6 col-xs-6">
                        <% out.print("<h7 id=\"month\">"+x+"</h7>"); %>
                </div>
                <div class="col-lg-3 col-md-3 col-xs-3">
                   &lt;%&ndash; <img class="little-button-right" src="${pageContext.request.contextPath}/rsr/images/arrow.png"/>&ndash;%&gt;
                       <input id="clickMe" type="button" value="next" onclick="gofront();" />
                </div>
            </div>
            <div id="main" class="row text-center" style="padding: 5%">
                <%
                    boolean thisMonth=false;
                    boolean prevMonth=true;
                    int md=C.getMonthDays();
                    int first = C.firstDayOfMonth();
                    int pd=C.getPrevMonthDays();
                    int counter=pd-first+1;
                    if(first==1){
                        thisMonth=true;
                        prevMonth=false;
                        counter=1;
                    }
                    out.print("<div class=\"day\">M</div>");
                    out.print("<div class=\"day\">T</div>");
                    out.print("<div class=\"day\">W</div>");
                    out.print("<div class=\"day\">T</div>");
                    out.print("<div class=\"day\">F</div>");
                    out.print("<div class=\"day\">S</div>");
                    out.print("<div class=\"day\">S</div>");
                    for(int i=0;i<6;i++){
                        for(int j=0;j<7;j++){
                            if(thisMonth) {
                                out.print("<div class=\"day-cube\">"+counter+"</div>");
                                counter++;
                                if(counter>md) {thisMonth=false;counter=1;}
                            }
                            else if(prevMonth) {
                                if ( j < first) {
                                    out.print("<div class=\"day-cube-gray\">"+"#"+counter + "</div>");
                                    counter++;
                                }
                                if (j == first) {
                                    thisMonth = true;
                                    prevMonth = false;
                                    counter = 1;
                                    out.print("<div class=\"day-cube\">"+counter + "</div>");
                                    counter++;
                                }
                            }
                            else{
                                out.print("<div class=\"day-cube-gray\">"+"&"+counter+"</div>");
                                counter++;
                            }
                        }
                    }
                %>
            </div>

        </div>--%>
</body>
</html>
