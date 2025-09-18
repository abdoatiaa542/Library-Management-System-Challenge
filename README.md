# 📚 Library Management System (LMS)

## 📖 Overview
This project is a **Library Management System (LMS)** built with **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
It allows library staff to manage books, members, borrowing and return transactions, and provides role-based access control for different types of system users.

---

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security (JWT for authentication & authorization)**
- **MySQL**
- **Lombok**
- **Maven**

---

## 🗂️ ERD (Entity Relationship Diagram)
![WhatsApp Image 2025-09-19 at 01 43 02_37a24183](https://github.com/user-attachments/assets/2aabeed4-86fa-4bd3-b440-aa5cc65ce749)


![ERD Diagram]()

---

## 🗄️ Database Schema & Sample Data
The database schema and sample data are provided in the `sql/` folder.  
You can run the following to create the database:

```sql
CREATE DATABASE IF NOT EXISTS lms;
USE lms;
