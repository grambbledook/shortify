<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>URL Shortifier</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-4"/>
    <div class="col-md-4">Welcome!</div>
    <div class="col-md-4"/>

</div>

<form:form method="post" modelAttribute="message" action="/">
    <div class="row">
        <form:input path="originalUrl" type="text"/>
    </div>
    <div class="row">
        <input type="submit" value="Submit"/>
    </div>
</form:form>

</body>
</html>

