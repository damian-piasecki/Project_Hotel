<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 07.09.17
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="/resources/font.css">
    <link rel="stylesheet" href="/resources/gallery.css">
    <link rel="stylesheet" href="/resources/navibar.css">
    <title>Title</title>
</head>
<body>
<ul>
    <li><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/contact">Contact</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/gallery">Gallery</a></li>
</ul>
<div align="center">

    <div class="w3-content w3-display-container" style="max-width:800px">
        <img class="mySlides" src="/resources/img/238_005.jpeg" style="max-height: 500px" style="max-width:800px">
        <img class="mySlides" src="/resources/img/236_bathroom-hotel-paris-grey.jpeg" style="max-height: 500px"style="max-width:800px">
        <img class="mySlides" src="/resources/img/02f05aa5_z.jpg" style="max-height: 500px"style="max-width:800px">

        <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
            <div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
            <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
            <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
            <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
            <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
        </div>
    </div>

    <script>
        var slideIndex = 1;
        showDivs(slideIndex);

        function plusDivs(n) {
            showDivs(slideIndex += n);
        }

        function currentDiv(n) {
            showDivs(slideIndex = n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("demo");
            if (n > x.length) {slideIndex = 1}
            if (n < 1) {slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" w3-white", "");
            }
            x[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " w3-white";
        }
    </script>
</body>
</html>
