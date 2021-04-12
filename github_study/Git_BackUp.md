# Git BackUp



### 용어정리

**1. Local Repository** : 지역 저장소 

**2. Remote Repository** : 기억 저장소

**3. push** : 지역 --> 기억 저장소로 저장하는 법

**4. clone** --> 기억 저장소 내용을 지역 저장소에 복제

**5. pull** -->  기억 저장소 데이터 --> 지역 저장소로 가져옴



### github 생성

1. `New` 클릭
2. `Repository name` 설정( 프로젝트명 설정)
   - `public` or `private` 접근 유형을 설정
3. `create repository`클릭



### 명령어

##### 1. git remote

- 원격 저장소 정보 추가
  - 원격 저장소 이름 : 관례적으로 origin 사용

```
git remote add 'origin(이름)' '생성된 github 원격 저장소 주소'
```

- 원격 저장소 정보 출력
  - `git remote -v`

```
git remote --v
origin  https://github.com/daehyokkim/mc_sn_github_base.git (fetch)
origin  https://github.com/daehyokkim/mc_sn_github_base.git (push)
```

##### 2. git push [이름] [브렌치]

- `git push origin master` 

```
$ git push origin master
Enumerating objects: 6, done.
Counting objects: 100% (6/6), done.
Delta compression using up to 12 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (6/6), 427 bytes | 213.00 KiB/s, done.
Total 6 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/daehyokkim/git_study.git
 * [new branch]      master -> master
```

#### 3. git clone

- 원격 저장소 다운로드(복제)

```
$ git clone [원격저장소 주소]
Cloning into 'git_study'...
remote: Enumerating objects: 37, done.
remote: Counting objects: 100% (37/37), done.
remote: Compressing objects: 100% (23/23), done.
remote: Total 37 (delta 14), reused 32 (delta 9), pack-reused 0
Receiving objects: 100% (37/37), done.
Resolving deltas: 100% (14/14), done.
```

##### 4. git pull [이름] [브렌치]

- 원격 저장소 정보 추가

```
$ git pull
remote: Enumerating objects: 3, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (1/1), done.
remote: Total 2 (delta 1), reused 2 (delta 1), pack-reused 0
Unpacking objects: 100% (2/2), 206 bytes | 25.00 KiB/s, done.
From https://github.com/daehyokkim/git_study
   f0507b1..f2797f5  master     -> origin/master
Updating f0507b1..f2797f5
Fast-forward
 q.txt | 0
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 q.txt
```





### 협업

> Github의 꽃 협업을 위한 **branch**를 학습하기~~ 

---

#### 1. 협업을 위한 접근 권한 설정

##### 	1.1 접근권한 부여하는 법

​	셋팅(`settings`)-> 메니지 엑세스(`manage acces`) ->  팀원 id 추가`invite a  collaboprator`

##### 	1.2 접근권한 받기

​	github 이메일로 전송 되는 **메일로 수락**하면 된다!!

---

#### 2. Git branch

- 작업을 하는 하나의 `commit의 가지`(줄기)

##### 2.1. git branch

- 현재 모든 branch 출력
  - `git branch [브렌치명]` : 새로운 브렌치 생성
  - `git checkout [브렌치명]` : branch 이동

 #### 3. git merge [팀원 branch]

- `팀원`브렌치가 작업한 내역들을 `master` 브렌치와 합치는 명령어

---





***새로 배운것 끄적여 보기~***

1. 파일 시스템이기 때문에 디스크 단계에서 관리된다>?

2. 복원 : 무엇이 변했는지 git이 objects 파일에 해쉬들이 저장 되어있음.  

   --> **`git ounder the hood`** 참고 해보기!!

3. merkle tree --> 블록체인과 깃

4. ***브렌치스위칭시 항상 클린업이 중요하다***

5. `GIt 부수면서 배우는 것~~!!`

6. 글쓰는 능력 == 정리능력 == 코드쓰는 능력