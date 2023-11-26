const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/our-websocket'
});
var notificationCount = 0;
$(document).ready(function(){
	console.log("Index page is ready");
	connect();
	
	$("#send").click(function(){
		sendMessage();
	});
	
	$("#notifications").click(function(){
		resetNotificationCount();
	});
	
});


function connect() {
    stompClient.activate();
    stompClient.onConnect = function (frame) {
        console.log('Connected: ' + frame);
        updateNotificationDisplay();
        stompClient.subscribe('/topic/messages', function (message) {
            showMessage(JSON.parse(message.body).content);
        });
        
        stompClient.subscribe('/topic/global-notification', function (message) {
            notificationCount = notificationCount +1;
            updateNotificationDisplay();
        });
    };
    stompClient.activate();
}


function showMessage(message){
	$("#messages").append("<tr><td>"+ message +"</td></tr>");
}

function sendMessage() {
    console.log("sending message");
    stompClient.publish({ destination: "/ws/message", body: JSON.stringify({ 'messageContent': $("#message").val() }) });
}

function updateNotificationDisplay(){
	if(notificationCount == 0){
		$('#notifications').hide();
	}else{
		$('#notifications').show();
		$('#notifications').text(notificationCount);
	}
}

function resetNotificationCount(){
	notificationCount = 0;
	updateNotificationDisplay();
}
