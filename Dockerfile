from openjdk:8-jre-alpine3.9

RUN apk add bash
ARG SPRING_PROFILE=prod
ARG NCR_APP_PASSWORD=iCTa!M]hr2F@FuN{
#ARG NCR_DB=192.168.1.127
ARG NCR_DB=173.255.113.87


ENV NCR_APP_PASSWORD=${NCR_APP_PASSWORD}
ENV SPRING_PROFILE=${SPRING_PROFILE}
ENV NCR_DB={NCR_DB}

RUN echo "$NCR_DB db.ncr" >> /etc/hosts

RUN mkdir /usr/local/app
WORKDIR /usr/local/app
COPY webservice/target/webservice*fat*.jar /usr/local/app/

EXPOSE 8080
CMD java \
    "-Dspring.profiles.active=${SPRING_PROFILE}" \
    "-Dncr.db.password=${NCR_APP_PASSWORD}" \
    "-Dncr.db.encoded=true" \
    -jar webservice*fat*.jar
