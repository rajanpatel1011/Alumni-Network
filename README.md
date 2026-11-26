# Alumni Network

Alumni Network is being migrated from a Java Servlet/JSP application to Spring Boot 4 and Thymeleaf in incremental phases. The first migrated flow includes the landing page, login/logout, registration, and registration email verification. Other servlet-backed pages are not yet part of the Spring Boot application.

## Requirements

- Java 17 or newer
- Maven 3.6 or newer
- MySQL compatible with the existing schema

## Run locally

The existing JDBC layer reads `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables, or the local `config/database.properties` file. To start a disposable local MariaDB and restore the included legacy data plus the Phase 1 verification schema, run:

```sh
docker compose up -d database
export DB_URL=jdbc:mysql://localhost:3307/aumninw
export DB_USERNAME=alumni_local
export DB_PASSWORD=alumni-local-only
```

The compose service mounts `src/database/aumninw.sql` and then applies `database/migrations/001-phase1-email-verification.sql` on first initialization. Its development credentials are local-only; override them with `MYSQL_ROOT_PASSWORD`, `DB_USERNAME`, and `DB_PASSWORD` when needed. To discard and restore this disposable database, run `docker compose down -v` followed by `docker compose up -d database`.

Registration verification sends mail through Spring Boot's `JavaMailSender`. Configure `SPRING_MAIL_HOST`, `SPRING_MAIL_PORT`, `SPRING_MAIL_USERNAME`, `SPRING_MAIL_PASSWORD`, and `EMAIL_FROM` in the environment. The sender defaults to `SPRING_MAIL_USERNAME`; email delivery fails explicitly when the sender address or mail service is unavailable. These settings are needed only to exercise actual email delivery.

Run the application with:

```sh
mvn spring-boot:run
```

The packaged application can be built with `mvn package` and started with `java -jar target/Alumni-Network-1.0.3.jar`. The server port defaults to 8080 and can be overridden with `SERVER_PORT`.

## Migration status

The legacy source is still under `src/com/alumni` and `WebContent`. Existing business objects and JDBC DAOs remain in use. Legacy servlet classes and JSP files are retained as migration references but are excluded from the Spring Boot runtime; the current Thymeleaf views are under `src/main/resources/templates`, and the existing static assets are packaged from `WebContent`. The restore migration adds the email verification table and fields expected by the current registration DAO, which are missing from the historical SQL dump.
