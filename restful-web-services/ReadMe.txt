https://start.spring.io/

Group - com.exmaple.rest
Aftifact ID - restful-web-services
Spring version - 2.3.11

Dependencies
	Web	- all web dependencies	
	Dev Tools - developemental dependencies
	JPA - Spring Data JPA
	H2 - H2 Database dependencies

Import project

What is Maven Project - https://maven.apache.org/what-is-maven.html

Chrome Plugin - JSON Viewer 

---
What is dispatcher servlet?
Who is configuring dispatcher servlet?
	- Spring boot autoconfiguration
	- Is DispatcherServlet avail...if yes then go ahead and configure this DispatcherServlet
		
What does dispatcher servlet do?
	- Handle your request and response
	 
How does your HelloWorldBean converted to JSON?
	- Converter
	- @RestController -> @ResponseBody -> mapped your response to converter
	- JacksonAutoConfiguration.JacksonObjectMapperConfiguration matched:
      - @ConditionalOnClass found required class 'org.springframework.http.converter.json.Jackson2ObjectMapperBuilder' (OnClassCondition)
	- Jackson2ObjectMapper convert Bean to JSON and send response back
	
	
Who is configuring the error mapping?
	- ErrorMvcAutoConfiguration
