스프링부트를 실행하기위한 IntelliJ와 같은 IDE를 필요로 합니다.

자바11로 진행하였습니다.

MYSQL설치가 필요합니다. 작업당시에는 docker에 mysql 8버전을 설치하여 진행하였습니다. 포트는 3306으로 진행해주시면 됩니다.

DB 암호의 경우 리소스 폴더의 application.properties에서

spring.datasource.password=seven7의 seven7 부분을 본인이 사용하시는 암호로 바꿔주시면 됩니다.

데이터베이스 TEST_DB를 추가해서 진행해주세요.

모두 로컬호스트 환경으로 각자 실행하면 될거라 생각하지만 문제가 있으시면 말씀해주세요.