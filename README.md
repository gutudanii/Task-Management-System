# Task Management Application

This is a Java Spring Boot application that allows users to manage their tasks. Users can create tasks, mark them as complete or incomplete, edit task descriptions and due dates, and delete tasks. The application also includes user authentication and security features to protect user data.

## Installation

To install and run the application, follow these steps:

1. Clone the repository to your local machine:

```bash
git clone https://github.com/gutudanii/Task-Management-System.git
```

2. Navigate to the project directory:

```bash
cd task-management-System
```

3. Open the `application.properties` file located in `src/main/resources` and configure the database connection settings. Replace `<username>` and `<password>` with your own MySQL database username and password, also don't forget to create database with "task_management":

```
spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=sqlusers
spring.datasource.password=gutu
spring.jpa.hibernate.ddl-auto=update
```

4. Build the project using Maven:

```bash
mvn clean package
```

5. Run the application:

```bash
java -jar target/task-management-app.jar
```

```bash
mvn spring-boot:run
```

6. Open your web browser and go to http://localhost:8080 to access the application.

## User Authentication

To create a new user account, click the "Sign Up" link on the login page and enter your name, email address, username ,and password. To log in to an existing account, enter your username and password on the login page.

## Task Creation

To create a new task, click the "Add Task" button on the dashboard and enter the task description and due date. Click "Save" to save the new task to your task list.

## Task List

To view your task list, click the "Tasks" button on the dashboard. The task list will display all tasks associated with your user account, along with their descriptions and statuses (complete or incomplete). To filter tasks by status, click the "Filter" button and select "Completed" or "Incomplete".

## Task Updates

To mark a task as complete or incomplete, click the checkbox next to the task in your task list. To edit the task description or due date, click the "Edit" button next to the task and make your changes in the form that appears. Click "Save" to save your changes.

## Task Deletion

To delete a task from your task list, click the "Delete" button next to the task. The task will be permanently removed from your task list.

## Database Configuration (Example)

The application uses a MySQL database to store user and task data. To configure the database connection settings, open the `application.properties` file located in `src/main/resources` and replace `<username>` and `<password>` with your own MySQL database username and password:

```
spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```

Make sure that you have created a new database schema called `task_management` in your MySQL server.

## Security

The application uses Spring Security to provide user authentication and authorization. User passwords are encrypted using BCrypt. The application also includes CSRF protection to prevent cross-site request forgery attacks.

## Screenshots

Here are some screenshots of the Task Management application:

![Dashboard](/screenshot/dash.png)

![Task List](/screenshots/task-list.png)

![Edit Task](/screenshots/edit-task.png)

![Sign Up](/screenshots/sign-up.png)

![Login](/screenshots/login.png)

![Add Task](/screenshots/add-task.png)

## Technologies Used

The following technologies were used to build this application:

- Java Spring Boot
- Thymeleaf template engine
- MySQL database
- Spring Security
- BCrypt password encryption
- Maven build tool

## Contributing

If you would like to contribute to the development of this application, please follow these steps:

1. Fork the repository to your own GitHub account.

2. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/gutudanii/Task-Management-System.git
   ```

3. Create a new branch for your changes:

   ```bash
   git checkout -b my-new-feature
   ```

4. Make your changes and commit them:

   ```bash
   git commit -am 'Add some feature'
   ```

5. Push your changes to your forked repository:

   ```bash
   git push origin my-new-feature
   ```

6. Create a new pull request from your forked repository to the original repository.

## License

This application is licensed under the MIT License. See the `LICENSE` file for details.
