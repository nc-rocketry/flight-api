from openjdk:8-jre-alpine3.9

RUN mkdir /usr/local/app
WORKDIR /usr/local/app
RUN apk add bash
COPY webservice/target/*fat*jar /usr/local/app/

CMD /bin/bash
