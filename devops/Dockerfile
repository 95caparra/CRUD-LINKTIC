FROM openjdk:11.0.5-jre
LABEL version="1.0.0" maintainer="fernando.benavides@moviired.co" description="..."
#ENV JAVA_HOME=/usr/local/openjdk-11
WORKDIR /app
EXPOSE 8080
#COPY target/* ./
COPY *.jar app.jar
ENV JAVA_OPTS="-server -Xms1G -Duser.timezone=America/Bogota -XX:+CMSClassUnloadingEnabled -XX:+UseG1GC -XX:+OptimizeStringConcat -Djavax.xml.accessExternalDTD=all -Dfile.encoding=UTF-8 -Dspring.output.ansi.enabled=always -Dspring.config.location=/app/config/application.yml"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]