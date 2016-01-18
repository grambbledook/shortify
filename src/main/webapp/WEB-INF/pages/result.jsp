<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>URL Shortifier</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <div class="page-header">
        <h3>Your result</h3>
    </div>

    <form:form method="post" modelAttribute="entry" action="/">
        <div class="form-group">
            <label for="originalUrl">Original URL</label>
            <form:input path="originalUrl" class="form-control" type="url" value="${entry.originalUrl}"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form:form>

    <div class="form-group">
        <label for="shortUrl">Shorten URL</label>
        <input id="shortUrl" class="form-control" type="url" value="${entry.shortUrl}"/>
    </div>
</div>


</body>
</html>

