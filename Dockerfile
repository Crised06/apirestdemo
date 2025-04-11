FROM ubuntu:25.04
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*
RUN wget https://download.oracle.com/java/24/latest/jdk-24_linux-x64_bin.deb
RUN dpkg -i jdk-24_linux-x64_bin.deb
RUN rm jdk-24_linux-x64_bin.deb
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]