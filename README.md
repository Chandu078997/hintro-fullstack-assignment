# TaskSync - Real-Time Task Collaboration Platform



TaskSync is a lightweight Trello/Notion-style real-time task collaboration platform.  
It allows users to create boards, lists, tasks, assign users, and view updates in real-time.

---

## 🛠 Features

- **User Authentication:** Signup and login functionality.
- **Boards & Lists:** Create multiple boards with lists (To Do, In Progress, Done).
- **Task Management:** Add, update, delete tasks inside lists.
- **Assign Users:** Assign tasks to specific users (future extension possible).
- **Real-Time Updates:** Tasks updates reflect immediately across users.
- **Activity Tracking:** Track task history and changes.
- **Clean UI:** Interactive and responsive interface.

---

## 📁 Screenshots

**Dashboard**  
![Dashboard](dashboard.png)

**Board View**  
![Board](screenshots/Screenshot-from-2026-02-16-11-22-52.png)

**Login Page**  
![Login](screenshots/Screenshot-from-2026-02-16-11-22-57.png)

**Register Page**  
![Register](screenshots/Screenshot-from-2026-02-16-11-23-11.png)

---

## 🖥 Technical Stack

- **Frontend:** Thymeleaf templates (HTML/CSS) within Spring Boot  
- **Backend:** Java Spring Boot REST APIs  
- **Database:** MySQL  
- **Real-Time Communication:** Spring WebSockets (STOMP)  
- **Build Tool:** Maven  
- **Version Control:** Git & GitHub  

---

## 🗂 Database Schema

**Tables:**  

**boards**  
| id | name |  

**task_lists**  
| id | name | board_id |  

**tasks**  
| id | title | task_list_id |  

---

## 🔗 API Endpoints

- **Boards**
  - `GET /dashboard` - Show all boards
  - `POST /board/create` - Create new board
  - `POST /board/delete/{boardId}` - Delete board

- **Lists**
  - `POST /board/{boardId}/list/create` - Create list in a board
  - `POST /board/{boardId}/list/delete/{listId}` - Delete list

- **Tasks**
  - `POST /board/{boardId}/task/create` - Create task
  - `POST /board/{boardId}/task/delete/{taskId}` - Delete task
  - `POST /board/{boardId}/task/edit/{taskId}` - Edit task title

- **Auth**
  - `POST /register` - User registration
  - `POST /login` - User login

---

## 🚀 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Chandu078997/hintro-fullstack-assignment.git
   cd hintro-fullstack-assignment
