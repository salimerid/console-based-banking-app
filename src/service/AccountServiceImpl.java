package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService{

    // Initializing list of accounts and minimum balances for different types
    private static List<Account> accounts = new ArrayList<>();
    private static final int minBalance_Current = 1000;
    private static final int minBalance_Savings = 500;
    private static final int minBalance_Salary = 300;
    private static final int minWithdrawBalance = 200; // Minimum balance after withdrawal

    @Override
    public void createAccount(Scanner scanner) {
        System.out.println("Enter account name:");
        String name = scanner.nextLine();

        System.out.println("Enter account number:");
        int number = scanner.nextInt();

        System.out.println("Enter account type (Current, Savings, Salary):");
        String type = scanner.next();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();


        // Check minimum balance based on type
        if (type.equalsIgnoreCase("Current") && balance < minBalance_Current) {
            System.out.println("Current account requires minimum balance of " + minBalance_Current);
            return;
        } else if (type.equalsIgnoreCase("Savings") && balance < minBalance_Savings) {
            System.out.println("Savings account requires minimum balance of " + minBalance_Savings);
            return;
        } else if (type.equalsIgnoreCase("Salary") && balance < minBalance_Salary) {
            System.out.println("Salary account requires minimum balance of " + minBalance_Salary);
            return;
        }

        // Create and add account object
        Account account = new Account(name, number, type, balance);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    @Override
    public void displayAllAccounts(Scanner scanner) {
        System.out.println("All Accounts:");

        for (Account account : accounts) {
            displayAccountDetails(account);
        }
    }

    @Override
    public void updateAccount(Scanner scanner) {
        System.out.println("Enter account number to update:");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter account name for update:");
            String name = scanner.nextLine();
            account.setName(name);

            System.out.println("Enter account type (Current, Savings, Salary) for update:");
            String type = scanner.next();
            if(!type.isEmpty()){
                account.setType(type);
            }
//            System.out.println("Enter initial balance for update:");
//            double newBalance = scanner.nextDouble();
//            account.setBalance(newBalance);

            System.out.println("Account updated successfully!");
            displayAccountDetails(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void deleteAccount(Scanner scanner) {
        System.out.println("Enter account number to delete:");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void depositAmount(Scanner scanner) {
        System.out.println("Enter account number to deposit into:");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter deposit amount:");
            double depositAmount = scanner.nextDouble();
            account.setBalance(account.getBalance() + depositAmount);

            System.out.println("Amount deposited successfully!");
            displayAccountDetails(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void withdrawAmount(Scanner scanner) {
        System.out.println("Enter account number to withdraw from:");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter withdrawal amount:");
            double withdrawalAmount = scanner.nextDouble();

            if (withdrawalAmount <= account.getBalance()) {
                account.setBalance(account.getBalance() - withdrawalAmount);
                System.out.println("Amount withdrawn successfully!");
                displayAccountDetails(account);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void searchAccount(Scanner scanner) {
        System.out.println("Enter account number to search:");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Account found:");
            displayAccountDetails(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private void displayAccountDetails(Account account) {
        System.out.println("Account Name: " + account.getName());
        System.out.println("Account Number: " + account.getNumber());
        System.out.println("Account Type: " + account.getType());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Creation Date: " + account.getCreationDate());
        System.out.println("----------------------");
    }
}
