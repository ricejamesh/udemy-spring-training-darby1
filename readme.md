Notes:

Fully compliant JSR-303/309, not tied to ORM

http://www.hibernate.org/validator

Gradle:

```groovy
// https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
compile group: 'org.hibernate.validator', name: 'hibernate-validator', version: '6.0.14.Final'
```

---

###Docker:

docker-compose.yml

Creates two docker images, postgres 11.1 and adminer.  Postgres is postgres and adminer is a cool
little tool for connecting to your postgres database for basic maintenance.

```bash
docker-compose up
```
