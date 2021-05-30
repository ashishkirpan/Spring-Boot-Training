Day-1
******
https://start.spring.io/

Group - com.exmaple.rest
Artifact ID - restful-web-services
Spring version - 2.3.11

Dependencies
	Web	- all web dependencies	
	Dev Tools - developmental dependencies
	JPA - Spring Data JPA
	H2 - H2 Database dependencies

Import project

What is Maven Project - https://maven.apache.org/what-is-maven.html

Chrome Plugin - JSON Viewer 

---
What is dispatcher servlet?
Who is configuring dispatcher servlet?
	- Spring boot auto configuration
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

Day 2
*****
convert input/output to xml format
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>
	
Path Variable
	http://localhost:8080/hello-world-path-variable/Mike

	https://github.com/ashishkirpan/Spring-Boot-Training
	https://github.com/ashishkirpan/Spring-Boot-Hello


Rest web service - Resource
	Social Media
		User --> Post

Operation / API's 
- Retrieve all users	-	GET /users 	
- Create a User			-	POST /users
- Get single User		-	GET /users/{id}		- /users/101
- Delete a User			-	DELETE /users/{id}	- /users/102

- Retrieve all post for a User			-	GET /users/{id}/posts
- Create post for a User				- 	POST /users/{id}/posts	
- Retrieve details for a post(single)	-	GET /users/{id}/posts/{post_id}

- Top-Down approach
- Bottom-Up approach

https://httpstatuses.com/




