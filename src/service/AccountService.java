package service;


import java.util.Scanner;

public interface AccountService {
    void createAccount(Scanner scanner);
    void displayAllAccounts(Scanner scanner);
    void updateAccount(Scanner scanner);
    void deleteAccount(Scanner scanner);
    void depositAmount(Scanner scanner);
    void withdrawAmount(Scanner scanner);
    void searchAccount(Scanner scanner);
}
