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

    <input id="url-input" type="text" placeholder="Link do video"/> <br>
    <button id="download-input" onclick="loading()"/>POBIERZ</button>

    <p id="info">Trwa pobieranie informacji o filmie...</p>

    <p id="warning">Przechwytywanie linków do wszystkich dostępnych jakości wideo trwa około 15 sekund!</p>
</div>

<script>
    function loading() {
        document.getElementById('info').style.display = 'block';
        window.location.replace("http://google.com");
    }
</script>

</body>
</html>
