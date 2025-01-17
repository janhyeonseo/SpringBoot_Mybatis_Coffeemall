# 결제&openAI API를 활용한 커피숍 관리 서비스

### 💡 서비스 개요
- 커피숍의 제품 관리와 결제 처리, 고객 관리 기능을 제공하는 웹 서비스.
- 사용자 인증과 권한 관리, 상품 정보 관리, 결제 시스템 통합, 질의응답 등의 기능을 구현하여 보안성과 사용자 편의성을 향상.

### 🛠️ 기술 스택
</div>
    <div style="text-align: left;">
    <div> <img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white">
          <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white">
          <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white">
          <img src="https://img.shields.io/badge/Spring MVC-6DB33F?style=flat-square&logo=Spring MVC&logoColor=white">
          <img src="https://img.shields.io/badge/Python-6DB33F?style=flat-square&logo=Python&logoColor=white">
        <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Sele&logoColor=white">
          <img src="https://img.shields.io/badge/Mybatis-003496?style=flat-square&logo=Mybatis&logoColor=white">
          <img src="https://img.shields.io/badge/OpenAPI-004596?style=flat-square&logo=OpenAPI&logoColor=white">
          <br>
          <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat-square&logo=Javascript&logoColor=white">
          <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
          <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white">
          <img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">
          <img src="https://img.shields.io/badge/Github-181717?style=flat-square&logo=Github&logoColor=white">
          </div>
    </div>
<br>

## 주요 기능 및 역할
### 📝 ChatGPT API 통합
- OpenAI의 GPT-3.5 모델을 사용하여 사용자의 질문에 대한 답변을 제공하는 시스템을 구현.
- RestTemplate을 활용하여 API와 통신하고, 응답을 화면에 출력.
- 사용자가 입력한 프롬프트에 대해 자동으로 답변을 제공하는 기능.

### 📝 PortOne 결제 시스템
- PortOne 결제 API를 활용하여 결제 처리 기능을 구현.
- 결제 정보를 데이터베이스에 삽입하는 MyBatis 기반의 DAO 및 서비스 계층을 구축.
- 결제 성공 및 실패에 따른 리디렉션 처리.

### 📝 Spring Security 적용
- 애플리케이션에 Spring Security를 적용하여 사용자 인증 및 권한 관리를 구현.
- 관리자가 필요한 페이지, 특정 역할을 가진 사용자만 접근할 수 있도록 URL 접근 권한 설정.
- 로그인, 로그아웃, 접근 거부 페이지 처리.
- `SecurityUserDetailsService`를 통해 데이터베이스에서 사용자 정보를 조회하고 인증 처리.

### 📝 상품 관리 및 결제 처리
- 상품 정보 입력, 수정 및 삭제 기능을 구현하고, 결제 시스템과의 연동을 통해 사용자가 상품을 구매할 수 있도록 처리.
  
### 📝 MVC 패턴 적용
- Spring MVC를 사용하여 애플리케이션의 구조를 구성하고, 사용자와의 상호작용을 처리.
- 컨트롤러, 서비스, DAO 계층을 구분하여 유지보수성과 확장성을 높임.

### 📝 관리자 모드와 회원모드 분리
- 관리자 모드와 회원모드를 분리하여 구매와 관리가 용이하게 구성.
