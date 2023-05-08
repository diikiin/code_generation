# Code Generation

This is project for generation unique code. The project use
SpringBoot 3, postgresql as database and flyway for migrations.

## Database running

To run the project, you need a postgresql database. To do this,
you can enter the following command in the terminal:

```bash
docker-compose -f docker-compose-postgres.yml up -d
```

To check state:

```bash
docker-compose -f docker-compose-postgres.yml ps
```

Or you can use another empty database. To do this, you need to
add environment variables before running:

```
PORT                -   port on which the project is running, default: 8080
DATASOURCE_USERNAME -   database user, default: postgres
DATASOURCE_PASSWORD -   database password, default: root
DATASOURCE_URL      -   database url, default: jdbc:postgresql://localhost:5432/code_generation
```

## Project running

After database is run, you can launch the project.

For generation unique code you can run api in this file:  
[get_code.rest](src/main/resources/get_code.rest)

Or go to this link:  
http://localhost:8080/api/counter