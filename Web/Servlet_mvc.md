# servlet과 웹페이지에 DB 연결

### (알고가기)

- **jsp만 활용한 웹개발 문제점**
  - 화면기능과 비즈니스 로직 기능이 섞이면서 **유지보수의 문제**가 생김 :scream:

- jsp가 오브젝트로 만들어질때 **관리 및 제어** 하는 놈은 **컨테이너**이다.

- **JSP 왜 쓰나요??**
  - 자바 객체를 쓰기 위해서는 JSP를 필수적으로 사용해야 되기 때문!!

---



#### Servlet(서블릿)

- 서버상에서 동작하는 **클래스 파일**이다.
- jsp파일을 컨테이너안에서 java파일로 비꿔줌
- **요청 분석** 후 **로직 처리 역할**
- http서블릿 클래스는 무엇??
  -  웹에서 접근해서 **서비스를 요청** 할 수있는 클래스

#### MVC 패턴

- Model (모델)
  -  로직처리와 db까지를 포함하는 녀석 :package:
  - 일반적으로 **DAO,VO** 클래스로 이루져있음
  -  **백엔드 티어(EIS)**
- View(뷰)
  - jsp가 화면 기능을 담당 :computer:
    -  스마트폰,패드 등 대부분의 기기가 가능하기 때문에 종류에 따라 화면을 잘 만들어줘야함
  - **프론트앤드 티어** 
- Controller (컨트롤러)
  - 서블릿이 컨트롤러의 역할을 한다!!
  - 클라이언트의 요청을 분석
  - Model에서 처리한 결과를 보여주기 위해 JSP를 선택 :package:
  -  **미들티어**

###  특징

- 각 기능이 **분리**되어 있어 **유지보수가 편리** ~~JSP로만 만든 페이지와의 큰 차이인거같아~~
- 각 기능의 **재사용성이 높은**
- 디자이너와 개발자의 작업을 **분업 가능!!** 



---

#####  수업내용

- DB에 장된 책정보를 웹페이지에 출력 해보기
  - [java파일](https://github.com/daehyokkim/multicampus/tree/main/web_week4_student/src/main/java/mc/sn/bookconnect)
  - [jsp파일](https://github.com/daehyokkim/multicampus/blob/main/web_week4_student/src/main/webapp/connect_hr/connect.jsp)
  - [ojdbc6.jar파일](https://github.com/daehyokkim/multicampus/tree/main/web_week4_student/src/main/webapp/WEB-INF/lib)
- HR유저에 저장된 jobs db를 서블릿과 DAO로 접근해보기
  - [servlet파일](https://github.com/daehyokkim/multicampus/blob/main/web_week4_student/src/main/java/mc/sn/servlet/First_Servlet.java)
  - [DAO파일](https://github.com/daehyokkim/multicampus/blob/main/web_week4_student/src/main/java/mc/sn/bookconnect/HrDAO.java)
- web.xml파일 만들어보기
  - [web.xml](https://github.com/daehyokkim/multicampus/blob/main/web_week4_student/src/main/webapp/WEB-INF/web.xml)

##### **오늘 하루의 느낀점**

수업을 듣기전에 웹 페이지의 기초 지식을 습득하지 않고 무작정 **스프링 프레임워크**의 MVC패턴 프로젝르르 했던것이 생각이 난다..ㅠㅠㅠ :hammer:

스프링에선 자동으로 서블릿을 구현해주었는데... 처음부터 만들어보면서 햇갈리는 부분이 좀 있었다... :sob: ~~서블릿이 컨트롤러의 역할을 한다!!~~이부분에서 너무 혼란이왔다...

그래도 새로운 배움을 얻어서 긋긋긋~~



