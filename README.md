# revyou-api

This project contains the webservice API for the RevYou platform. The project is developed and tested on Tomcat and PostgreSQL.

## Frameworks
* Spring 5
* Hibernate 5.2

## Tools
* Maven
* Liquibase

## Languages
* Java 8

## Building
### Maven
Use ```mvn clean package``` on the root project directory to generate a WAR file.

### Liquibase
Use ```mvn liquibase:update -Dliquibase.url=<jdbc_url> -Dliquibase.username=<jdbc_username> -Dliquibase.password=<jdbc_password>```
to generate/update the database.

## Deployment
### Tomcat
Copy the WAR file to Tomcat's webapps directory or unzip the WAR in a directory inside the webapps directory ('revyou-api', for example).

Download a recent PostgreSQL JDBC driver for Java 8+ at https://jdbc.postgresql.org/download.html and put it in Tomcat's lib directory.

Register the jdbc/revyou datasource on Tomcat. Edit the file context.xml located in Tomcat's conf directory,
and add the resource inside the existing ```Context``` tags. For example:
```xml
<Context>
    <Resource name="jdbc/revyou" auth="Container"
          type="javax.sql.DataSource" driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://127.0.0.1:5432/revyou"
          username="revyou" password="123" maxTotal="20" maxIdle="10"
          maxWaitMillis="-1"/>
</Context>
```

The resource's name, type, and auth shouldn't be changed.

## Developing
### Eclipse
Select File -> Import -> Maven -> Existing Maven Projects.
Select the project folder and click on Finish.

When using Tomcat on Eclipse, the datasource should be registered on the context.xml file inside
the Servers directory on Eclipse.
