package service;

import model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    // Initializing list of accounts and minimum balances for different types
    private static List<Account> accounts = new ArrayList<>();
    private static final int minBalance_Current = 1000;
    private static final int minBalance_Savings = 500;
    private static final int minBalance_Salary = 300;
    private static final int minWithdrawBalance = 200; // Minimum balance after withdrawal
    private static final String[] accountType = {"current", "savings", "salary"};

    @Override
    public void createAccount(Scanner scanner) {
        String name = "";
        int accountNumber = 0;
        String type = "";
        double balance = 0.0;

        System.out.println("Enter account name:");
        while (true) {
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Account name is required.\nRe-Enter");
            } else {
                break;
            }
        }

        System.out.println("Enter account number:");
        while (true) {
            try {
                String accNumber = scanner.nextLine();
                accountNumber = Integer.parseInt(accNumber);
                Account account = findAccountNumber(accountNumber);
                if (account != null) {
                    System.out.println("This account number is already exists!.\nRe-Enter");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Account number must be numeric.\nRe-Enter");
            }
        }

        System.out.println("Enter account type (Current, Savings, Salary):");
        while (true) {
            type = scanner.nextLine();
            boolean isContains = Arrays.asList(accountType).contains(type.toLowerCase());
            if (!isContains) {
                System.out.println("Incorrect account Type. Please enter account type (Current, Savings, Salary).\nRe-Enter");
            } else {
                break;
            }
        }

        System.out.println("Enter initial balance:");
        while (true) {
            try {
                String blc = scanner.nextLine();
                balance = Double.parseDouble(blc);
            } catch (NumberFormatException e) {
                System.out.println("Balance must be double");
            }

            // Check minimum balance based on type
            if (type.equalsIgnoreCase("Current") && balance < minBalance_Current) {
                System.out.println("Current account requires minimum balance of " + minBalance_Current + ".\nRe-Enter");
            } else if (type.equalsIgnoreCase("Savings") && balance < minBalance_Savings) {
                System.out.println("Savings account requires minimum balance of " + minBalance_Savings + ".\nRe-Enter");
            } else if (type.equalsIgnoreCase("Salary") && balance < minBalance_Salary) {
                System.out.println("Salary account requires minimum balance of " + minBalance_Salary + ".\nRe-Enter");
            } else {
                break;
            }
        }

        // Create and add account object
        Account accountData = new Account(name, accountNumber, type, balance);
        accounts.add(accountData);
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
        Account account = findAccount(scanner, "Enter account number to update:");
        if (account != null) {
            System.out.println("Enter account name for update:");
            while (true) {
                String name = scanner.next();
                if (name.isEmpty()) {
                    System.out.println("Account name is required.\nRe-Enter");
                } else {
                    account.setName(name);
                    break;
                }
            }

            System.out.println("Enter account type (Current, Savings, Salary) for update:");
            while (true) {
                String type = scanner.next();
                boolean isContains = Arrays.asList(accountType).contains(type.toLowerCase());
                if (!isContains) {
                    System.out.println("Incorrect account Type. Please enter account type (Current, Savings, Salary) for update.\nRe-Enter");
                } else {
                    account.setType(type);
                    break;
                }
            }

            System.out.println("Account updated successfully!");
            displayAccountDetails(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void deleteAccount(Scanner scanner) {
        Account account = findAccount(scanner, "Enter account number to delete:");
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void depositAmount(Scanner scanner) {
        Account account = findAccount(scanner, "Enter account number to deposit into:");
        if (account != null) {
            System.out.println("Enter deposit amount:");
            while (true) {
                try {
                    String tempDepositAmount = scanner.next();
                    double depositAmount = Double.parseDouble(tempDepositAmount);
                    account.setBalance(account.getBalance() + depositAmount);
                    System.out.println("Amount deposited successfully!");
                    displayAccountDetails(account);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Balance must be double");
                }
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void withdrawAmount(Scanner scanner) {
        Account account = findAccount(scanner, "Enter account number to withdraw from:");
        if (account != null) {
            System.out.println("Enter withdrawal amount:");
            while (true) {
                try {
                    String tempWithdrawalAmount = scanner.next();
                    double withdrawalAmount = Double.parseDouble(tempWithdrawalAmount);
                    if (minWithdrawBalance <= (account.getBalance() - withdrawalAmount)) {
                        account.setBalance(account.getBalance() - withdrawalAmount);
                        System.out.println("Amount withdrawn successfully!");
                        displayAccountDetails(account);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Balance must be double");
                }
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void searchAccount(Scanner scanner) {
        Account account = findAccount(scanner, "Enter account number to search:");
        if (account != null) {
            System.out.println("Account found:");
            displayAccountDetails(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    private Account findAccount(Scanner scanner, String displayText) {
        Account account;
        System.out.println(displayText);
        while (true) {
            try {
                int accountNumber = Integer.parseInt(scanner.nextLine());
                account = accounts.stream().filter(acc -> acc.getNumber() == accountNumber).findFirst().orElse(null);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Account number must be numeric.\nRe-Enter");
            }
        }
        return account;
    }

    private Account findAccountNumber(int accountNumber) {
       return accounts.stream().filter(acc -> acc.getNumber() == accountNumber).findFirst().orElse(null);
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
