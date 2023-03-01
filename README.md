### Experience in Java
- I have more than 3 years experience in Java
- I mainly use SpringMVC framework in my former jobs, and I started using Springboot during my masters.

### What I've done
- Made project working as expected
    - Installed [Lombok](https://medium.com/danielpadua/java-lombok-2984afff3e0a)  first as the original project was using it.
    - Fixed the employee saving bug (wrong logic in controller and should not write logic in controller) `[1]`

- Request / Response / REST API
    - Added the paging query method, as an interface that can return all the data is not a wise choice. `[1][11][15]`
    - Standardized the return value wrapping with Result.class to make it easy to be called and parsed by each end.`[1][13][14]`
    - Added some API desc to REST methods (Increase the readability of Swagger) `[1]`
    - Added request models instead of EntityBean at controller `[1][12]`
    - Exception handling `[9][10]`

- Protect controller end points
    - Authentication using spring security and Secure REST Controllers `[6][7]`
    - Database Authentication - User Repository and User Details Service `[3][5][8]`
    
- Add caching logic for database calls
    - Added caching logic for database calls in service layer.`[11]`
    
- Improve doc and comments
    
- Added tests
    - Added tests for EmployeeService `[21]`
    - Checked if the cache is in effect by enabling database access logging.`[19]`
    
- Init datasets `[18]`

EMPLOYEE
| ID | EMPLOYEE_NAME | DEPARTMENT  | EMPLOYEE_SALARY |
|----|---------------|-------------|-----------------|
| 1  | Tom           | Engineering | 5001            |
| 2  | Jerry         | Testing     | 4001            |

USER
| ID | USER_NAME | USER_PASSWORD | ACTIVE | ROLES | PERMISSIONS                 |
|----|-----------|---------------|--------|-------|-----------------------------|
| 1  | admin     | admin         | 1      | ADMIN | ACCESS_ADMIN1,ACCESS_ADMIN2 |
| 2  | user      | user          | 1      | USER  | ACCESS_USER1,ACCESS_USER2   |


```
+ java-challenge
    + src
        + main
            + java/jp/co/axa/apidemo
                + controller
                    - EmployeeController.java [1]
                + entities
                    - Employee.java [2]
                    - User.java [3]
                + repositories
                    - EmployeeRepository.java [4]
                    - UserRepository.java [5]
                + security
                    - SecurityConfiguration.java [6]
                    - UserPrincipal.java [7]
                    - UserPrincipalDetailsService.java [8]
                + services
                    + exception
                        - ErrorCodeEnum.java [9]
                        - ExceptionHandlerClass.java [10]
                    + impl
                        - EmployeeServiceImpl.java [11]
                    + request
                        - EmployeeRequest.java [12]
                    + response
                        - ResponseResultAdvice.java [13]
                        - Result.java [14]
                    - EmployeeService.java [15]
                + util
                    - Const.java [16]
                - ApiDemoApplication.java [17]
            + resources
                + db
                    - data.sql [18]
                - application.properties [19]
        + test
            + java/jp/co/axa/apidemo
                - ApiDemoApplicationTests.java [20]
                - EmployeeServiceTest.java [21]
```

### What can be improved If I had more time?
- Logging system - ELK(ElasticSearch, Logstash, Kibana)
- Considering scalability, use Redis or Memcache to replace the existing caching solution.
- Some common methods like searching employees by name, we can use search engines like ElasticSearch.
- Containerizing our SpringBoot application, so we can code and test locally while ensuring consistency between development and production.


### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console
- Initialized two employee data for easy testing, please refer to: classpath:db/data.sql
- Initialized two user information for authentication (username : password):
    - admin : admin
    - user : user

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.

------
The original Readme ⬇

### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java

Please let us know more about your Java experience in a few sentences. For example:

- I have 3 years experience in Java and I started to use Spring Boot from last year
- I'm a beginner and just recently learned Spring Boot
- I know Spring Boot very well and have been using it for many years


    
