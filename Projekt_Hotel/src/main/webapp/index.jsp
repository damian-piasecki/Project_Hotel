<html lang="en">
<head>
    <link rel="stylesheet" href="../../../CSS/index.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>
<body>
<ul>
    <li><a href="default.asp">Home</a></li>
    <li><a href="news.asp">News</a></li>
    <li><a href="contact.asp">Contact</a></li>
    <li><a href="about.asp">About</a></li>
</ul>
<div>
    <p>Dzień przyjazdu: <input type="text" id="datepicker"></p>
    <p>Dzień wyjazdu: <input type="text" id="datepicker2"> </p>
    <p>Rodzaj pokoju <form:select path="personGroup" items="${groups}" itemValue="id"
                                   itemLabel="name" />
</body>
</html>