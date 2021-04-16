# database

---

### SQL 문

#### DML

- SELECT 문

  - 중복된 값을 한개만 조회하기 `DISTINCT`

    ```sql
    SELECT DISTINCT addr FROM table명;
    ```

    

  - 전체 조회

    ```sql
    SELECT * FROM table명; -- 테이블의 모든 레코드를 모두 조회
    ```

    

  - 조건 조회

    ```sql
    SELECT *
    FROM table명
    WHERE key = 'value';
    -- 테이블 중 key속성중 값이 value인 모든 레코드를 조회
    ```

  - WHERE 절

    - 테이블 조회시 특정 조건의 레코더만 조회하기 위해 조건을 부여하는 절!!

    - 관계 연산자 사용 

      ```sql
      SELECT userID 
      FROM table명
      WHERE key1 >= 1000 AND key2 <= 2000;
      -- key1속성값이 1000이상이고(AND) key2속성값이 2000이하인 레코드의 userID를 출력
      ```

    - BETWEEN ... AND  &  IN() & LIKE

      - BETWEEN ... AND

      ```sql
      SELECT userID 
      FROM table명
      WHERE key1 BETWEEN 1000 AND 2000;
      -- key1속성값이 1000이상 2000이상인 레코드의 userID를 출력
      ```

      - IN()

      ```sql
      SELECT userName, addr
      FROM talbe명
      WHERE key1 IN ('경남','전남','경북');
      -- key1속성값이 경남,전남,경북인 레코드의 userName, addr를 출력
      ```

      - LIKE

      ```sql
      SELECT userName
      FROM table명
      WHERE key1 LIKE '김%';
      -- key1 속성값이 김으로 시작하는 값을 가진 레코드의 userName을 출력
      ```

  - ORDER BY 절

    - 결과가 출력되는 순서를 조절하는 구문~!! 오름차순(ASC) OR 내림차순(DESC)

    - default == 오름차순(ASC)

      - 오름차순

      ```sql
      SELECT userName, mDate FROM userTBL ORDER BY mDate ASC;
      --ASC 생략가능
      ```

      - 내림차순

      ```sql
      SELECT userName, mDate FROM userTBL ORDER BY mDate ASC;
      ```

    

- UPDATE 문
- DELETE 문
- INSERT 문



---



