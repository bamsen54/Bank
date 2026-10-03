package com.simon;


import com.simon.model.Account;
import com.simon.model.Bank;

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

            switch (scanner.nextInt()) {
                case 1 -> IO.println(account.getBalance() + "kr\n");
                case 2 -> depositMenu(account);
                case 3 -> withdrawMenu(account);
                case 10 -> {return;}
            }
        }
    }

    public static void depositMenu(Account account) {
        IO.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        IO.println("amount increased from " + account.getBalance() + " to " + (account.getBalance() + amount));

        account.deposit(amount);
    }

    public static void withdrawMenu(Account account) {
        IO.print("Enter withdraw amount: ");
        double amount = scanner.nextDouble();

        IO.println("amount decreased from " + account.getBalance() + " to " + (account.getBalance() - amount));

        account.withdraw(amount);
    }
}
