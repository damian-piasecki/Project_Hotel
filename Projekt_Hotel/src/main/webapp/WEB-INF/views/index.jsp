<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href='http://fonts.googleapis.com/css?family=Abril+Fatface&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/resources/font.css">
    <link rel="stylesheet" href="/resources/index.css">
    <link rel="stylesheet" href="/resources/navibar.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        /* create an array of days which need to be disabled */
        var disabledDays = [<c:forEach items="${reservationsDates}" var="dates">
        "${dates}",
        </c:forEach>]

        /* utility functions */
        function nationalDays(date) {
            var  y = date.getFullYear(),m = date.getMonth(), d = date.getDate();
            m += 1;
            if(m<10)
                m= "0"+m;
            if(d<10)
                d= "0"+d;
            var txtDate = y + '-' + m + '-' + d;
//            console.log('Checking (raw): ' + txtDate);
            for (i = 0; i < disabledDays.length; i++) {
                if($.inArray(txtDate, disabledDays) != -1 || new Date() > date) {

//                    console.log('bad:  ' + txtDate + ' / ' + disabledDays[i]);
                    return [false];
                }
            }
            console.log('good:  ' + txtDate);
            return [true];
        }

        /* create datepicker */
        jQuery(document).ready(function() {
            jQuery('.date').datepicker({
                minDate: new Date(),
                maxDate: new Date(2019,12,12),
                dateFormat: 'yy-mm-dd',
                constrainInput: true,
                beforeShowDay: nationalDays
            });
        });

    </script>
    <style>
    </style>
</head>
<body>
<ul>
    <li><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/contact">Contact</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/gallery">Gallery</a></li>
</ul>
<br>
<br>
<div id="reserve" align="center" style="color: #333333" >
    <form:form method="post" modelAttribute="reservation">
    <p><span class="transbox">Arrival day</span>: <input name="arrivalDate" type="text" class="date"/>
        <span class="transbox">Checkout day:</span> <input name="checkoutDate" type="text" class="date"/>
        <span class="transbox">Room Type:</span> <form:select path="rooms" items="${room}" itemValue="id"
                                itemLabel="roomType"/>
        <span class="transbox">Payment Type:</span> <form:select path="payment" items="${payment}" itemValue="id"
                                itemLabel="paymentType"/>

        <input type="submit" value="Reserve">
    </p>
    </form:form>
</div>
</body>
</html>