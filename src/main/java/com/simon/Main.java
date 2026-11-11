package com.simon;

import com.simon.exception.InsufficientFundsException;
import com.simon.exception.InvalidAmountException;
import com.simon.model.Account;
import com.simon.model.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    static void main() {

        scanner = new Scanner(System.in);

        Bank bank = new Bank();

        bank.setAccount(new Account(1L, 0));

        accountMenu(bank.getAccount());
    }

    public static void accountMenu(Account account) {

        while(true) {

            IO.println("[1]: check balance");
            IO.println("[2]: deposit");
            IO.println("[3]: withdraw");
            IO.println("[10]: exit");
            IO.print(">> ");

            try {
                int input = scanner.nextInt();

                switch (input) {
                    case 1 -> checkBalanceMenu(account);
                    case 2 -> depositMenu(account);
                    case 3 -> withdrawMenu(account);
                    case 10 -> {
                        return;
                    }

                    default -> {IO.println("This number is not a valid choice\n");}
                }
            }

            catch (InputMismatchException e) {
                IO.println("Enter an integer\n");
                scanner.nextLine();
            }
        }
    }

    public static void checkBalanceMenu(Account account) {
        IO.println("Balance: " + account.checkBalance() + "\n");
    }

    public static void depositMenu(Account account) {

        try {
            IO.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();

            double oldBalance = account.getBalance();
            account.deposit(amount);

            IO.println("amount increased from " + oldBalance + " to " + account.getBalance() + "\n");

        }

        catch (InputMismatchException e) {
            IO.println("Enter a double\n");
        }

        catch (InvalidAmountException e) {
            IO.println(e.getMessage() + "\n");
        }
    }

    public static void withdrawMenu(Account account) {

        try {
        IO.print("Enter withdraw amount: ");
        double amount = scanner.nextDouble();

        double oldBalance = account.getBalance();
        account.withdraw(amount);

        IO.println("amount decreased from " + oldBalance + " to " + account.getBalance());
        }

        catch (InputMismatchException e) {
            IO.println("Enter a double\n");
        }

        catch (InvalidAmountException e) {
            IO.println(e.getMessage() + "\n");
        }

        catch (InsufficientFundsException e) {
            IO.println(e.getMessage() + "\n");
        }
    }
}
