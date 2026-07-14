# Book Store API Assignment

This is the Java Spring Boot RESTful API project for the Ejada bookstore Internship Task number 1. It implements core CRUD operations, relational data mapping between Books and Authors, global exception handling, and includes Swagger for interactive API documentation.

## Prerequisites

To run this project locally, you will need:

* **Java 21** or higher.
* **Docker** (to run the MS SQL Server database via Docker Compose).
* **Maven** (included via the Maven Wrapper).

## How to Run the Application

1. **Start the Database**
The application relies on Microsoft SQL Server. A `compose.yaml` file is provided in the root directory. Start it by running:

```bash
   docker-compose up -d
   ```

2. **Run the Spring Boot Application**
You can run the application directly using the included Maven wrapper. Open a terminal in the root of the project and execute:

```bash
   # On Windows
   .\\mvnw.cmd spring-boot:run

   # On macOS/Linux
   ./mvnw spring-boot:run
   ```

3. **Access the API Documentation**
Once the application is running (by default on port `8080`), you can access the Swagger UI to view and interact with the endpoints:

   * **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Endpoints Overview

### Authors

* `POST /api/authors` - Create a new author.
* `GET /api/authors` - Retrieve a list of all authors.
* `GET /api/authors/{id}` - Retrieve a specific author by ID.
* `PUT /api/authors/{id}` - Update an existing author.
* `DELETE /api/authors/{id}` - Delete an author.

### Books

* `POST /api/books` - Create a new book (requires a valid `authorId` in the request body).
* `GET /api/books` - Retrieve all books.
* `GET /api/books/isbn/{isbn}` - Retrieve a specific book by its ISBN.
* `PUT /api/books/{id}` - Update an existing book.
* `DELETE /api/books/{id}` - Delete a book.

