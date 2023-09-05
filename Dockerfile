FROM openjdk:17-jdk

# JAR 파일의 정확한 경로를 ARG로 지정
ARG JAR_FILE=./build/libs/kbodot-0.0.1-SNAPSHOT.jar

# 빌드 결과물 복사
COPY ${JAR_FILE} app.jar

# JAR 파일을 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
