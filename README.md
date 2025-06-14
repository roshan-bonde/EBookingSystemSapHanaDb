## Tech Stack: Java, Spring Boot, JPA, Postres(Database), Maven(Build Tool)

## Project Overview

EBookingSystem is a Java Spring Boot application designed to manage bookings efficiently. It leverages JPA for ORM, PostgreSQL as the database, and Maven for build automation. The project provides RESTful APIs for booking management and integrates Swagger UI for API documentation and testing.

## Features

- User registration and authentication
- Booking creation, update, and cancellation
- Search and filter bookings
- Role-based access control (admin/user)
- API documentation with Swagger UI
- Error handling and validation

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- PostgreSQL 12+

### Setup Instructions

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/EBookingSystem.git
    cd EBookingSystem
    ```

2. **Configure the database:**
    - Update `src/main/resources/application.properties` with your PostgreSQL credentials.

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

5. **Access Swagger UI:**
    - Open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) in your browser.

## API Endpoints

Refer to Swagger UI for detailed API documentation and testing.

## Folder Structure

```
EBookingSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.
