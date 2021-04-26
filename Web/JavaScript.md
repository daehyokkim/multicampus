# JavaScript

> 웹 스크립트에서 동작하는 언어 > 브라우저 까지 확장

~~초기 자바스크립트는 이미지를 동적으로 처리하기 위해 개발했다한다는...~~ :open_mouth:

**웹 페이지 실행은 패이지의 순서대로 읽기 때문에 순서가 중요하다.**

이를 해결하기 위해 event(사건)를 생성하여 event(사건)를 호출할 시 JavaScript를 출력시키도록 개발한다.

### 자료형과 변수

정수

실수

문자열 

- '' 와 "" 을 구분하지 문자,문자열로 생각하지 않고 둘다 문자열로 인식

이스케이프 문자

- `\w` : 수평 Tab
- `\n` : 줄 바꿈
- `\\` : 역 슬레시
- `\' `: 작은 따옴포
- `\" `큰 따옴표



#### 객체

- 딕셔너리 형태로 데이터를 구성한다.
- 자료형 여러 개를 한 번에 저장
- 요소에 접근 할 때 인덱스를 사용하지만 객체는 key를 사용한다.
- JS에서 클레스를 만드는 문법:package:
- 생성

```javascript
<script>
    var product = {
      제품명 : '망고',
      유형 : '절임',
      성분 : '건망고,설탕'
    };
</script>
```

  - 객체 접근 방법

```javascript
product.제품명  //망고
product.유형	 //절임
//반복문으로 확인방법
for(var i in product){
    alert(i+':'+product[i]);
}
```

#### 문서 객체 모델

- 태그를 자바스크립트에서 사용할  수 있는 객체를 만든 것
- 문서 각체를 조작한다는 말은 결국 태그를 조작한다는 의미

- 정적 생성

  - 웹 페이지를 처음 실행할 때 HTML 태그로 적힌 문서 객체를 생성한 것

- 동적 생성

  - 웹 페이지 실행 중 자바스크립트를 사용해 문서 객체를 생성 하는 것
  - 문서 객체 모델 **DOM**

- Event 활용하기

  - 실행 순서에 따른 문서 객체 사용 오류 방지

    ```javascript
    //window.onlod를 통해 전체 HTML의 내용을 읽고 이후에 문서 객체 읽기
    <head>
    	<script>
       		 window.onlod = function(){
        		// h1 태그의 배경 색상을 변경합니다.
        		document.querySelecter('h1').style.backgroundColor ='red';
    		 };
    	</script>
    </head>
    <body>
            <h1>title</h1>
    </body>
    ```

    

- 마지막 배운 내용을 통해 현재 시간을 보여주는 코드 작성

  [현재 시간을 보여주는 웹](https://github.com/daehyokkim/multicampus/blob/main/web_week4_student/src/main/webapp/javascriptpage/Clock_Event.html)