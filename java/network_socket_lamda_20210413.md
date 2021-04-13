# JAVA

---

### 네트워크 기초

> 네트워크에서 스트림이 어떻게 만들어지느냐에 대한 기준으로 알아보자~!

- **물리적으로** 떨어져있는 컴퓨터를 데이터를 주고받기 위해 연결한는 것

#### 1. 클라이언트와 서버 연결

- 클라이언트 - > 요청하는 역할
  - 서버가 위치한 장소를 알아 접속을 하여 요청함
- 서버 -> 서비스를 제공하는 역할
- 스트림을 구현하는 법
  1. 클라이언트 - > 포트를 통해 서버와 연결하면 스트림을 받는다.
  2. 서버 -> 접속한 클라이언트 정보로 부터 스트림을 받는다.

#### 2. Socket

- `java.net.Socket`이용
  - **[ServerSocket](#(int))**(int port) :Creates a server socket, bound to the specified port.
    - **[accept](#accept())**() :Listens for a connection to be made to this socket and accepts it. return socket 정보
  - **[Socket](#(java.lang.String,int))**([String](../lang/String.html) host, int port) : Creates a stream socket and connects it to the specified port number on the named host.
    - **[getInputStream](#getInputStream())**() : Returns an input stream for this socket.
    - **[getOutputStream](#getOutputStream())**() : Returns an output stream for this socket.

- 클라이언트와 서버 간의 연결을 도와주는 기능

  

---

### 람다식

> 표기를 간편하게 하기위해 사용

- 일반 Runnable 인터페이스의 익명 구현 객체 생성

```java
Runnable runnable =new Runnable(){
  public void run(){}  
};
```

- 람다식을 사용하여 Runnable 구현

```java
Runnable runnable = () -> {};
```



