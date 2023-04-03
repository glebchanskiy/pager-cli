import requests
from message import Message

API_URL = "localhost:8080"



def get_all() -> list[Message] | None:
    response = requests.get(f"http://{API_URL}/shared")
    if response.status_code == 200:
        messages = response.json()
        return [Message.parse_obj(m) for m in messages]
    else:
        return None
    
def send(message: Message):
    # print(message)
    requests.post(url=f"http://{API_URL}/shared", data=message.json(), headers={"Content-Type":"application/json"})


def start() -> None:
    while True:
        command: str = input(">>> ")
        if command == "show":
            messages_list = get_all()
            for message in messages_list:
                print(f"{message.userId} : {message.text}")
        if command == "send":
            text = input("[enter message]> ")
            send(Message(text=text, userId=1))