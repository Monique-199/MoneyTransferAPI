# MoneyTransferAPI
Overview

This project is a REST API developed using Spring Boot to implement a simple money transfer feature between accounts. It includes functionality to create accounts, retrieve account information, and transfer money between accounts, while enforcing constraints to ensure data integrity.
Features

Create a new account with an initial balance.

Retrieve account information by account ID.

Transfer money between accounts.

Constraints:

An account cannot have a negative balance.

The transfer amount must be greater than zero.

Transfers fail if the source account does not have sufficient funds.

In-memory database for simplicity (H2 Database).

Basic validation and error handling.
Technologies Used

Java

Spring Boot (REST API framework)

H2 Database (in-memory database)

Jakarta Bean Validation (for validation)

Postman (for API testing)
Prerequisites

To run this project, ensure you have the following installed:

Java 17 or higher

Maven

Postman (optional, for testing the API)
Setup Instructions

1. Clone the Repository
   https://github.com/Monique-199/MoneyTransferAPI.git
   cd MoneyTransferAPI


2.  Build the Project

Use Maven to build the project.
mvn clean install

3. Run the Application.
   Start the application by running the MoneyTransferApplication class or using Maven:
   mvn spring-boot:run

 4.  Access the Application

The API will be available at http://localhost:8080

5.  H2 Database Console

You can access the H2 in-memory database console at http://localhost:8080/h2-console
Use the following credentials:

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: password

API Endpoints

1. Create Account

POST /accounts

Description: Creates a new account with an initial balance.

Query Parameter

initialBalance (required): The initial balance for the account.

Example Request 
POST http://localhost:8080/accounts?initialBalance=1000

Example Response 
{
    "id": 1,
    "balance": 1000.0
}

2. Get Account Details

GET /accounts/{id}

Description: Retrieves account details by account ID.

Path Parameter

id (required): The ID of the account.

Example Request GET http://localhost:8080/accounts/1
{
    "id": 1,
    "balance": 1000.0
}
3. Transfer Money

POST /transfers

Description: Transfers money from one account to another.

Request Body 
{
    "sourceAccountId": 1,
    "targetAccountId": 2,
    "amount": 500
}
Example request : POST http://localhost:8080/transfers
Example response: 
{
    "message": "Transfer successful"
}

Validation & Error Handling

Common Scenarios:

1. Negative Balance or Invalid Initial Balance

Request POST http://localhost:8080/accounts?initialBalance=-100
{
    "balance": "must be greater than or equal to 0"
}

2. Insufficient Funds

Request {
    "sourceAccountId": 1,
    "targetAccountId": 2,
    "amount": 2000
}
Response 
{
    "message": "Insufficient balance in source account"
}
3. Invalid Transfer Amount

Request: {
    "sourceAccountId": 1,
    "targetAccountId": 2,
    "amount": -50
}

Response {
    "message": "Transfer amount must be greater than zero"
}

Testing with Postman

Import the endpoints into Postman.

Test the endpoints using the examples provided in the "API Endpoints" section.

Verify the responses for successful and edge-case scenarios.

Author : Monicah Nyakundi.
