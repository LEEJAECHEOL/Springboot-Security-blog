# 스프링부트 블로그 프로젝트 V2

## 의존성
- Spring Web
- Lombok
- Spring Dev Tool
- OAuth
- JPA
- Security
- MySQL Driver

## DB 설정

```sql
create user 'pos'@'%' identified by '1234';
GRANT ALL PRIVILEGES ON *.* TO 'pos'@'%';
create database pos;
```

## 화면 디자인
1. 메인페이지
![캡처](https://github.com/LEEJAECHEOL/Springboot-Security-blog/blob/master/images/index.png)
2. 로그인페이지
![캡처](https://github.com/LEEJAECHEOL/Springboot-Security-blog/blob/master/images/login.png)
3. 회원가입페이지
![캡처](https://github.com/LEEJAECHEOL/Springboot-Security-blog/blob/master/images/register.png)
4. 상세보기페이지
![캡처](https://github.com/LEEJAECHEOL/Springboot-Security-blog/blob/master/images/detail.png)
5. 유저정보수정페이지
![캡처](https://github.com/LEEJAECHEOL/Springboot-Security-blog/blob/master/images/userUpdateForm.png)
