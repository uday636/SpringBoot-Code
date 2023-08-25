# SpringBoot-Code

To start, just run the Spring Boot application. After it's running, open your web browser and go to this address: http://localhost:8080/swagger-ui/index.html. This will show you the user interface for the API.

We're using a tool called Flyway to automatically set up the database for you. It will create a table and add 2 initial records.

If you want to add more records to the database, here's how:

Go to the folder resources/db/migrations in your project.
Make a copy of any existing file there.

When renaming the new file, make sure it starts with 'V', followed by a sequential number, and then two underscores (__), before adding the rest of the file name. For example, if the last existing file is named V3__Old_File, your new file should be named something like V4__New_File.


In this new file, write the SQL queries to insert the records you want.
Remember, the number after V should be in sequence and unique so that Flyway knows the correct order to run the files in.

