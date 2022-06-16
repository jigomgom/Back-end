### 📎 구현 기능
1. 회원가입, 로그인
   - Jwt 토큰 사용
2. 맛집 등록, 삭제, 업데이트
   - 이미지 여러장 등록
3. 맛집 리스트 페이징 (무한 스크롤)
   - JPA Page를 이용하여 페이징
   - DTO로 감싸 isLast, total 만 리턴
   - 로그인시 해당 유저가 좋아요를 눌렀는지 판별하는 키 리턴
4. 좋아요 기능
### 🐳 DB 설계
<details>
<summary>🐳 ERD</summary>
<div markdown="1">

![ERD](https://user-images.githubusercontent.com/95006095/173968568-ad73caa7-32f4-454c-996e-c0c984765bc1.png)

</div>
</details>

###  📌 트러블 슈팅
1. 메인페이지 리스트 GET 요청시 로그인된 사용자는 좋아요를 눌렀는지 안눌렀는지 판별하는 isLike 필드가 필요함  
   -> Token 값으로 유저를 판별 하려 했지만 JWT Filter 스킵으로 인해 불가능  
   -> JWT Filter에서 url, method 로 메인페이지 GET요청을 판별하여 스킵 했지만 비로그인시 JWT토큰 검증 오류  
   -> 로그인시 UserId를 PathValue로 받아 isLike 판별(해결완료)  
2. 좋아요 눌린 Feed 삭제시 테이블 연관관계로 인해 오류발생(삭제불가)  
   -> Likes Entity 안의 Store테이블에 어노테이션 @OnDelete(action = OnDeleteAction.CASCADE) 추가로 함께 삭제되게 구현(해결완료)
   -> 해결 완료 인줄 알았지만 H2 에서는 됐지만 RDS에서는 오류 발생
   -> MySQLDialect(기본 스토리지 엔진)는 @OnDelete 어노테이션을 지원하지 않음
   -> FK로 좋아요 먼저 삭제 후 Store 삭제함(해결완료)
### 📜 기술 스택

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
