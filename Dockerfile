from openjdk:8-jre-alpine3.9

COPY target/ /usr/local/app

CMD /bin/bash
