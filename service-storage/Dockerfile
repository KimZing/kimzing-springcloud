FROM registry.cn-hangzhou.aliyuncs.com/kimzing/openjdk:1.8.0_252

MAINTAINER kimzing kimzing@163.com

COPY build/libs/*.jar /application.jar

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

ENTRYPOINT ["java", "-Xms512m", "-Xmx512m", "-Xss256k", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/application.jar"]
