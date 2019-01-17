# Weather API

# Challenge
Weather Service
All code challenges should be hosted on a publicly accessible git repository (i.e. GitHub, BitBucket, etc).
The business wants a web service developed that returns current wind conditions based on a user’s current zipcode.
### Constraints
1. Framework: Spring Boot    
2. Dependency Manager: Gradle or Maven    
3. Test Framework: JUnit and Mockito/Powermock    
4. Coding Style Guide: Google Java Style Guide    

### Design Goals
1. Bind your weather client to an interface, and not to the concrete implementation of the OpenWeatherMap API.    
2. Implement the cache handler as a decorator for the weather client.    
3. Bind services to an interface (not an implementation) in the service container.    

### Functional Requirements
1. Consume weather data from https://openweathermap.org/.    
2. Provide an HTTP GET /wind/{zipCode} method that takes a zipcode as a required path parameter and returns a wind resource.    
3. Validates input data.    
4. Response format should be JSON.    
5. Cache the resource for 15 minutes to avoid expensive calls to the OpenWeatherMap API.    
6. Provide a CLI command that will bust the cache if needed.    
7. Ensure that the cache is thread safe.    
8. Response fields should include: Wind Speed and Wind Direction    

### Unit Testing Requirements
1. Use mock responses for the OpenWeatherMap API.    
2. Use mocks when interacting with the cache layer.    

### How To Run
1. Clone the repository.    
2. Build project and generate the JAR.    
3. Execute project JAR.    
4. The wind resource should now be accessible by running a curl command:    
$ curl -x http://localhost:8080/api/v1/wind/89101    

# Solution

### Setup
The application is develop with Spring Boot.   
When building and compiling, make sure there is access to maven repository.   
To run the application execute the class
**com.code.weatherapi.WeatheraAiApplication**  
This will start up the application in an embedded Tomcat server.   
Make sure port 8080 is not used when running the application. 

**Swagger URL : http://localhost:8080/swagger-ui.html**   

#### Checkstyle:
I also added checkstyle using the google configuration, with a few suppressions
that can bee seen in checkstyle-suppressions.xml  
Run "mvn checkstyle:checkstyle -DskipTests", open the file /target/site/checkstyle.html to see
the result. 

### Cache Implementation
I used a LinkedHasMap for the cache, but I did extend it so I can override removeEldestEntry  
**com.code.weatherapi.cache.WeatherResponseCache**  
As the LinkedHasMap is not thread save, I added synchronized whenever the cache is updated. 

### Clear the cache from shell    
spring-shell-starter is used to create a shell.    
shell:>clearcache    
2019-01-07 15:29:06,366 DEBUG [main] com.code.weatherapi.shell.WeatherShell: Removed 1 elements from the cache    
