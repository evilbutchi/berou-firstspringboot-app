# First Spring Boot App — Levi G. Berou

Generated to match Spring Initializr with these exact settings:
- Spring Boot version: **3.5.5**
- Language: **Java**
- Group: `com.example`
- Group Id: `com.example.firstspringbootapp`
- Artifact Id: `demo`
- Packaging: **Jar**
- Java version: **17**
- Dependencies: **Spring Boot DevTools, Spring Web, Spring Data JPA, MySQL Driver**

## ⚠️ Important — about MySQL Driver + Spring Data JPA
Because you selected **Spring Data JPA** and **MySQL Driver**, Spring Boot will try to
connect to a real MySQL database on startup. Right now `application.properties` has the
datasource settings **commented out**, so the app will run for the basic Hello endpoint,
but if you uncomment JPA/datasource usage later, you'll need:

1. A running MySQL server (e.g. via XAMPP, MySQL Workbench, or local install)
2. A created database (e.g. `firstspringbootapp_db`)
3. Uncomment and edit these lines in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Until you need actual database features, you can leave these commented — the app will
still start fine and the `/api/main/print` endpoint will work.

## How to open in VS Code
1. Unzip this download.
2. **File > Open Folder** → select the `demo` folder.
3. Open `DemoApplication.java` under
   `src/main/java/com/example/firstspringbootapp/demo/`.
4. Click **Run** above `main`.
5. Visit: `http://localhost:8080/api/main/print`
6. You should see: **Hello, Levi Berou!**

## Push to GitHub
1. Create a new empty repo named: `berou-firstspringboot-app`
2. In a terminal at the folder containing this README (one level above `demo`):

```bash
git init
git add .
git commit -m "First Spring Boot app - Levi Berou"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/berou-firstspringboot-app.git
git push -u origin main
```

If your assignment specifically requires a `backend` folder (not `demo`) holding the
project, rename the `demo` folder to `backend` before running the git commands above.
