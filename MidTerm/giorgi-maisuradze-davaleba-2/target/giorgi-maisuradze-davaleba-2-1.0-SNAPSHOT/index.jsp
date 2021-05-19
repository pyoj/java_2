<%--
  Created by IntelliJ IDEA.
  User: Giorgi Maisuradze
  Date: 5/19/2021
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather API</title>
</head>
<body>

<textarea id="messageTextArea" rows="10" cols="50"> </textarea>
<br>
<form>
    <input id="textMessage" type="text">
    <input onclick="sendMessage();" value="Send Message" type="button">
</form>

<script> // WebSocket service port - 8081, API Service - 8080
    const webSocket = new WebSocket("ws://localhost:8081/giorgi_maisuradze_davaleba_2_war_exploded/weather");
    const messageTextArea = document.getElementById("messageTextArea");

    webSocket.onopen = function (message) {
        processOpen(message);
    };

    webSocket.onmessage = function (message) {
        processMessage(message);
    };

    webSocket.onclose = function (message) {
        processClose(message);
    };

    webSocket.onerror = function (message) {
        processError(message);
    };

    function processOpen() {
        messageTextArea.value += "The connection is established .. "+"\n";
    }
    // მესიჯის მიღება
    function processMessage(message) {
        messageTextArea.value += "Server : " + message.data +"\n";
    }
    // მესიჯის გაგზავნა
    function sendMessage() {
        let msg = textMessage.value;
        webSocket.send(msg);
        messageTextArea.value += "Client :  " + msg +"\n";
    }

    function processClose() {
        webSocket.send("Client disconnected ... ")
        messageTextArea.value += "Server Disconnect ... ";
    }

    function processError() {
        messageTextArea.value += "error ... ";
    }

</script>


</body>
</html>
