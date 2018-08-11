<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>cda-ripper @ mikigal</title>
    <meta http-equiv="content-type" content="charset=utf8" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
</head>
<body>
<div id="container">
    <p id="title">cda-ripper</p>
    <p id="subtitle">Author: mikigal</p>
    <p class="url">URL: <a href="https://cda.pl/video/2184526df" target="_blank" class="url">https://cda.pl/video/2184526df</a></p>
    <p id="warning" style="font-size: 25px;">Aby pobrać wideo wybierz jakość, następnie 'Zapisz wideo jako'</p>
    <div class="quality-container">
      <p class="quality-title">360p</p>
      <button class="quality-button quality-avaible" onclick="redirect('https://google.com')">POBIERZ</button>
    </div>

    <div class="quality-container">
      <p class="quality-title">480p</p>
      <button class="quality-button quality-avaible" onclick="redirect('https://google.com')">POBIERZ</button>
    </div>

    <div class="quality-container">
      <p class="quality-title">720p</p>
      <button class="quality-button quality-avaible" onclick="redirect('https://google.com')">POBIERZ</button>
    </div>

    <div class="quality-container">
      <p class="quality-title">1080p</p>
      <button class="quality-button quality-unavaible">NIEDOSTĘPNE</button>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
    function redirect(url) {
        window.open(url, "_blank");
    }
</script>

</body>
</html>
