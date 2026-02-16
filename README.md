# TaskSync - Real-Time Task Collaboration Platform

TaskSync is a lightweight **Trello/Notion-like real-time task collaboration platform** built as a Full Stack Internship assignment for Hintro.  
It allows users to create boards, lists, tasks, assign members, and see real-time updates.

---

## 📝 Features

- User authentication (signup/login)  
- Create Boards with multiple Lists  
- Add, update, and delete Tasks inside lists  
- Drag and drop tasks across lists (planned for future)  
- Assign users to tasks  
- Real-time updates across multiple users (via WebSocket)  
- Activity history tracking  
- Pagination and search functionality  

---

## 💻 Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA  
- **Database:** MySQL  
- **Frontend:** Thymeleaf templates (no React)  
- **Real-time communication:** WebSocket (SimpMessagingTemplate)  
- **Build:** Maven  
- **Version Control:** Git + GitHub  

---

## 🛠 Database Schema

**Boards Table**  

| Field | Type | Key |
|-------|------|-----|
| id    | BIGINT | PK |
| name  | VARCHAR(255) |  |

**Task Lists Table**  

| Field    | Type | Key |
|----------|------|-----|
| id       | BIGINT | PK |
| name     | VARCHAR(255) | |
| board_id | BIGINT | FK |

**Tasks Table**  

| Field        | Type | Key |
|--------------|------|-----|
| id           | BIGINT | PK |
| title        | VARCHAR(255) | |
| task_list_id | BIGINT | FK |

---

## 🚀 Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/Chandu078997/hintro-fullstack-assignment.git
cd hintro-fullstack-assignment
