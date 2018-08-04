<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>cda-ripper @ mikigal</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
</head>
<body>
<div id="container">
    <p id="title">cda-ripper</p>
    <p id="subtitle">Author: mikigal</p>

    <form>
        <input id="url-input" name="url" type="text" placeholder="Link do video"/> <br>
        <input id="download-input" type="submit" value="POBIERZ"/>
    </form>

</div>

</body>
</html>
