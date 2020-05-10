FROM alpine:latest as build
#

RUN echo "http://dl-cdn.alpinelinux.org/alpine/edge/community" > /etc/apk/repositories \
     && echo "http://dl-cdn.alpinelinux.org/alpine/edge/main" >> /etc/apk/repositories

RUN apk add firefox-esr \
    && apk add chromium \
    && apk add openjdk8 \
    && apk add maven \
    && apk add dbus


ENV JAVA_HOME="/usr/lib/jvm/java-1.8-openjdk"
ENV PATH="$PATH:$JAVA_HOME/bin"


COPY / dest

WORKDIR dest

# ENTRYPOINT ["firefox", "--headless"]

CMD ["mvn", "test"]
