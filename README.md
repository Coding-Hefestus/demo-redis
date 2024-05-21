1. docker-compose up -d
2. docker exec -it redis_db redis-cli
3. FT.CREATE myIndexStudent ON HASH PREFIX 1 my:key:space: SCHEMA "User-Name" "TAG" "SEPARATOR" "|" "Acct-Session-Id" "TAG" "SEPARATOR" "|"
4. mvn clean package
5. java -jar .\target\demo-0.0.1-SNAPSHOT.jar
6. http://localhost:8080/test/get2
7. Observe the exception stack trace