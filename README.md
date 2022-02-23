# Project 2 E-Commerce Grocery App
**Back-End Application utilizing Spring Boot Framework**<br>
   > By Art Weinstein, Ben Karlsberg, Robert Davis, Ryan Haque, Tomas Anbessaw

### Reference to Web Appication Github: 
* [Front-End Repository](https://github.com/redn6gx/p2_groceryapp_frontend/)


## Project Summary
A Grocery E-Commerce App designed to emulate an online marketplace, with the purpose of allowing users to order groceries from an online platform. As a user, you can create an account and log into the application. Additionally you can search for items, add items to a user's cart, and checkout. The backend API was built using Java 8 in combination with the Spring Framework and hosted on an Amazon EC2 instance.

## Technologies Used

* Java 8
* Spring Boot MVC
* Spring Boot JPA
* Spring Boot Dev Tools
* Apache Lombok
* Apache Maven
* JUnit
* PostgreSQL
* Postman
* DBeaver

## Setup/Installation Requirements
1. [Clone this repository](https://github.com/benkarlsberg/GroceryAppBackEndP2)
2. Navigate to /p2backend/src/main/resources/
3. Create an application.properties file
4. Enter the following within application.properties (insert credentials where implied):
  ``` spring.datasource.driver-class-name=org.<YOUR DATABASE DRIVER HERE>.Driver
spring.datasource.url=jdbc:<YOUR DATABASE ENDPOINT HERE>
spring.datasource.username=<YOUR USERNAME HERE>
spring.datasource.password=<YOUR PASSWORD HERE>
spring.jpa.hibernate.ddl-auto=update
management.endpoints.web.exposure.include=*
management.endpoint.shutdown.enabled=true
endpoints.shutdown.enabled=true
endpoints.shutdown.sensitive=false
management.endpoint.beans.enabled=true
endpoints.beans.sensitive=false
 ```
5. Navigate to /p2backend/ in a command terminal and run the command `mvn package`
6. Navigate to /p2backend/target in the command terminal and run the command `java -jar p2backend.jar`

## URI Usage

* /users
  * Get and Post request 
* /users/{id}
  * Put and Delete Request by ID
* /users/{username}
  * Put and Delete Request by username
* /item
  * Get and Post request
* /item/{id}
  * Get, Put and Delete by ID
* /cartitem
  * Get and Post
   



