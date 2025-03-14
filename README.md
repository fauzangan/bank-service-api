## Bank Service Api ( Test Case )
This project implements retrieve balance and withdrawal using Spring Boot.

## Prerequisites
- Java 17
- Maven 
- PostgreSQL

## Setup
1. Create a PostgreSQL database name `bank_service_api`
   ```SQL
   CREATE DATABASE bank_service_api
   ```
2. Configure the database connection in `src/main/resources/application.properties`
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/bank_service_api
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. In this Project has already have **Database Seeder** but if you want to make your own data, you can copy this query:
   ```SQL
   INSERT INTO users (username, email, created_at) VALUES 
   ('user1', 'user1@example.com', NOW()),
   ('user2', 'user2@example.com', NOW()),
   ('user3', 'user3@example.com', NOW());
   
   INSERT INTO wallets (user_id, pin, balance, last_updated) VALUES 
   (1, '1234', 1000.00, NOW()),
   (2, '5678', 500.00, NOW()),
   (3, '9999', 750.00, NOW());
   ```

## Running the Application
You can running the project through Intellij IDEA or 

Using Maven command:

1. Build the project:
   ```
   mvn clean 
   ```
2. Run the application:
   ```
   mvn spring-boot:run
   ```

## API Endpoints

- #### Retrieve User Balance Wallet
  ```
  GET /api/wallet/balance/{user_id}
  ```
  Response:
  ```
  {
    "message": "Success get balance",
    "status": "OK",
    "data": {
        "wallet_id": 1,
        "balance": 460.00
    }
  }
  ```
- #### Withdrawal User Wallet Account
  ```
  POST /api/wallet/withdraw
  ```
  Request :
  ```
  {
    "user_id" : 1,
    "pin" : "1234",
    "amount" : 1
  }
  ```
  Response :
  ```
  {
    "message": "Success withdraw account",
    "status": "OK",
    "data": {
        "transaction_id": 5,
        "user_id": 1,
        "amount": 1,
        "updated_balance": 459.00,
        "timestamp": "2025-03-14T07:40:33.8020542"
    }
  }
  ```