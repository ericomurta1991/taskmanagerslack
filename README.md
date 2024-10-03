Task Manager with Slack Integration
This is a Spring Boot-based task management application with user and task CRUD functionalities. 
The application allows users to manage their tasks and provides integration with Slack for real-time notifications. It includes authentication via Spring Security, as well as the possibility for future extensions like Google Calendar synchronization.
The front-end uses Thymeleaf for dynamic content rendering.

#Features:
User Management: Create, read, update, and delete (CRUD) users.
Task Management: Assign tasks to users, manage task statuses, and set priorities and due dates.
Slack Integration: Receive notifications on task updates via Slack (optional configuration).
Pagination and Sorting: Pagination for user and task data retrieval.
Exception Handling: Custom error messages for resource not found and data integrity violations.

#API Endpoints:
/users : Manage users (create, update, delete, get users).
/tasks : Manage tasks for users (assign tasks, update status, set priority, and due dates).
How to Run:
Clone the repository.
Run the application using Maven or your preferred IDE.
Access the API via Postman or a browser on http://localhost:8080.
Examples:
You can use the JSON payloads below in Postman to insert data into the API. See the Inserting Data via Postman section below for examples of adding users and tasks.


#Inserting Data via Postman
The following JSON examples can be used to add users and their tasks to the API using a POST request in Postman. 
Each user can have multiple tasks, and each task contains fields like startDate, taskStatus, and taskPriority. Ensure to use the correct endpoint (/users for creating users and their associated tasks).

1) -->
  {
    "name": "Alice Smith",
    "email": "alice.smith@example.com",
    "birthday": "1985-07-22",
    "tasks": [
      {
        "title": "Prepare monthly report",
        "description": "Prepare and submit the monthly financial report",
        "startDate": "2024-10-01",
        "dueDate": "2024-10-10",
        "taskStatus": "PENDING",
        "taskPriority": "HIGH"
      },
      {
        "title": "Client meeting",
        "description": "Attend the client meeting to discuss project updates",
        "startDate": "2024-10-15",
        "dueDate": "2024-10-16",
        "taskStatus": "SCHEDULED",
        "taskPriority": "MEDIUM"
      }
    ]
  }

2) -->
  {
    "name": "Bob Johnson",
    "email": "bob.johnson@example.com",
    "birthday": "1992-03-10",
    "tasks": [
      {
        "title": "Design review",
        "description": "Review the latest design mockups with the design team",
        "startDate": "2024-10-03",
        "dueDate": "2024-10-07",
        "taskStatus": "COMPLETED",
        "taskPriority": "LOW"
      }
    ]
  }
