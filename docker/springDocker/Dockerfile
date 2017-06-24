FROM alpine

RUN apk update

RUN apk add openjdk8-jre-base

COPY deliciousFoodSpring.jar dfSpring.jar
COPY start.sh start.sh

RUN chmod +x start.sh

EXPOSE 8080

CMD ["/start.sh"]
