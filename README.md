# Handle Master Slave databases with Java Spring Boot
## 1. Directory structure
```plaintext
   project-root/
   ├── codequality                                      # Checkstyle configuration
   ├── gradle                                           # Gradle wrapper, manage library versions
   └── src/
      ├── main/java/com/example/assignment/             # Spring Boot application source files
      └── main/resources/
         ├── scripts/                                   # Database scripts
         └── application.properties                     # Spring Boot application configuration
         └── log4j2.xml                                 # Log4j2 configuration
   ├── build.gradle                                     # Gradle build script
   ├── Dockerfile                                       # Dockerfile
   ```

## 2. Installation
### 2.1. Prerequisites
- JDK >= 21
- Docker
- Gradle >= 7.5
- H2 Database
### 2.2. Build
```shell
./gradlew clean build
```
### 2.3. Setup Database
- Use create_master_meals.sql script to initialize master database
```shell
url: jdbc:h2:mem:spring-master-db
username: sa
password: password
```
- Use create_slave_meals.sql script to initialize slave database
```shell
url: jdbc:h2:mem:spring-slave-db
username: sa
password: password
```
## 3. API Endpoint
Once the service is up, the following URLs will be available:

| Address                                         | Method | Description                                               |
|-------------------------------------------------|--------|-----------------------------------------------------------|
| /api/v1/meals  | GET    | This API provides a list of meals from Slave database.    |
| /api/v1/meals/{id}  | GET    | This API provides a specific meal from Slave database.    |
| /api/v1/meals  | POST   | This API inserts Meal into Master database.               |