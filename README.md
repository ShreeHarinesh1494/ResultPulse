# 📊 ResultPulse – Result Publishing & Analysis Platform

**ResultPulse** is a web-based academic result management system that simplifies and digitizes the entire process of publishing results and analyzing student performance. Designed with both administrative and student perspectives in mind, this full-stack application ensures efficient result handling and enhances transparency and accessibility.

---

## 🧠 Project Purpose

The primary goal of ResultPulse is to **strengthen backend development skills using Spring Boot**, while implementing a structured and functional frontend with React.js. The project also introduces secure OTP verification, dynamic data flow across entities like students, departments, and courses, and visual performance analysis.

---

## 🛠 Tech Stack

| Layer        | Technology            |
|--------------|------------------------|
| Frontend     | React.js, Tailwind CSS |
| Backend      | Spring Boot (Java)     |
| Database     | MySQL                  |
| Visualization| Lucid Charts           |
| API Testing  | Postman                |
| Mail Service | JavaMail (SMTP)        |

---

## 🔁 Complete Workflow Overview

### 🔐 Admin Flow
1. **Admin Registration**  
   - Inputs: Name, Email, Password  
   - Registers and stores admin securely in the database.

2. **Admin Login**
   - Step 1: Enter Email & Password  
   - Step 2: On correct credentials, system generates an OTP and sends it to registered email.

3. **OTP Verification**
   - Admin enters the OTP.
   - If correct, navigation proceeds to Admin Dashboard.

4. **Admin Dashboard Functionalities**
   - All the below modules are accessible only after successful authentication:

---

## 🧩 Core Modules

### 1️⃣ Department Management
- Add Department Name.
- Department ID is generated automatically.
- Department data acts as a backbone for student and course mappings.

### 2️⃣ Student Management
- Add Student with:
  - Name
  - Roll Number
  - Email
  - Password
  - Joining Year
  - Department ID (dropdown fetched from DB)

### 3️⃣ Course Management
- Add Courses with:
  - Course Name
  - Course Code
  - Credit Points
  - Semester

### 4️⃣ Topic Creation
- Admin creates Topics (used to group semester data).
- Each topic acts as an identifier to associate sets of course results.

### 5️⃣ Entering Student Marks
- Admin manually enters:
  - Roll No, Name, Joining Year
  - GPA, Course ID, Course Name, Credits, Acquired Credits
  - Course Remarks, Overall Remarks

---

## 🎓 Student Portal

### 1. Student Login
- Students log in using **Email** and **Password**.

### 2. Fetch Academic Records
- After login, students input their **Roll No** and **Name** to fetch their academic records.

### 3. View Marks & Performance Analytics
- All marks are displayed in tabular format.
- Lucid Charts visualize GPA, credits, and course performance across semesters.

### 4. PDF Report Download
- Option to **download a complete report** of student performance as a PDF.

---

## 🧠 Features Highlight

- 🔐 **Two-Step Authentication** for Admins via Email OTP
- 📂 Modular Entity Creation: Departments, Courses, Topics, Students
- 📈 Real-Time Result Visualization with Lucid Charts
- 📥 One-Click **PDF Export** for Students
- 🔄 Frontend-Backend API Integration using Axios
- ✨ Clean, functional UI built with React
- 📧 Email Service Integration for OTP

---

## 📦 Postman API Documentation

- All endpoints are tested and exported using Postman.
- The complete `.json` collection file is attached in the repo.
- You can import it into Postman and try out:
  - Admin registration
  - Login & OTP endpoints
  - CRUD operations for students, departments, topics, and courses
  - Student result endpoints

---

## 🚧 Planned Improvements

| Area             | Goal                                                                 |
|------------------|----------------------------------------------------------------------|
| 🔐 Security       | Integrate **JWT Token Authentication** and **Spring Security**       |
| 🧩 Architecture   | Migrate from monolithic to **microservices**                         |
| 💅 Frontend       | Improve UI/UX with enhanced **design patterns** and **libraries**    |
| ⚙️ State Handling | Use tools like Redux or React Context for efficient state management |
| 📄 Reports        | Generate dynamic PDF reports using advanced reporting libraries      |

---

## Screenshots

### Admin Login

---

## 🎯 What I Learned

- ✔ Deep understanding of **Spring Boot operations**, data flow, and controller-service-repository design
- ✔ Implemented **OTP-based email verification system**
- ✔ Learned how to structure **multi-entity relationships** (Student → Department → Courses)
- ✔ Gained working knowledge of **React** and API integration
- ✔ Understood backend-driven project development with frontend support

---

## ⚠️ Disclaimer

> This project is primarily backend-focused and was built to **enhance Spring Boot skills**. The frontend is basic but fully functional to test and showcase backend functionality. UI/UX improvements are planned in future iterations.

---

## 📌 Getting Started

### 🔧 Installation Steps

```bash
# Clone the repo
git clone https://github.com/your-username/resultpulse.git

# Backend Setup
cd backend
Import the project into your favorite Java IDE (IntelliJ, Eclipse)
Configure MySQL in `application.properties`
Run the Spring Boot app

# Frontend Setup
cd frontend
npm install
npm start
