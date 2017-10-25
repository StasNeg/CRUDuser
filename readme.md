# User CRUD Application

Application implement CRUD operation for one table (User) with field:
 - firstName 
 - lastName
 - email
 
### Realisation

DataBase - Postgres.
First initialisations:
- initDB (resources/db) - create DB
- populateDB (resources/db) - add first data into DB

### First launch:

Connection property:
database.url=jdbc:postgresql://localhost:5432/*_postgres_*(DataBase name)
database.username = **_user_** (userName) 
database.password = **_password_** (password)
database.init=**_true_**  if you don't want init use: **_false_**

launch path: path:\localhost:8080\ 

### Constrains

- cannot input User without firstName (compare to empty field)
- cannot input User without lastName (compare to empty field)
- cannot input two User with the same email (compare to unique field)

### Tests

- test coverage all Repository methods. 