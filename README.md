# ManyToMany-Mapping-Ai

A collection of Java Hibernate projects demonstrating the implementation of **Many-to-Many relationships** using Hibernate ORM and JPA annotations. This repository focuses on creating and managing complex relationships between entities through join tables, using practical examples built with a Student Management System.

---

## 📂 Repository Structure

```
ManyToMany-Mapping-Ai/
│
├── ManyToMany-Mapping/
├── Student-Many-To-Many-Task/
│
├── ManyToMany-Mapping-Output.txt
├── ManyToMany-Mapping-output1.png
├── ManyToMany-Mapping-output2.png
└── ManyToMany-Mapping-output3.png
```

---

## 📚 Projects Included

### 1. ManyToMany-Mapping

A Hibernate project demonstrating the fundamentals of **Many-to-Many entity relationships** using annotations and join tables.

**Features:**

- Many-to-Many Mapping
- Join Table Configuration
- CRUD Operations
- Hibernate Session Management
- Transaction Management
- MySQL Integration

---

### 2. Student-Many-To-Many-Task

A console-based Student Management System showcasing **Many-to-Many relationships** between entities.

Examples include:

- Multiple Students ↔ Multiple Courses
- Multiple Employees ↔ Multiple Projects
- Multiple Authors ↔ Multiple Books

*(The exact entities depend on the implementation in this project.)*

**Features:**

- Add Students
- Add Courses
- Associate Students with Multiple Courses
- Fetch Related Data
- Update Entity Relationships
- Delete Records
- Transaction Management
- Cascade Operations
- Hibernate Session Handling

---

# ✨ Features

- Many-to-Many Relationship Mapping
- Bidirectional Entity Mapping
- Join Table Management
- CRUD Operations
- Entity Associations
- Cascade Operations
- Lazy & Eager Fetching
- Annotation-Based Configuration
- Console-Based Application
- MySQL Database Integration

---

# 🛠 Technologies Used

- Java
- Hibernate ORM
- Jakarta Persistence API (JPA)
- MySQL
- Maven
- Eclipse IDE / IntelliJ IDEA
- Git
- GitHub

---

# 📋 Requirements

Before running the projects, install:

- JDK 17 or above
- MySQL Server
- MySQL Workbench (Optional)
- Maven
- Eclipse IDE or IntelliJ IDEA

---

# ⚙ Database Configuration

Configure your database credentials inside **hibernate.cfg.xml** or **hibernate.properties**.

Example:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/your_database
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    your_password
</property>
```

Ensure that:

- MySQL Server is running.
- The required database has been created.
- Hibernate is configured correctly.
- Tables are generated automatically or created manually.

---

# ▶ Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/ManyToMany-Mapping-Ai.git
```

### 2. Open the project

Import the project into Eclipse or IntelliJ IDEA.

### 3. Configure the database

Update the database credentials in the Hibernate configuration file.

### 4. Build the project

Using Maven:

```bash
mvn clean install
```

### 5. Run the Main Class

Execute the application's main class to start the console application.

---

# 📖 Hibernate Concepts Covered

This repository demonstrates:

- Many-to-Many Mapping
- `@ManyToMany`
- `@JoinTable`
- `@JoinColumn`
- Bidirectional Relationships
- Join Tables
- Cascade Types
- Fetch Types (Lazy & Eager)
- Entity Relationships
- Hibernate Sessions
- SessionFactory
- Transactions
- CRUD Operations
- Annotation-Based Configuration
- MySQL Integration
- Exception Handling

---

# 🎯 Learning Objectives

This repository helps learners understand:

- Many-to-Many Relationship Mapping
- Object Relational Mapping (ORM)
- Join Table Design
- Hibernate Session Lifecycle
- Cascade Operations
- Fetch Strategies
- Java Persistence API (JPA)
- Best Practices for Hibernate Development

---

# 📸 Sample Outputs

The repository includes:

- ManyToMany-Mapping-Output.txt
- ManyToMany-Mapping-output1.png
- ManyToMany-Mapping-output2.png
- ManyToMany-Mapping-output3.png

These files demonstrate the execution results and successful implementation of many-to-many mappings.

---

# 🚀 Future Improvements

Future enhancements may include:

- Composite Primary Keys
- HQL (Hibernate Query Language)
- JPQL
- Criteria API
- Pagination
- Batch Processing
- Second-Level Cache (Ehcache)
- Optimistic & Pessimistic Locking
- Spring Data JPA
- Spring Boot Integration
- REST APIs
- Hibernate Validator

---

# 🤝 Contributing

Contributions are welcome!

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push the branch.
5. Open a Pull Request.

---

# 👨‍💻 Author

**Mohammed Sulthan**

GitHub: https://github.com/MohammedSulthan07

---

# ⭐ Support

If you found this repository helpful, please consider giving it a **Star ⭐** on GitHub.

Happy Coding! 🚀
