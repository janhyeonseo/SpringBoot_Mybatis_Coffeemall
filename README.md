
# MakeCoffee ☕️

Spring Boot 기반의 웹 애플리케이션으로, 사용자 로그인, 상품 관리, 결제 처리, 그리고 ChatGPT API 연동 기능을 제공합니다.

## 🚀 주요 기능

### 1. 사용자 관리
- 로그인 및 인증 기능 (`LoginController.java`)
- 회원 정보 관리

### 2. 상품 관리
- 상품 목록 조회 및 상세 보기 (`ProductController.java`)
- 상품 추가, 수정, 삭제 기능

### 3. 결제 처리
- 결제 데이터 관리 (`InsertMPayDao.java`)
- 결제 내역 조회

### 4. AI 챗봇 (ChatGPT 연동)
- OpenAI ChatGPT API를 활용한 챗봇 기능 (`ChatGptController.java`, `ChatGptService.java`)
- JSON 응답 처리 (`JsonResponse.java`)

## 🏗 프로젝트 구조

```
src/
├── main/java/com/maju
│   ├── LoginController.java
│   ├── ProductController.java
│   ├── StartController.java
│   ├── MakeCoffeeApplication.java
│   ├── ServletInitializer.java
│   ├── ChatGPT/
│   │   ├── ChatGptController.java
│   │   ├── ChatGptService.java
│   │   ├── ChatGptStartController.java
│   │   ├── JsonResponse.java
│   ├── PortOne/
│   │   ├── InsertMPayDao.java
└── resources/
    ├── application.properties
    ├── static/
    ├── templates/
```
<!--
## 🛠 기술 스택
- **백엔드:** Spring Boot, Spring MVC, Spring Security, MyBatis
- **데이터베이스:** Oracle Database
- **템플릿 엔진:** Thymeleaf, Thymeleaf Security
- **결제 시스템:** PortOne 연동
- **AI 서비스:** OpenAI ChatGPT API
- **웹 크롤링:** Selenium, BeautifulSoup
- **프론트엔드:** JavaScript, HTML5, CSS3
- **버전 관리:** GitHub
- **테스트:** JUnit
-->

- <p>
    <strong>백엔드 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white">
    <img src="https://img.shields.io/badge/Spring MVC-6DB33F?style=flat-square&logo=Spring&logoColor=white">
    <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white">
    <img src="https://img.shields.io/badge/MyBatis-003496?style=flat-square&logo=MyBatis&logoColor=white">
</p>

 
- <p>
    <strong>데이터베이스 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/Oracle Database-F80000?style=flat-square&logo=Oracle&logoColor=white">
</p>

 
- <p>
    <strong>템플릿 엔진 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=Thymeleaf&logoColor=white">
    <img src="https://img.shields.io/badge/Thymeleaf Security-6DB33F?style=flat-square&logo=Thymeleaf&logoColor=white">
</p>

- <p>
    <strong>결제 시스템 :</strong> &nbsp; 
    <img src="https://img.shields.io/badge/PortOne-004596?style=flat-square&logo=PortOne&logoColor=white">
</p>

- <p>
    <strong>AI 서비스 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/OpenAI ChatGPT-004596?style=flat-square&logo=OpenAI&logoColor=white">
</p>

- <p>
    <strong>웹 크롤링 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=Selenium&logoColor=white">
    <img src="https://img.shields.io/badge/BeautifulSoup-8A2BE2?style=flat-square&logo=Python&logoColor=white">
</p>

- <p>
    <strong>프론트엔드 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat-square&logo=Javascript&logoColor=white">
    <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
    <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white">
</p>

- <p>
    <strong>버전 관리 :</strong> &nbsp;
    <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white">
</p>




## ⚙️ 프로젝트 실행 방법

### 1. 환경 설정
- Java 17 이상 설치
- MySQL 또는 Oracle 데이터베이스 설정 (`application.properties` 수정)
- `application.properties`의 OpenAI API Key 설정

### 2. 실행 방법
```bash
./mvnw spring-boot:run
```
또는
```bash
mvn spring-boot:run
```

## 🔧 필수 설정 파일

