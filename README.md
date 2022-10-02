# Virtual-Wallet-Master

## About

## Problem Statement
Virtual Wallet to track user's transaction account .
At a high level the library needs to solve the following business needs
* Track a user’s account balance
* Manage account transactions in the form of debits (withdrawals) and credits (deposits).
* Keep a history of last N transactions.


## I have run the project using Following steps
```
1. Build the project using maven---
$ mvn clean install
2.run the project---
$ mvn spring-boot:run

* Now navigate to http://localhost:8080/ .

## Functionality

Since project uses *H2* in-memory database, some sample data has already been provided to get started with. 

*  Navigate to `http://localhost:8080/h2-console` .You would see h2 console :

**Make sure**  that you use `jdbc:h2:mem:testdb` as JDBC URL. Click connect.

I have made following api's below-

* ### a) Add an account to user 4 (Dan in this case) :

Provided endpoint : `http://localhost:8080/api/account/`

use post request as :
```{JSON}
{
	"balance":4000,
	"accountHolder" : {
		"userId": 4,
		"fname" : "Dan",
		"lname":"Brown",
		"email" :"dan@brown"
	}
}
```

We can now check that Account 3001 is now associated with userId 4 and no wallet:
Response:-{
    "accountNumber": 3002,
    "balance": 4000.0,
    "accountHolder": {
        "userId": 4,
        "fname": "Dan",
        "lname": "Brown",
        "email": "dan@brown"
    },
    "bankTransactions": null
}

* ### b) Create a new wallet for a user :

I am assuming a user can have multiple accounts.

Provided endpoint for creating new wallet :
```
http://localhost:8080/api/wallet/{customerId}
```

I used `Postman` for this, since it provides easy interface for sending post request.

e.g. Lets create a wallet for ** Dan Brown** our 4th user in the database. We would **post** request to `http://localhost:8080/api/wallet/4` using below JSON format :

You can now check, that wallet 4 is now associated with user 4 :
Response->{
    "status": "200",
    "description": "Wallet created successfully!",
    "data": {
        "walletId": 4,
        "accountsInWallet": [
            {
                "accountNumber": 3001,
                "balance": 4000.0,
                "accountHolder": {
                    "userId": 4,
                    "fname": "Dan",
                    "lname": "Brown",
                    "email": "dan@brown"
                },
                "bankTransactions": []
            },
            {
                "accountNumber": 3002,
                "balance": 4000.0,
                "accountHolder": {
                    "userId": 4,
                    "fname": "Dan",
                    "lname": "Brown",
                    "email": "dan@brown"
                },
                "bankTransactions": []
            }
        ],
        "walletOfCustomer": {
            "userId": 4,
            "fname": "Dan",
            "lname": "Brown",
            "email": "dan@brown"
        }
    }
}

* ### c) Return current account balance :

Provided endpoint : `http://localhost:8080/api/wallet/{walletId}/account/{accountId}/balance`.

e.g Let us check balance for User 1 and associated account number 1000. We would use a **GET** request to `http://localhost:8080/api/wallet/1/account/1000/balance`. Below is the output from postman :
Response->
{
    "status": "200",
    "description": "Balance fetched successfully!!",
    "data": 900.0
}


The backend JAVA code checks for all validation. If the accountId is not associated with provided walledId, an exception is thrown.

* ### d) Perform a withdrawal transaction on an account :

Provided endpoint : `http://localhost:8080/api/wallet/{walletId}/account/{accountId}/withdraw/{amount}`

Allows one to withdraw amount from account associated with wallet.

e.g. Lets withdraw $100 from accountId 1000 associated with walletId 1. I use **POST** request to `http://localhost:8080/api/wallet/1/account/1000/withdraw/100` in Postman. 
Response->{
    "status": "200",
    "description": "Amount 100.0 withdrawn successfully!!",
    "data": {
        "accountNumber": 1000,
        "balance": 900.0,
        "accountHolder": {
            "userId": 1,
            "fname": "Alice",
            "lname": "Wonderland",
            "email": "alice@wonderland"
        },
        "bankTransactions": null
    }
}

* ### e) Perform a deposit transaction on an account :

Provided endpoint : `http://localhost:8080/api/wallet/{walletId}/account/{accountId}/deposit/{amount}`

Allows one to deposit amount into an account associated with a wallet.

e.g. Lets deposit $200 to accountId 1000 associated with walletId 1. I use **POST** request to `http://localhost:8080/api/wallet/1/account/1000/deposit/200` in Postman. Following is the output :
Response:-
{
    "status": "200",
    "description": "Amount 200.0 deposited successfully!!",
    "data": {
        "accountNumber": 1000,
        "balance": 1100.0,
        "accountHolder": {
            "userId": 1,
            "fname": "Alice",
            "lname": "Wonderland",
            "email": "alice@wonderland"
        },
        "bankTransactions": null
    }
}


* ### f) Return last N transactions for an account :

Provided endpoint :  `http://localhost:8080/api/wallet/{walletId}/account/{accountId}/lastNTransactions/{n}`.

Allows one to check their respect transaction statement.

e.g. Let us check for last 3 transactions for accountId 1000 associated with walletId 1. I use a **GET** request to `http://localhost:8080/api/wallet/1/account/1000/lastNTransactions/3` in Postman. Following is the output :

Response->
{
    "status": "200",
    "description": "Statement fetched successfully!!",
    "data": [
        {
            "transactionId": 1,
            "type": "withdraw",
            "timestamp": "2022-08-26T16:54:19.554+0000",
            "amount": 100.0,
            "postBalance": 900.0,
            "description": "withdrawn from account"
        }
    ]
}
