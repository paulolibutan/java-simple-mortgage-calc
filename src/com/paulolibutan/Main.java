package com.paulolibutan;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static void main() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        double principal;
        float monthlyInterestRate;
        int numberOfPaymentsInMonths;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextDouble();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 10) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Enter a value between 1 and 10");
        }

        while (true) {
            System.out.print("Period (Years): ");
            int numberOfPaymentsInYears = scanner.nextByte();
            if (numberOfPaymentsInYears >= 1 && numberOfPaymentsInYears <= 30) {
                numberOfPaymentsInMonths = numberOfPaymentsInYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double dividend = monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPaymentsInMonths);
        double divisor = Math.pow((1 + monthlyInterestRate), numberOfPaymentsInMonths) - 1;
        double mortgage = principal * (dividend / divisor);
        double roundedMortgage = (double) Math.round(mortgage * 100) / 100;
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(roundedMortgage);

        System.out.println("Mortgage: " + formattedMortgage);
        System.out.println(numberOfPaymentsInMonths);
    }
}
