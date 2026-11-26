# Alumni Network

Alumni Network is being migrated from a Java Servlet/JSP application to Spring Boot 4 and Thymeleaf in incremental phases. The first migrated flow includes the landing page, login/logout, registration, and registration email verification. Other servlet-backed pages are not yet part of the Spring Boot application.

## Requirements

- Java 17 or newer
- Maven 3.6 or newer
- MySQL compatible with the existing schema

## Run locally

Configure the existing JDBC layer with `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables, or supply the local `config/database.properties` file. The database schema and DAOs are intentionally unchanged in this phase.

Registration email verification also needs `SMTP_USERNAME` and `SMTP_PASSWORD`. Optional settings are `SMTP_HOST` (defaults to `smtp.gmail.com`), `SMTP_PORT` (defaults to `587`), and `SMTP_FROM` (defaults to `SMTP_USERNAME`).

Run the application with:

```sh
mvn spring-boot:run
```

The packaged application can be built with `mvn package` and started with `java -jar target/Alumni-Network-1.0.3.jar`. The server port defaults to 8080 and can be overridden with `SERVER_PORT`.

## Migration status

The legacy source is still under `src/com/alumni` and `WebContent`. Existing business objects and JDBC DAOs remain in use. Legacy servlet classes and JSP files are retained as migration references but are excluded from the Spring Boot runtime; the current Thymeleaf views are under `src/main/resources/templates`, and the existing static assets are packaged from `WebContent`.
