## Login Cache

### Setup
The application is develop with Spring Boot.   
When building and compiling, make sure there is access to maven repository.   
To run the application execute the class
**com.code.weatherapi.WeatheraAiApplication**  
This will start up the application in an embedded Tomcat server.   
Make sure port 8080 is not used when running the application. 

**Swagger URL : http://localhost:8080/api/v1/swagger-ui.htm**   

#### Checkstyle:
I also added checkstyle using the google configuration, with a few suppressions
that can bee seen in checkstyle-suppressions.xml  
Run "mvn checkstyle:checkstyle -DskipTests", open the file /target/site/checkstyle.html to see
the result. 

### Cache Implementation
I used a LinkedHasMap for the cache, but I did extend it so I can override removeEldestEntry  
**com.code.weatherapi.cache.WeatherResponseCache**  
As the LinkedHasMap is not thread save, I added synchronized whenever the cache is updated. 