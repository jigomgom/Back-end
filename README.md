# 🐳 밥먹언?

# 🍇 프로젝트 목표

---

<aside>
💡 제주도 맛집 리스트를 정리하며 Back-end와 Front-ene간의 소통을 중요시 하였습니다.

</aside>

지난 주차 프로젝트를 진행하며 쌓아왔던 기술들을 적용해보기 위해 프로젝트를 구성하였습니다.

회원 가입 및 로그인, CRUD 의 기본 기능 구현에 충실하며, 진행 상황에 따라 기능들을 구현하였습니다.  
[유튜브 링크](https://youtu.be/ZjxE6d2uZPA)

# 🍉 밥먹언? 팀 소개

---

| 주특기 | 팀원 | 연락처 | Email |
| --- | --- | --- | --- |
| React | 권지은님 | 01053071417 | stacykwon86@gmail.com |
| Spring | 김이안님 | 01024971512 | eank0108@gmail.com |
| Spring | 박민수님 | 01096000151 | bbodd2013@naver.com |
| Spring | 정현욱님 | 01094759512 | jeonghyeonuk98@gamil.com |
| React | 한지용님 | 01057385019 | hjy583@naver.com |

# 🥭 BE, FB Git 주소

---

- [Back-end Git](https://github.com/jigomgom/Back-end.git) 으로 바로 가기
- [Front-end Git](https://github.com/jigomgom/Front-end.git) 으로 바로 가기

# 🍊 밥먹언? 주요 기능

---

- **기능** **1: 회원가입, 로그인**
    - Jwt 토큰 사용
    
- **기능** **2: 맛집 등록, 삭제, 업데이트**
    - 이미지 여러장 등록
    
- **기능** **3: 맛집 리스트 페이징 (무한 스크롤)**
    - JPA Page를 이용하여 페이징
   - DTO로 감싸 isLast, total 만 리턴
   - 로그인시 해당 유저가 좋아요를 눌렀는지 판별하는 키 리턴

- **기능** **4:  좋아요 기능**
    


<div><h1>🥭 기술 스택</h1></div>
<p align="center">

<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/Java-EC2025?style=for-the-badge&logo=Java&logoColor=white">
<img src="https://img.shields.io/badge/Gradle-39D52D?style=for-the-badge&logo=Gradle&logoColor=white">

<br>
<img src="https://img.shields.io/badge/jwt-000000?style=for-the-badge&logo=jwt&logoColor=white">
<img src="https://img.shields.io/badge/Docker-4DCBFE?style=for-the-badge&logo=Docker&logoColor=white">
<img src="https://img.shields.io/badge/AWS EC2 SDK-F58536?style=for-the-badge&logo=AWS&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

<br>
<img src="https://img.shields.io/badge/Notion-181818?style=for-the-badge&logo=Notion&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">


<br>
</p>

- Back-end

    - Java
    - SpringBoot
    - jwt
    - Docker
    - AWS EC2
    - MySQL
    - Notion
    - github
    - Slack
 
 
# 🐳 DB 설계

---

<details>
<summary>🐳 ERD</summary>
<div markdown="1">

![ERD](https://user-images.githubusercontent.com/95006095/173968568-ad73caa7-32f4-454c-996e-c0c984765bc1.png)

</div>
</details>  

# 📌 트러블 슈팅

---
1. 메인페이지 리스트 GET 요청시 로그인된 사용자는 좋아요를 눌렀는지 안눌렀는지 판별하는 isLike 필드가 필요함  
   -> Token 값으로 유저를 판별 하려 했지만 JWT Filter 스킵으로 인해 불가능  
   -> JWT Filter에서 url, method 로 메인페이지 GET요청을 판별하여 스킵 했지만 비로그인시 JWT토큰 검증 오류  
   -> 로그인시 UserId를 PathValue로 받아 isLike 판별(해결완료)  
2. 좋아요 눌린 Feed 삭제시 테이블 연관관계로 인해 오류발생(삭제불가)  
   -> Likes Entity 안의 Store테이블에 어노테이션 @OnDelete(action = OnDeleteAction.CASCADE) 추가로 함께 삭제되게 구현(해결완료)  
   -> 해결 완료 인줄 알았지만 H2 에서는 됐지만 RDS에서는 오류 발생  
   -> MySQLDialect(기본 스토리지 엔진)는 @OnDelete 어노테이션을 지원하지 않음  
   -> FK로 좋아요 먼저 삭제 후 Store 삭제함(해결완료)  

# 🍅 주간 스케쥴

---

09:00 ~ 10:00 아침 팀 회의

11:00 ~ 12:00 CS 스터디

12:00 ~ 13:00 점심식사

17:00 ~ 18:00 오후 팀 회의

- 06월 10일 - 금
    - 진행 상황 공유 : 20:00 ~
- 06/11 (토)
    - **공통**
        - 업무 공유
        - 이슈 공유
        - 주특기 별 기능 구현
- 06/13 (월)
    - **공통**
        - 업무 공유
        - 이슈 공유
        - 주특기 별 기능 구현
- 06/14 (화)
    - **공통**
        - 업무 공유
        - 이슈 공유
        - 주특기 별 기능 구현
- 06/15 (수)
    - **공통**
        - 업무 공유
        - 이슈 공유
        - 주특기 별 기능 구현
- 06/16 (목)
    - **공통**
        - 업무 공유
        - 이슈 공유
        - 주특기 별 기능 구현

# 🍒 와이어프래임

---

### Main view

- 로그인 Navbar 및 전체 Main view
- 포스트를 작성한 사용자만 수정 및 삭제 허용
- 로그인 시 포스트를 작성할 수 있도록 허용
    
 ![Main view](https://user-images.githubusercontent.com/107230384/173980499-d0018dd6-7689-4842-a2a7-d62bb9207cc0.png)
    

- 로그아웃 Navbaer

![Group 17](https://user-images.githubusercontent.com/107230384/173980788-728eff53-2d5a-4b50-96d8-759341c380c6.jpg)

### 회원가입

![Sing up page](https://user-images.githubusercontent.com/107230384/173980540-8e1e44b0-1348-4b52-b69d-76fcdba445c6.png)

### 로그인

![Login page](https://user-images.githubusercontent.com/107230384/173980583-e6094194-642c-410d-953f-82e89c5b4845.png)

### 맛집 게시글 작성하기

![Upload page](https://user-images.githubusercontent.com/107230384/173980614-548bdce3-7c7e-412a-ae6e-95870be1e067.png)


### 맛집 게시글 수정하기
![Edit page](https://user-images.githubusercontent.com/107230384/173980654-b1f602d3-7c08-4590-bbc1-1444498e6a38.png)

# 🍊 API

---

[최종 API](https://www.notion.so/a720cff38f7249d392bdf2c5dc957498)

# 🍎 팀 내 하고 싶은 말씀들

---

- 한 주간 잘 부탁드립니다.

# 🥭[구글 대시 보드](https://docs.google.com/spreadsheets/d/1OCmYlh12oT2aN8fBhAJzl1Qdd_kL_rN8Gcpu1skV7tE/edit#gid=933892082)로 바로 가기

---


