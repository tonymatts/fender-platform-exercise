## Authorize Service
###

#### Description
A spring boot service for authorizing new and existing users.
###

#### Performs the following operations (listed by endpoint):
User Registration - `/user/createUser` \
Login (token based) - `/user/login/{name}/{password}` \
Logout - logs a user out - `/user/logout` \
Update a User's Information - `/user/updateUser` \
Delete a User - `/user/deleteUser` \
Healthcheck - `/user/healthcheck`
###

### Notes on the application
This application uses the mvc pattern, utilizing spring boot. \
I did not include any kind of database. As such, the program will not create a user or perform user updates. \

Given more time I would:
- add a database.
- add more unit tests and some integration tests.
- have the controller return an object like a ServiceResult that includes an http result.
- add a simple angular UI.
##

### Prerequisites:
mvn command \
jdk 1.8 or higher
###

### How to test the application:
Enter into the root folder from a command line terminal and execute: \
`mvn test`
###

### How to run the application:
Enter into the root folder from a command line terminal and execute: \
`mvn clean install` \
`mvn spring-boot:run` \
To verify the service is running and healthy, open a web browser and visit localhost:8080/user/healthcheck.
The output in your terminal should display: "service is healthy" \
###
