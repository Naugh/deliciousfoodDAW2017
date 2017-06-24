FROM alpine

RUN apk update

RUN apk add nodejs-npm
RUN npm install -g @angular/cli

RUN apk add openjdk8-jre-base
RUN mkdir angular

COPY angular angular
COPY deliciousFoodSpring.jar dfSpring.jar
COPY start.sh start.sh
COPY angular.sh angular.sh

RUN chmod +x angular.sh
RUN chmod +x start.sh

RUN ls
#RUN /angular.sh

EXPOSE 4200

#CMD ["/start.sh"]
CMD ["/angular.sh"]
