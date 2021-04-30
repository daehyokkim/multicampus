# Git 버전관리

Source Code Management(SCM) Tool: 코드 관리 도구

Version Control System(VCS): 버전 관리 시스템

> 버전을 통해 코드를 관리하는 도구



#### 버전 관리를 하는 이유

1. 언제든 과거로 돌아갈 수 있음
2. 수정 이력을 확인 할 수 있음



## 1. 기본 구조

- Working tree
  - 파일을 생성 및 수정하는 단계
- Stayging Area
  - Working tree에서 작업한 파일 중 선택하여 Repository에 저장 하기 위한 장소
- Repository
  - 만들어진 버전
  - `.git` 디렉토리

### 2. 명령어

#### 1. git init

​	git 프로젝트(저장소)를 시작(폴더 단위)

```
Initialized empty Git repository in C:/.../.git/
```

1. (master) 
2. .git 폴더 생성

#### 2. git status

​	git의 현재 상태를 출력

- 최초상태

```
on branch master: master라는 브랜치에 있음
No commits yet: 아직 commit이 없음
nothing to commit (create/copy files and use "git add" to track)
: commit할 게 없음
```

- 파일/폴더 추가시 ( `touch a.txt` )

```
...
Untracked files: (추적되지 않은 파일)
(use "git add <file>..." to include in what will be committed)
a.txt (빨강)
nothing added to commit but untracked files present (use "git add" to track)
: commit하기 위해 추가된 파일이 없음, 그러나 추적되지 않은 파일은 있음

```

- add 이후(`git add a.txt`)

```
changes to be committed:
commit할 변화들
(use "git rm --cached <file>..." to unstage)
new file: a.txt (초록)
```

- commit 이후(`git commit -m "first unstage"`)

```
on branch master
nothing to commit, working tree clean
```

#### 3. git add [파일명]

commit하기 위한 stage에 파일 추가

#### 4. git commit 

스냅샷 & 버전 생성

- `git commit -m "커밋메시지"` : 스냅샷 & 버전 생성

#### commit의 구성 요소

- committer(author): commit을 찍은 사람 
- commit datetime(date): commit을 찍은 시간 
- commit message: commit에 대한 내용 (필수)

(참고)

"Modify file content in ..." --> 수정 메시지.

**20210501** 추가 commti 정보

- 커밋 메시지를 잘못 적었을 때 `git push`이전, 이후 상황 수정 방법에 좋은 링크를 찾아 추가한다!!
  - [git commit 수정 방법](https://velog.io/@mayinjanuary/git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%84%B8%EC%A7%80-%EC%88%98%EC%A0%95%ED%95%98%EA%B8%B0-changing-commit-message)

#### 5. git config 

- `git config --global user.email"이메일"` : 사용자 이메일 설정 
- `git config --global user.name "이름"` : 사용자 이름 설정
- `git config --global user.email` : 사용자 이메일 출력 
- `git config --global user.name`: 사용자 이름 출력
- `git config --global core.editer "editer이름"` : git commit 명령어 실행 시 진행되는 에디터 종류를 바꿈

#### 6. git log

commit 목록(log) 출력

- `git log -oneline`: 한줄 출력
- `git log -숫자` : 출력 갯수 한정
- `git log --status` : 수정된 파일이 무엇인지와 변경된 코드 라인수를 확인 할 수 있다.

#### 7. git diff

변경 내역 출력 

파일을 수정한 후 이전 버전과 비교하여 수정된 내용을 출력해준다.

```
diff --git a/a.txt b/a.txt
index a5bce3f..b2fc7fe 100644
--- a/a.txt
+++ b/a.txt
@@ -1 +1,2 @@
-test1 삭제된 내용
+clear 추가된 내용
+new line 추가된 내용
```

#### 8. git checkout [log ID]

- 해당 log Id이전의 기록으로 돌아간다.
- `git  checkout master` 이전 단계로 돌아감

#### 9. git reset

-  `git reset -hard [log id]` : 해당 버전(log Id)이 되겠다. , 수정하고  있는 것 또한 삭제
- **공유되기 전단계의 내용만 reset하기**

#### 10. git revert

- `git revert [log id]`  -> `에디터별 저장 입력`  :  log id 버전만 되돌리고 싶을때 사용
  - 단. 해당 log id 이후의 버전이 존재시 에러 발생 가능성이 있기 때문에 역순으로 사용을 권장

#### 11. git restore

- `git restore --staged [파일명]` : `git add ...`명령어를 취솔 할때 사용

- `git restore [파일명]` :  **조심히 사용**, 최종 커밋 시점으로 파일 상태를 복원(restore)

(참고) CLI 명령어

- `echo [문자열]`
  - command line 출력
- `echo [문자열] > [파일명]`
  - command line > 파일로 입력
  - `echo [문자열] >> [파일명]`입력시 내용 추가
- cat [파일명]
  - 파일의 내용 출력

