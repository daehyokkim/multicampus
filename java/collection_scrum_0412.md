# JAVA 

### 1. 컬렉션

>  데이터를 집합으로 다루는 것을 의미한다.

---

### 알고 가기!!

***배열의 문제점***

1. 배열의 길이가 고정되어 있다.
2. 배열 특정 인덱스 값이 삭제가 되면 어디가 비었는지 확인이 어렵다.



***참조형 기본형***

1. 변수에 값이 들어가면 기본형

2. 변수에 주소가 들어가면 참조형



**동기화**

1. `Synchroinized` 
2. 하나의 대상을 두고 여려개의 쓰레드가 한개만 접근할 수 있도록 하는 방식
3. 공유한 데이터에 한번에 하나의 쓰레드가 접근하여 사용하는법

**다형성**

- 클래스 A,B 가 상속관계를 가지고 있고 A가 슈퍼클래스(상위,부모) 일때
  - `A a = new B();` 가능 : **promotion**
  - `B b = (B)a;`가능 : **casting**



**제너릭**(Generic)

- 잘못된 타입이 사용될 수 있는 문제를 컴파일 과정에서 제거가능

- 장점

  - 컴파일 시 강한 타입 체크

  - 타입 변환(casting)을 제거 가능

    - 제너릭 전

    ```java
    public void generic(){
        List list = new ArrayList();
        list.add("hello");
        String str = (String)lis.get(0);//casting
        //하위타입에서 필요한 데이터를 사용하기 위해 casting
    }
    ```

    - 제너릭 사용 후

    ```java
    public void generic(){
        List<String> list = new ArrayList<String>();
     	list.add("hello");
        String str = list.get(0);
    }
    ```

  - 제너릭 타입

    - `<>`에 들어가는 인터페이스  or 클래스
    - `<?>` : 타입 제한 없음
    - `<?(하위) extends 상위타입>  `: 상위클래스를 상속받은 상위 or 하위 클래스만 가능 (~~나랑 내 밑에꺼만 가능해!!~~) ↓
    - `<?(상위) super 하위타입>` : 하위 클래스가 상속 받고 있는 상위 or 하위 클래스만 가능 (~~나랑 내 위에꺼만 가능해!!~~) ↑



**박싱 & 언박싱**

- 박싱(Boxing)

  ```java
  list.add(new Integer(1)); ---> list.add(1);
  //C#에서 사용 했던 편리 기능으로 자동으로 해당 객체로 생성 해준다.
  ```

- 언박싱(UnBoxing)

  ```java
  list.get(1,new Integer(1)); ---> list.get(1,1);
  //C#에서 사용 했던 편리 기능으로 자동으로 해당 객체로 생성 해준다.
  ```

  

**인스턴스,클래스의 특징** ->>3R

- Responsibility : 책임성 
- Reuse : 재사용성

- Relation : 관계 --> 목적을 위해 chain하는 것

---

#### 1.1 컬렉션 프레임워크

객체들을 효율적으로 `CRUD작업`을 할 수 있도록 제공도되는 컬랙션 라이브러리

- `java.until `패키지에 포함
- **정수**를 넣을 수 없고 **객체**를 넣을 수 있다.

#### 1.2. CRUD 작업 

1. List 컬랙션
   - **순서**(index)를 가지고  관리한다.
   - **중복** 저장 **O**
   - 종류
     - ArrayList
     - Vector(스레드 동기화)
     - LinkedList(빈번한 삽입,삭제가 일어날 시 성능이 좋다)
   - 주요메서드
     1. `add()` -> C
     2. `get() `-> R
     3. `set(indx,Object value)` -> U
     4. `remove(index)` -> D
     5. `size() `: 데이터의 크기 리턴
     6. `Empty()` : 컬렉션이 비어있는지 조사
   
2. Set 컬랙션
   - 순서 **X**(모은 데이터를 구분 할 수 없다)
   - 중복 저장 **X**
   
3. Map 컬랙션

   - **key**값 중복 허락x,**value** 중복O

   - Hashtable 

     - 스레드 동기화가 된 상태이다.
     - 생성 키워드 Hashtable

     ```java
     Hashtable<K , V> map = new Hashtable<K,V>();
     ```

   - HashMap

     - 동기화가 되지 않은 상태
     - 생성 키워드 HashMap

     ```java
     HashMap<K , V> map = new HashMap<K,V>();
     ```

   - 주요메서드

     1. `put(K key, V value)` : C
     2. `get(Object key)` : R
     3. `remove(Object key)` : D

   - 전체 조회를 할 시

   ```java
   	public void printAll(HashMap<String, Integer> map) {
   		Set<String> keys = map.keySet(); //순서가없고 중복이 없음
   		Iterator<String> iter = keys.iterator(); //한줄로 세우기
   		while(iter.hasNext()) {
   			String key = iter.next();
   			Integer value =map.get(key);
   			System.out.println("("+key+","+value+")");
   		}
       }
   ```

   

   

---

### 2. 스트림

> 데이터를 외부에서 보내고 가져오는 통로를 이야기한다.
>
> 연속적인 데이터의 흐름!!

2.1바이트 기반 스트림

- 그림,미디어,문자 등 모든 종류 데이터를 주고 받는 것이 가능하다

- `InputStream`,`OutputStream`

2.2문자 기반 스트림

- **문자만** 받고 보낼 수 있도록
- `Reader`,`Writer`

2.3 보조 스트림(filter) & 출력 스트림(Sinker)

- 보조 스트림(filter)
  - 여러가지 편리 기능을 제공해주는 스트림
  - 다른 filter와 연결 가능 -> Chain
- 출력 스트림(Sinker)
  - 저장하려는 데이터를 byte데이터로 변경 해줌

2.4 I/O(input/output)

- 콘솔,파일 등 다양한 외부 입출력이 존재해~
- 완벽하게 취급을 하지 못하고 **String은 UTF**를 사용해~
- I/O는연결이 많을까??
  - 원시데이터를 읽어 활용시 필터 스트림을 사용하기 때문 
  - 한클래스가 여러가지 작업을 하지 않기 때문

---

### 레퍼클래스

- 기본형이 컬렉션에 저장할 수 없으므로 **(기본형을) 저장할 수 있도록** 만든 클래스이다.



---

