<h1 align="center" id="title">Search assessment</h1>

<p id="description">Search Assessment is a Spring Boot application designed to help users search for manufacturers based on customized requirements. It includes features such as supplier management user authentication and a web interface for interacting with the application.</p>

  
  
<h2>🧐 Features</h2>

Here're some of the project's best features:

*   Supplier Management: Create edit and delete supplier records.
*   Search Functionality: Search suppliers based on various criteria.
*   User Authentication: Register log in and manage users.
*   Web Interface: A user-friendly web interface for interacting with the application.

<h2>🛠️ Installation Steps:</h2>

<p>1. Clone the Repository</p>

```
git clone https://github.com/simrabhombal/search-assessment.git
```

<p>2. Navigate to the Project Directory</p>

```
cd search-assessment
```

<p>3. Configure Database Update src/main/resources/application.properties with your MySQL database configuration:</p>

```
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase spring.datasource.username=yourusername spring.datasource.password=yourpassword
```

<p>4. Build the Project</p>

```
mvn clean install
```

<p>5. Run the Application The application will start on http://localhost:8080.</p>

```
mvn spring-boot:run
```

<h2>💖Like my work?</h2>

API Endpoints GET /api/supplier/new\_supplier - Show the form to create a new supplier. POST /save - Save a new supplier. GET /api/supplier/edit/{supplier\_id} - Show the form to edit an existing supplier. POST /api/supplier/delete/{supplier\_id} - Delete a supplier. POST /login - Authenticate users.
