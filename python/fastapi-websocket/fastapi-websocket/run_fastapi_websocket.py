from fastapi import (
    FastAPI,
    WebSocket,
    WebSocketDisconnect
)
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles
from datetime import datetime
from fastapi import Request
from typing import List
import uvicorn
import asyncio
import json
from pathlib import Path
import base64


def get_base64(image_path):
    base64_content = base64.b64encode(
        bytes(Path(image_path).read_bytes())
    ).decode(encoding='utf-8')
    return base64_content


class Messaging:
    IMAGES = [
        {
            "image": get_base64('static/assets/{}.png'.format(number_image)),
            "date": datetime.now().strftime('%d/%m/%Y'),
            "hour": datetime.now().strftime('%H:%M:%S'),
        } for number_image in range(1, 6)
    ]

    LOGS = [
        {
            "message": "log message {}".format(number_log)
        } for number_log in range(1, 10)
    ]

    def get_image(self) -> str:
        while True:
            for image in self.IMAGES:
                image.update({"date": datetime.now().strftime('%d/%m/%Y')})
                image.update({"hour": datetime.now().strftime('%H:%M:%S')})
                yield json.dumps(image)

    def get_log(self) -> str:
        while True:
            for image in self.LOGS:
                yield json.dumps(image)


class ConnectionManager:
    def __init__(self):
        self.active_connections: List[WebSocket] = []

    async def connect(self, websocket: WebSocket):
        await websocket.accept()
        print('client ws conectado')
        self.active_connections.append(websocket)

    def disconnect(self, websocket: WebSocket):
        print('client ws desconectado')
        self.active_connections.remove(websocket)

    async def send_personal_message(self, message: str, websocket: WebSocket, time_wait=1):
        print('mesagem enviada')
        await asyncio.sleep(time_wait)
        await websocket.send_text(message)

    async def broadcast(self, message: str):
        for connection in self.active_connections:
            await connection.send_text(message)


def configure_app(app: FastAPI):
    connection_manager = ConnectionManager()
    message = Messaging()
    generate_log = message.get_log()
    generate_image = message.get_image()
    app.mount(
        "/static",
        StaticFiles(directory="static"),
        name="static"
    )
    templates = Jinja2Templates(directory="static")

    @app.get("/")
    async def index(request: Request):
        return templates.TemplateResponse("index.html", {"request": request})

    @app.websocket("/ws-image")
    async def websocket_images(websocket: WebSocket):
        await connection_manager.connect(websocket)
        try:
            while True:
                await connection_manager.send_personal_message(
                    next(generate_image),
                    websocket,
                    2
                )
        except:
            connection_manager.disconnect(websocket)

    @app.websocket("/ws-logs")
    async def websocket_logs(websocket: WebSocket):
        await connection_manager.connect(websocket)
        try:
            while True:
                await connection_manager.send_personal_message(
                    next(generate_log),
                    websocket,
                    1
                )
        except WebSocketDisconnect:
            connection_manager.disconnect(websocket)


if __name__ == "__main__":
    app = FastAPI()
    configure_app(app)
    uvicorn.run(
        app,
        host="0.0.0.0",
        port=8000
    )
