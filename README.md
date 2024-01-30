# Simple Banking Application

This is a simple console-based banking application that allows users to perform various operations on different types of accounts, such as current accounts, savings accounts, and salary accounts. Users can interact with the application through the console by choosing from eight different options.

## Features

1. **Create a new account:** Users can create a new account by providing details such as name, account number, type (Current, Savings, Salary), initial balance, and creation date.

2. **Display all accounts:** View details of all existing accounts.

3. **Update an account:** Modify the existing account.

4. **Delete an account:** Remove an account from the system.

5. **Deposit an amount:** Add funds to an existing account.

6. **Withdraw an amount:** Withdraw funds from an account, considering minimum balance constraints.

7. **Search for an account:** Look up an account using its account number.

8. **Exit:** Terminate the application.

## Constraints

- Each account type may require a minimum balance to open the account.
  - minimum balance for current (Type) is 1000
  - minimum balance for savings (Type) is 500
  - minimum balance for salary (Type) is 300
- Each account type may require maintaining a minimum balance before withdrawing an amount.
  - minimum balance for all (Type) is 200
- No database usage; data is stored within the application's runtime.

## Getting Started

1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/salimerid/console-based-banking-app.git
   ```

2. Compile and run the Java application.

3. Follow the on-screen instructions to perform banking operations.

## Usage

- Ensure that you have Java-17 installed on your machine.

- Compile and run the application using your preferred Java compiler.

- Follow the prompts to interact with the banking application and perform various operations.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code for your own purposes.
