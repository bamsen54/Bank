package com.simon;

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
                    case 1 -> IO.println(account.getBalance() + "kr\n");
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

    public static void depositMenu(Account account) {
        IO.print("Enter deposit amount: ");
        double amount;

        try {
            amount = scanner.nextDouble();
        } catch (InputMismatchException e) {
            IO.println("Enter a number\n");
            scanner.nextLine();
            return;
        }

        if (amount < 0) {
            IO.println("Negative amount is invalid");
            return;
        }

        double oldBalance = account.getBalance();
        account.deposit(amount);

        IO.println("amount increased from " + oldBalance + " to " + account.getBalance() + "\n");
    }

    public static void withdrawMenu(Account account) {
        IO.print("Enter withdraw amount: ");
        double amount;

        try {
            amount = scanner.nextDouble();
        } catch (InputMismatchException e) {
            IO.println("Enter a number\n");
            scanner.nextLine();
            return;
        }

        if (amount < 0) {
            IO.println("Negative amount is invalid");
            return;
        }

        if (amount > account.getBalance()) {
            IO.println("Insufficient funds you have less than: " + amount + " in your account");
            return;
        }

        double oldBalance = account.getBalance();
        account.withdraw(amount);

        IO.println("amount decreased from " + oldBalance + " to " + account.getBalance());
    }
}