### `application.properties` 예시
```properties
spring.application.name=''
server.port=''

# 오라클 DB 설정
spring.datasource.driver-class-name=''
spring.datasource.url=''
spring.datasource.username=''
spring.datasource.password=''

# Chat GPT API 키 설정
openai.api.key=''
```

## 📜 `pom.xml` 주요 의존성
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## 📜 데이터베이스 모델 (ERD)
아래는 프로젝트에서 사용된 데이터베이스의 ERD 다이어그램입니다.

![ERD 다이어그램](ERD%20다이어그램.png)

### 📌 테이블 설명

1. **product**: 상품 정보를 관리하는 테이블
   - `pid`: 상품 ID (PK)
   - `pname`, `pename`: 상품 이름
   - `pprice`: 가격
   - `pdesc`, `pinfo`: 상품 설명 및 정보
   - `psize`: 크기
   - `pimg`: 이미지 경로
   - `cnt`: 재고 수량

2. **member**: 사용자 정보를 저장하는 테이블
   - `id`: 사용자 ID (PK)
   - `username`: 사용자 계정명
   - `password`: 비밀번호
   - `role`: 사용자 역할 (일반 사용자, 관리자)
   - `name`, `pimg`: 사용자 정보
   - `today`: 가입 날짜

3. **cart**: 장바구니 정보를 저장하는 테이블
   - `cid`: 장바구니 ID (PK)
   - `pid`: 상품 ID (FK)
   - `id`: 사용자 ID (FK)
   - `pname`, `pename`: 상품 이름
   - `pprice`: 가격
   - `pimg`: 상품 이미지
   - `amount`: 수량

4. **InsertMPay**: 결제 정보를 저장하는 테이블
   - `mid`: 결제 ID (PK)
   - `id`: 사용자 ID (FK)
   - `mpaynum`: 결제 번호
   - `mpayprice`: 결제 금액
   - `today`: 결제 날짜
     
## 📜 API 명세서


## API 명세서

### LoginController

| HTTP Method | URL                 | Description              | Request Params             | Response      |
|-------------|---------------------|--------------------------|----------------------------|---------------|
| GET         | /login/loginForm    | 로그인 페이지 조회       | -                          | HTML Page     |
| POST        | /login/loginFormOK  | 로그인 처리              | `LoginVO` (JSON)           | Redirect URL |
| GET         | /login/loginSuccess | 로그인 성공 페이지       | -                          | HTML Page     |
| GET         | /login/failure      | 로그인 실패 페이지       | -                          | HTML Page     |
| GET         | /login/logOut       | 로그아웃 처리            | -                          | Redirect URL |
| POST        | /login/userformOK   | 회원 가입 처리           | `LoginVO` (JSON)           | HTML Page     |

---

### ProductController

| HTTP Method | URL                   | Description              | Request Params                  | Response         |
|-------------|-----------------------|--------------------------|---------------------------------|------------------|
| GET         | /product/productForm  | 상품 등록 페이지 조회     | -                               | HTML Page        |
| POST        | /product/productFormOK| 상품 등록 처리            | `ProductVO` (JSON, File Upload)| Redirect URL     |
| GET         | /product/productList  | 상품 목록 조회            | `start`, `end` (Pagination)    | HTML Page        |
| GET         | /product/cartList     | 장바구니 목록 조회        | -                               | HTML Page        |
| POST        | /product/cartInsert   | 장바구니 추가            | `ProductVO` (JSON)             | Redirect URL     |
| GET         | /product/cartDel      | 장바구니 단일 삭제        | `ProductVO` (JSON)             | HTML Page        |
| GET         | /product/cartDel2     | 장바구니 여러 개 삭제    | `cid[]` (Array)                | HTML Page        |

---

### StartController

| HTTP Method | URL       | Description          | Request Params | Response      |
|-------------|-----------|----------------------|----------------|---------------|
| GET         | /index    | 메인 페이지 조회     | -              | HTML Page     |

---

### ChatGptController

| HTTP Method | URL          | Description               | Request Params         | Response      |
|-------------|--------------|---------------------------|------------------------|---------------|
| POST        | /api/chat/ask| ChatGPT 응답 요청         | `prompt` (String)      | HTML Page     |


