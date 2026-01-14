package com.paulolibutan;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Period (Years): ");
        byte numberOfPaymentsInYears = scanner.nextByte();
        int numberOfPaymentsInMonths = numberOfPaymentsInYears * MONTHS_IN_YEAR;

        double dividend = annualInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPaymentsInMonths);
        double divisor = Math.pow((1 + monthlyInterestRate), numberOfPaymentsInMonths) - 1;
        double mortgage = principal * (dividend / divisor);
        double roundedMortgage = (double) Math.round(mortgage * 100) / 100;
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(roundedMortgage);
        
        System.out.println("Mortgage: " + formattedMortgage);
    }
}
