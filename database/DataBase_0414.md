# Data Base

>대용량 데이터 집합을 체계적으로 구성하는 것
>
>--> CRUD를 정확하게 사용가능

#### 특징

- 데이터의 **무결성**
  - 데이터에 오류(오염)이 있어서는 안됨
- 데이터의 **독립성**
  - DB의 크기를 변경하거나 데이터 파일 저장소 변경이 있더라고 응용프로그램은 영향을 받지 않아야함
- 데이터의 **안정성** 
  - ​	백업 복원 기능 필수!!

### 용어

---

### DBMS

- **RDBMS**(Relational DataBase Management System)

  - 에드거 F. 커드라는영국 학자가 발명! 

  - 관계형 데이터베이스

  - `table`로 데이터 정보를 구현하고 기본 키(**Primary** **key**),외래 키(**Foreign** **key**)를 사용해 관계(**Relation**)를 맺음

    

- **ODBMS**(Object DataBase Management System)
  -  데이터베이스에 객체를 저장하는 것 

- **ORDBMS**
  - RDBMS와 ORDBMS의 기능을 합친 것

### SQL

- RDBMS에서 사용되는 언어
- 특징
  - DBMS 제작사와 독립적
  - 이식성이 좋음
  - 버전 업이 꾸준함
  - 대화식 언어

---

###  Table

- 2차원 형식의 데이터 저장소

- **스키마**:대상(Entity)이 가지는 데이터베이스 구조, 제약조건 등을 **명세**한 것 
  - 데이터 사전에 저장됨
  - 속성의 이름과 함께 데이터의 타입을 결정
- **레코더**: 하나의 대상(튜플)을 설명해주는 것
- 행 과 열
  - 행(row): (= Entity, record, tuple)
  - 열(column):  (= Attribute, flied)

|      | 속성1 | 속성2 | 속성3 | 속성4 |
| ---- | ----- | ----- | ----- | ----- |
| 행1  | a     | 1     | E     | 4     |
| 행2  | b     | 2     | F     | 5     |
| 행3  | c     | 3     | G     | 6     |

#### 데이터 종류

**정형데이터** : 대상이 가지고 있는 데이터 중 파악하기 쉽고, 규칙적인 값

**비정형** **데이터** : 이미지,영상,음악 등 바이트 정보 

**반정형** **데이터** : 데이터 수집 후 목적에 맞도록 데이터를 JSON이나 XML형태로 포맷한 데이터

**전처리** : 반정형으로부터 정형에 가까운 데이터를 정리하는 과정



---

### 오라클 SQL 사용

#### 1. 사용자 생성 

1. 사용자 ID,PW설정

2. '테이블스테이스 : 저장 공간을 확보

3. 부여된 롤 ->권한 부여  connect , resource

4. 할당량 -> User, 할당량(),단위(M메가)

5. **외부에서 웹환경 접속 허용 명령**

   1. Run SQL Command Line 접속

   2. `connect` 명령어로 로그인

      1. `EXEC DBMS_XDB.SETLISTENERLOCALACCESS(FALSE);` 입력

         ```shell
         SQL> EXEC DBMS_XDB.SETLISTENERLOCALACCESS(FALSE);
         PL/SQL procedure successfully completed.
         ```



#### 2. 샘플 데이터 사용자 계정 사용

1. `connect` 명령어로 로그인
   1. (SQL Dev 실행) -> 로컬-system 접속
   2.  `ALTER USER HR ACCOUNT UNLOCK IDENTIFIED BY pw;` //pw== 원하는 비밀번호 입력
   3. 새 접속 클릭
   4. HR 사용자 사용

#### 

#### 2. 테이블 생성

- **데이터 자료형**
  - `NCHAR(n)`: 한국어 고정길이 문자열 (최대크기: 2000byte)
  - `CHAR(n)`: 고정길이 문자열(최대크기: 2000byte)
  - `NVARCHAR(n) `: 한국어 가변길이 문자열(최대크기: 4000byte)
  - `VARCHAR(n)`: 가변길이 문자열(최대크기: 4000byte)
  - `NUMBER(n)` : 숫자 (최대 38자리까지 가능)
  - `DATE` : 날짜
- **자동 생성**
  1. (테이블 파일)새 테이블 클릭
  2. 원하는 데이터 속성명,자료형 기입
  3. 기본 키(Primary key)값을 가질  속성 선택 시  (PK) 클릭
     - 중복되는 데이터가 존재하지 않게 특정 속성을 같은 값을 가질 수 없게 설정하는 거~
  4. 확인



