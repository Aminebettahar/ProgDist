FROM openjdk:8
COPY build/libs/RentMotorbikes-0.0.1-SNAPSHOT.jar RentMotorbikes-0.0.1-SNAPSHOT.jar
CMD java -Xmx300m -Xms300m -XX:TieredStopAtLevel=1 -noverify -jar RentMotorbikes-0.0.1-SNAPSHOT.jar 
EXPOSE 8080