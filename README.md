#How to run

Open CMD in the project folder (..../stockapi )

Run the following commands to start the service.


 >> gradle clean build

 >> java -jar build/libs/stockapi-0.1.0.jar
 
 Open web browser
 --------------------
 
 Goto the url "http://localhost:9000/company"
 
 See all Companies.
 
 
 Shortcut
 ---------
 To run a project in place without building a jar first you can use the “bootRun” task:

>> gradle bootRun



#References : 

 Jar to War : http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-gradle-packaging
 Managing Cross origin : https://spring.io/guides/gs/rest-service-cors 



#Code stack

----------------
- Java 1.8
- Spring


#Demo Site
-------------

https://stark-cliffs-91717.herokuapp.com/
