# Banking Management System

A robust Spring Boot application designed to manage bank accounts and process transactions efficiently.

## 🚀 Features

- **Account Management**: Create new bank accounts with initial balances.
- **Transaction Processing**: Perform deposits and withdrawals with real-time balance updates.
- **Balance Inquiry**: Retrieve current account balances instantly.
- **Data Persistence**: Utilizes H2 in-memory database for fast and reliable data storage during runtime.

## 🛠️ Technologies Used

- **Java 21**: The latest LTS version of Java for modern language features.
- **Spring Boot 3.4.0**: Framework for building production-ready applications.
- **Spring Data JPA**: For easy database interaction.
- **H2 Database**: In-memory database for development and testing.
- **Lombok**: To reduce boilerplate code.
- **Maven**: Dependency management and build tool.

## 📋 Getting Started

### Prerequisites

- Java Development Kit (JDK) 21
- Maven 3.6+

### Installation

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd banking-system
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

### Running the Application

Run the application using the Maven plugin:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## 🔌 API Documentation

### 1. Create Account

Creates a new bank account for a customer.

- **URL**: `/api/banking/account`
- **Method**: `POST`
- **Query Parameters**:
    - `initialBalance` (BigDecimal): The starting balance for the account.
- **Request Body** (JSON):
    ```json
    {
      "name": "John Doe",
      "email": "john@example.com"
    }
    ```
- **Response**: Returns the created `Account` object.

### 2. Perform Transaction

Performs a deposit or withdrawal on an existing account.

- **URL**: `/api/banking/transaction`
- **Method**: `POST`
- **Request Body** (JSON):
    ```json
    {
      "accountId": 1,
      "amount": 100.00,
      "type": "DEPOSIT" 
    }
    ```
    *Note: `type` can be `DEPOSIT` or `WITHDRAWAL`.*

- **Response**: Returns the processed `Transaction` object.

### 3. Get Balance

Retrieves the current balance of a specific account.

- **URL**: `/api/banking/account/{id}/balance`
- **Method**: `GET`
- **Path Variables**:
    - `id` (Long): The ID of the account.
- **Response**: Returns the current balance as a number.

## 🗄️ Database Access

The application uses an H2 in-memory database. You can access the H2 Console at:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb` (Default)
- **User Name**: `sa`
- **Password**: (Empty)

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit a pull request.
