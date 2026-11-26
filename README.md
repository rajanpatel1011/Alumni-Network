# Alumni-Network
using Java servlet, Jsp, Ajax, Jquary, SQL

https://netwrk.herokuapp.com/

## Database configuration

Set these environment variables for deployments:

- `DB_URL`: MySQL JDBC URL, for example `jdbc:mysql://host:3306/database`
- `DB_USERNAME`: database username
- `DB_PASSWORD`: database password

The connection also recognizes Heroku-style `JDBC_DATABASE_URL`,
`JDBC_DATABASE_USERNAME`, and `JDBC_DATABASE_PASSWORD` variables. When no
variables are configured, it uses `jdbc:mysql://localhost:3306/aumninw` with
the local `root` user and an empty password.

For local use, create the git-ignored `config/database.properties` file:

```properties
db.url=jdbc:mysql://host:3306/database
db.username=database-user
db.password=database-password
```
