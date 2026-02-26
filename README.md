Sahyadri-Vantage-Luxe 🏔️
Sahyadri-Vantage-Luxe is a full-stack Java web application designed for high-end resort management. It provides a secure, immersive booking experience for six distinct luxury accommodations nestled in the Western Ghats.

##  Core Features
User Authentication: Secure Sign-Up and Login modules powered by Java Servlets and MySQL.

Dynamic Booking Engine: An intelligent routing system that directs users to unique, high-fidelity room pages based on their reservation choice.

Stateful Sessions: Implements HttpSession tracking to manage user stays and a dedicated Logout mechanism for server-side security.

Relational Database: Robust data persistence using JDBC to manage user credentials and booking transactions.

##  Tech Stack
Backend: Java (JDK 21), Jakarta Servlet API.

Frontend: HTML5, CSS3 (Modern Dark Theme), Google Fonts.

Database: MySQL 8.0.

Server: Apache Tomcat 10.1.

Tools: Eclipse IDE for Enterprise Java.

## Project Structure
Plaintext
src/main/java/com/Servlet_Practice02/  <-- Backend Servlets (Login, SignUp, Confirm, Logout)
src/main/webapp/                       <-- Frontend (8 HTML files for UI & detail pages)
src/main/webapp/WEB-INF/web.xml        <-- Deployment Descriptor
src/main/webapp/WEB-INF/lib/           <-- Database Drivers (mysql-connector-j)
## ⚙️ Setup & Installation
1. Database Setup
Create your local database in MySQL and run the following commands:

SQL
CREATE DATABASE ResortManagementDB;
USE ResortManagementDB;

CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(100),
    check_in DATE,
    check_out DATE
);
2. Eclipse Configuration
Import the project as a Dynamic Web Project.

In Project Properties > Java Build Path, add the mysql-connector-j-9.3.0.jar to your Classpath.

In Deployment Assembly, ensure the MySQL JAR is included to prevent ClassNotFoundException.

Clean the project via Project > Clean before running.

3. Deployment
Right-click the project and select Run On Server.

Configure Tomcat v10.1 and visit http://localhost:8082/Servlet_Practive02/Login.html.
