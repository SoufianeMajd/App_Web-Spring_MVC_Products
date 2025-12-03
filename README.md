# 🚀 Product Manager Pro

> A sophisticated, secure, and modern Spring Boot application for efficient inventory management.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-DarkGreen?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Bootstrap 5](https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)

---

## 📖 Overview

**Product Manager Pro** is a robust web application designed to streamline product inventory tracking. Built with the power of **Spring Boot** and the elegance of **Bootstrap 5**, it offers a seamless user experience with a focus on security, performance, and modern aesthetics.

Whether you are an administrator managing stock or a user browsing the catalog, this application provides intuitive tools wrapped in a beautiful, responsive interface.

## ✨ Key Features

*   **🔐 Robust Security:** Integrated Spring Security with Role-Based Access Control (RBAC).
    *   **Admin:** Full access to Create, Read, Update, and Delete (CRUD) operations.
    *   **User:** View products and details (Permissions configurable).
*   **🎨 Modern UI/UX:**
    *   Sleek, responsive design using **Bootstrap 5**.
    *   Eye-catching gradients and glassmorphism effects.
    *   Smooth animations and transitions.
    *   Interactive **SweetAlert2** confirmation dialogs.
*   **📊 Efficient Data Handling:**
    *   Server-side **Pagination** for handling large datasets.
    *   **Case-insensitive Search** functionality to find products instantly.
    *   Dynamic "Show All" reset feature.
*   **📱 Responsive Layout:** Fully optimized for desktops, tablets, and mobile devices.

## 🛠️ Tech Stack

*   **Backend:** Java 17, Spring Boot (Web, Data JPA, Security, Validation)
*   **Frontend:** Thymeleaf, Bootstrap 5, Bootstrap Icons, Vanilla CSS, SweetAlert2
*   **Database:** H2 (In-memory for dev), MySQL (Production ready)
*   **Build Tool:** Maven

## 📸 Screenshots

| Product List | Edit Product |
|:---:|:---:|
| *List view with pagination and search* | *Modern form with validation* |
| ![List](https://via.placeholder.com/400x200?text=Product+List+View) | ![Edit](https://via.placeholder.com/400x200?text=Edit+Product+Form) |

## 🚀 Getting Started

### Prerequisites

*   **JDK 17** or higher installed.
*   **Maven** (optional, wrapper included).

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/SoufianeMajd/App_Web-Spring_MVC_Products.git
    cd App_Web-Spring_MVC_Products
    ```

2.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **Access the app:**
    Open your browser and navigate to:
    `http://localhost:8082/index`

## 🔑 Default Credentials

The application comes with pre-configured users for testing:

| Role | Username | Password |
| :--- | :--- | :--- |
| **User** | `user` | `1234` |
| **Admin** | `admin` | `1234` |

## 📂 Project Structure

```
src/main/java/net/soufiane
├── AppWebSpringMvcApplication.java  # Main entry point
├── entities                         # JPA Entities (Product)
├── repository                       # Data Access Layer
├── security                         # Security Configuration
└── web                              # MVC Controllers
```

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

---

<div align="center">
  <p>Made By Soufiane Majd</p>
</div>
