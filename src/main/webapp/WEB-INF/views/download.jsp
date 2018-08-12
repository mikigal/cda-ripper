<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>cda-ripper @ mikigal</title>
    <meta http-equiv="content-type" content="charset=utf8"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400">
    <link rel="stylesheet" href="<c:url value="../../static/css/main.css" />">
</head>
<body>
<div id="container">
    <a id="title" href="/" style="color: #e3e3e3;">cda-ripper</a>
    <p id="subtitle">Author: mikigal</p>
    <p class="url">URL: <a href="https://cda.pl/video/${id}" target="_blank" class="url">https://cda.pl/video/${id}</a>
    </p>
    <p id="warning" style="font-size: 25px;">Aby pobrać wideo wybierz jakość, następnie 'Zapisz wideo jako'</p>

    <div class="qualityType-container">
        <p class="qualityType-title">360p</p>
        <c:choose>
            <c:when test="${p360 != null && !fn:startsWith(p360, 'https://.cda.pl/')}">
                <button class="qualityType-button qualityType-available" onclick="redirect('${p360}')">POBIERZ</button>
            </c:when>
            <c:otherwise>
                <button class="qualityType-button qualityType-unavailable">NIEDOSTĘPNE</button>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="qualityType-container">
        <p class="qualityType-title">480p</p>
        <c:choose>
            <c:when test="${p480 != null && !fn:startsWith(p480, 'https://.cda.pl/')}">
                <button class="qualityType-button qualityType-available" onclick="redirect('${p480}')">POBIERZ</button>
            </c:when>
            <c:otherwise>
                <button class="qualityType-button qualityType-unavailable">NIEDOSTĘPNE</button>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="qualityType-container">
        <p class="qualityType-title">720p</p>
        <c:choose>
            <c:when test="${p720 != null && !fn:startsWith(p720, 'https://.cda.pl/')}">
                <button class="qualityType-button qualityType-available" onclick="redirect('${p720}')">POBIERZ</button>
            </c:when>
            <c:otherwise>
                <button class="qualityType-button qualityType-unavailable">NIEDOSTĘPNE</button>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="qualityType-container">
        <p class="qualityType-title">1080p</p>
        <c:choose>
            <c:when test="${p1080 != null && !fn:startsWith(p1080, 'https://.cda.pl/')}">
                <button class="qualityType-button qualityType-available" onclick="redirect('${p1080}')">POBIERZ</button>
            </c:when>
            <c:otherwise>
                <button class="qualityType-button qualityType-unavailable">NIEDOSTĘPNE</button>
            </c:otherwise>
        </c:choose>
    </div>

</div>

<script>
    function redirect(url) {
        window.open(url, "_blank");
    }
</script>

</body>
</html>
