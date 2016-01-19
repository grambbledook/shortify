
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

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">URL Shortifier</a>
            </div>
            <div class="btn  dropdown navbar-text navbar-right">
                <a id="dLabel" data-target="#" data-toggle="dropdown" role="button"
                   aria-haspopup="true" aria-expanded="false">
                    Sign in
                    <span class="caret"></span>
                </a>

                <ul class="dropdown-menu" aria-labelledby="dLabel">
                    <li><a href="/user-logon" class="navbar-link">Sign in</a></li>
                    <li><a href="/user-signup" class="navbar-link">Sign up</a></li>
                </ul>
            </div>
        </div>
    </nav>


    <div class="container-fluid">
    <form:form method="post" modelAttribute="entry" action="/">
        <div class="form-group">
            <h3>Illegal url format, please provide a valid url</h3>
            <label for="originalUrl">Original URL</label>
            <form:input path="originalUrl" class="form-control" type="url" value="${entry.originalUrl}"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form:form>

    <div class="form-group">
        <label for="shortUrl">Error message</label>
        <input id="shortUrl" class="form-control" type="url" value="Ooops! ${entry.originalUrl} is not a valid url"/>
    </div>
    </div>
</div>


</body>
</html>

