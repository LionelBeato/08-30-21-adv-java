# JWT Demo Project

Simple JWT demo Spring Boot application. This project is heavily based on the following tutorial: 

https://www.techgeeknext.com/spring/spring-boot-security-token-authentication-jwt

This project heavily utilizes the JWT standard, which describes a quick and compact way to send information as JSON. To learn more, read the following article: 

https://jwt.io/introduction


## Note
- This project relies on a dependency called jsonwebtoken. JJWT utilizes a dependency for XML binding called JAXB. This is disabled by default in standard editions of Java after Java 8.
- For Java 11 and higher be sure to add the following dependency to enable JAXB: 

      ```
      <dependency>
              <groupId>org.glassfish.jaxb</groupId>
              <artifactId>jaxb-runtime</artifactId>
      <dependency>
      ```