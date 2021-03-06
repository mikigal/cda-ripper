<%@ page import="pl.mikigal.cda.controller.RootController" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>cda-ripper @ mikigal</title>
    <meta http-equiv="content-type" content="charset=utf8" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400">
    <link rel="stylesheet" href="<c:url value="../../static/css/main.css" />">
</head>
<body>
<div id="container">
    <a id="title" href="/" style="color: #e3e3e3;">cda-ripper</a>
    <p id="subtitle">Author: mikigal</p>

    <input name="raw-url" id="url-input" type="text" placeholder="Link do video"/> <br>
    <button id="download-input" onclick="loading()">POBIERZ</button>

    <c:choose>
        <c:when test="${param.error == '1'}">
            <p id="error">Podany URL jest niepoprawny!</p>
        </c:when>
        <c:when test="${param.error == '2'}">
            <p id="error">Musisz poczekać przed pobraniem następnego filmu!</p>
        </c:when>
        <c:when test="${param.error == '-1'}">
            <p id="error">Wystąpił nieokreślony błąd!</p>
        </c:when>
    </c:choose>

    <p id="warning">Przechwytywanie linków do wszystkich dostępnych jakości wideo trwa około 15 sekund!</p>
</div>

<script>
    function replaceAll(str, find, replace) {
        return str.replace(new RegExp(find, 'g'), replace);
    }

    function loading() {
        window.location.replace('/' + btoa(replaceAll(encodeURIComponent(document.getElementById('url-input').value), '%2F', '$2F')));
    }
</script>

</body>
</html>
