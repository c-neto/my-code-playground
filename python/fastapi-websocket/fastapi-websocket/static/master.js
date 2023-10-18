var ws_image = new WebSocket("ws://localhost:8000/ws-image");
var ws_logs = new WebSocket("ws://localhost:8000/ws-logs");


ws_image.onmessage = function(event) {
    console.log(event)
    let data = JSON.parse(event.data);
    let row = document.querySelector('.row');
    row.querySelector('#img').setAttribute('src',
        "data:image/png;base64, " + data.image
    );
    row.querySelector('#date').textContent = data.date;
    row.querySelector('#hour').textContent = data.hour;
};


ws_logs.onmessage = function(event) {
    console.log(event.data)
    let data = JSON.parse(event.data);
    document.getElementById('logs').innerHTML = data.message;
};
