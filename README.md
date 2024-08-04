# Hoaxify Backend Project

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
    spring.datasource.url=jdbc:mysql://localhost:3306/****
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
# Hoaxify Frontend Project

![React](https://img.shields.io/badge/React-17.0.2-brightgreen)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-blue)
![Material-UI](https://img.shields.io/badge/Material%20UI-5.2.0-blue)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

Hoaxify Frontend is a React-based web application designed to provide an intuitive and interactive user experience for the Hoaxify platform. The project integrates seamlessly with backend services and utilizes modern frontend technologies to deliver a responsive and user-friendly interface.

## Table of Contents

- [Setup](#setup)
  - [Requirements](#requirements)
  - [Steps](#steps)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [Development Mode](#development-mode)
  - [Building for Production](#building-for-production)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)

## Setup

To set up the project on your local machine, follow these steps:

### Requirements

- **Node.js**: Version 14.x or higher. Node.js is a JavaScript runtime built on Chrome's V8 engine.
- **npm or Yarn**: Package managers for JavaScript. npm comes bundled with Node.js, but you can also use Yarn if preferred.
- **Git**: Version control system for cloning the repository.

### Steps

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/abdullahaydogan/Hoaxify.git
    cd Hoaxify/frontend
    ```

2. **Install Dependencies**:
    Install the required packages listed in `package.json` using npm:
    ```bash
    npm install
    ```
    Alternatively, if you're using Yarn, you can install dependencies with:
    ```bash
    yarn install
    ```

3. **Configure Environment Variables**:
    Create a `.env` file in the root of the `frontend` directory and add necessary environment variables:
    ```bash
    REACT_APP_API_URL=http://localhost:8080/api
    ```
    Adjust the `REACT_APP_API_URL` to point to your backend API.

4. **Start the Development Server**:
    Launch the application in development mode, which enables hot reloading and source map support:
    ```bash
    npm start
    ```
    This command starts the development server and opens the application in your default web browser. Any changes you make to the source code will automatically reload the page. If the application does not open automatically, navigate to `http://localhost:3000`.

5. **Open the Application**:
    The application will be accessible at `http://localhost:3000` in your web browser.

## Usage

### Running the Application

To run the application in development mode, use the following command:
```bash
npm start

