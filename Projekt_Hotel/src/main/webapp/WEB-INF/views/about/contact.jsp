<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 07.09.17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/contact.css">
    <link rel="stylesheet" href="/resources/font.css">
    <link rel="stylesheet" href="/resources/navibar.css">
    <title>Title</title>
</head>
<body>
<ul>
    <li><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/contact">Contact</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/gallery">Gallery</a></li>
</ul>
<div class="container">
        <label for="fname">First Name</label>
        <input type="text" id="fname" name="firstname" placeholder="Your name..">

        <label for="lname">Last Name</label>
        <input type="text" id="lname" name="lastname" placeholder="Your last name..">

        <label for="country">Country</label>
        <select id="country" name="country">
            <option value="australia">Australia</option>
            <option value="canada">Canada</option>
            <option value="usa">USA</option>
        </select>

        <label for="subject">Subject</label>
        <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>

        <input type="submit" value="Submit">

    </form>
</div>
</body>
</html>
