import service.AccountService;
import service.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount");
            System.out.println("6. Withdraw an amount");
            System.out.println("7. Search for an account");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            // take the newline character
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.createAccount(scanner);
                    break;
                case 2:
                    service.displayAllAccounts(scanner);
                    break;
                case 3:
                    service.updateAccount(scanner);
                    break;
                case 4:
                    service.deleteAccount(scanner);
                    break;
                case 5:
                    service.depositAmount(scanner);
                    break;
                case 6:
                    service.withdrawAmount(scanner);
                    break;
                case 7:
                    service.searchAccount(scanner);
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}