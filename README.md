# 💬 Spring Boot WebSocket Chat Application

## 📖 Overview

This is a **real-time chat application backend** built using **Spring Boot and WebSocket (STOMP protocol)**. It enables users to join a public chat room, send messages in real time, and get notified when users join or leave the chat.

The system uses **SockJS + STOMP over WebSocket** for reliable real-time communication between client and server.

---

## ✨ Features

### 💬 Real-Time Chat

* Send and receive messages instantly
* Public chat room support

### 👤 User Presence

* Notify when a user joins
* Notify when a user leaves

### 🔔 Event Handling

* WebSocket connect/disconnect tracking
* Broadcast system messages

### ⚡ Lightweight & Fast

* Uses in-memory broker (SimpleBroker)
* No external messaging system required

---

## 🧱 Project Structure

```
com.kalyan.chat
│
├── chat
│   ├── ChatMessage.java
│   ├── MessageType.java
│
├── config
│   ├── WebSocketConfig.java
│   ├── WebSocketEventListener.java
```

---

## 🚀 Technologies Used

* Java 17+
* Spring Boot 3.x
* Spring WebSocket
* STOMP Protocol
* SockJS
* Lombok
* Maven

---

## 📦 Core Components

### 💬 ChatMessage Model

Represents the message structure used in chat.

* `content` → Message text
* `sender` → Username of sender
* `type` → Message type (CHAT, JOIN, LEAVE)

---

### 📌 MessageType Enum

Defines message categories:

* `CHAT` → Normal chat message
* `JOIN` → User joined the chat
* `LEAVE` → User left the chat

---

### ⚙️ WebSocket Configuration

```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
```

### 🔑 Key Points

* `/ws` → WebSocket connection endpoint
* `/app` → Client sends messages here
* `/topic` → Server broadcasts messages here

---

### 👂 WebSocket Event Listener

Handles user disconnect events and broadcasts system messages.

* Detects when a user disconnects
* Sends LEAVE message to all users

---

## ▶️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/chat-app.git
cd chat-app
```

---

### 2️⃣ Build Project

```bash
mvn clean install
```

---

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

Server will start on:

```
http://localhost:8080
```

---

## 🌐 WebSocket Connection Details

### 🔌 Endpoint

```
/ws
```

### 📡 Message Flow

#### Client → Server

```
/app/chat.sendMessage
/app/chat.addUser
```

#### Server → Clients

```
/topic/public
```

---

## 💡 Example Message Format

```json
{
  "content": "Hello everyone",
  "sender": "Kalyan",
  "type": "CHAT"
}
```

---

## 🔄 Workflow

1. User connects to `/ws`
2. User joins chat → JOIN message broadcast
3. User sends message → CHAT message broadcast
4. User disconnects → LEAVE message broadcast

---

## 📊 Future Enhancements

* Private chat (1-to-1 messaging)
* Message persistence (MySQL/MongoDB)
* Online user list
* Authentication with JWT
* Group chat rooms
* Typing indicators

---

## 🐳 Optional Docker Setup

```dockerfile
FROM openjdk:17
WORKDIR /app
COPY target/chat-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

Build & run:

```bash
docker build -t chat-app .
docker run -p 8080:8080 chat-app
```

---

## 🤝 Contributing

* Fork repository
* Create feature branch
* Commit changes
* Submit pull request

---

## 📄 License

This project is licensed under the **MIT License**.

---

## ⭐ Author

Developed by **Kalyan Desineedi**
