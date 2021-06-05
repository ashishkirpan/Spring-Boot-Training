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


------

Day 3
*****

- Spring Doc
	Web Service - Design for Machine to machine (or application to application) interaction
	If client/another application is going to connect with our web service, we need to share API Documentation
	Earlier approach - Manual documentation (.doc, .pdf) and share with customer
	
	Example of API - https://razorpay.com/docs/api/
		
Spring Doc? -> 
	- Open api java library provided by spring boot
	- Generate the API documentation using spring boot project
	- Another lib swagger -> but requires lot of configuration
	- https://springdoc.org/
	
	<dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-ui</artifactId>
      <version>1.5.9</version>
	</dependency>
	
	- http://localhost:8080/swagger-ui.html
	- Open-api documentation available at --> http://localhost:8080/v3/api-docs	
	
	Demonstration & examples available at
		https://github.com/springdoc/springdoc-openapi-demos/tree/master/springdoc-openapi-spring-boot-2-webmvc
		http://129.159.201.215:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
		
	- This documentation can be completed by comments using swagger-api annotations.
		-	on Class 
			- @Schema(description = "All details about the user")
		- 	on variables
			@Size(min = 2, max = 20, message = "Name should have at least 2 characters")
			@Schema(description = "Name should have at least 2 characters")
			
			@Past(message = "Date should be less than today's date")
			@Schema(description = "Birthdate should be in the past")
	
		- on Controller
			- @Tag(name = "retrieveUser", description = "Retrieve specific user information")
			- @ApiResponse(responseCode = "200", description = "Retrun the details of user")
			- @Parameter(name = "id", description = "Unique id of User")
	
JPA
----
	@Entity
	@Id
	@GeneratedValue
	- other annotations @Column 
	
	application.properties
		spring.jpa.show-sql=true
		spring.h2.console.enabled=true

		create table user (
			id integer not null, 
			birth_date timestamp, 
			name varchar(255), 
			primary key (id)
		)
	
		- http://localhost:8080/h2-console
		- application.prop
			spring.datasource.url=jdbc:h2:mem:testdb
						
	Add the predefined data (masterscript) in database
		- Create SQL file in resource dir : data.sql
		- insert into user values(1, sysdate(), 'Adam');
		- spring.jpa.defer-datasource-initialization=true
		
	- Create UserRepository
		- @Repository
		- extends JpaRepository


