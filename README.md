# Muhtas-2 Backend Project

![Java](https://img.shields.io/badge/Java-17-brightgreen)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.4-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8.4-blue)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

Muhtas-2 is a backend application providing core functionalities such as user management, hoax management, and file management. This application is developed using Spring Boot.

## Table of Contents

- [Setup](#setup)
  - [Requirements](#requirements)
  - [Steps](#steps)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
    - [User Management](#user-management)
    - [Hoax Management](#hoax-management)
    - [File Management](#file-management)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)

## Setup

Follow these steps to run the project on your local machine:

### Requirements

- Java 17 or higher
- Maven
- Git

### Steps

1. Clone this project:
    ```bash
    git clone https://github.com/abdullahaydogan/muhtas-2.git
    cd muhtas-2
    ```

2. Install the required dependencies:
    ```bash
    mvn install
    ```

3. Configure the database: Edit the `src/main/resources/application.properties` file to set up your database configuration.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/muhtas2
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

5. The application will be running at `http://localhost:8080` by default.

## Usage

### API Endpoints

#### User Management

- **Register User**
  - Endpoint: `POST /api/v1/users`
  - Body:
    ```json
    {
      "username": "exampleuser",
      "email": "user@example.com",
      "password": "password"
    }
    ```

- **Activate User**
  - Endpoint: `GET /api/v1/users/activate`
  - Parameters: `token`

#### Hoax Management

- **Add Hoax**
  - Endpoint: `POST /api/v1/hoaxes`
  - Body:
    ```json
    {
      "content": "This is a sample hoax content.",
      "attachmentId": "attachment_id_here"
    }
    ```

- **List Hoaxes**
  - Endpoint: `GET /api/v1/hoaxes`
  - Parameters: `page`, `size`

- **List Hoaxes by User**
  - Endpoint: `GET /api/v1/hoaxes/{username}`
  - Parameters: `page`, `size`

#### File Management

- **Upload File**
  - Endpoint: `POST /api/v1/files`
  - Body (multipart/form-data):
    ```
    file: <file>
    ```

## Technologies

The main technologies used in this project are:

- **Java 17**
- **Spring Boot**: A rapid and robust backend development platform.
- **Spring Security**: Security and authentication solutions.
- **JPA/Hibernate**: ORM tools for database operations.
- **Maven**: Project configuration and dependency management.

## Contributing

If you wish to contribute, please follow these steps:

1. Fork the project.
2. Create your feature branch (`feature/amazing-feature`).
3. Commit your changes (`git commit -am 'Add some amazing feature'`).
4. Push to the branch (`git push origin feature/amazing-feature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. For more information, see the [LICENSE](./LICENSE) file.
