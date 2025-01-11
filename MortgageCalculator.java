package com.MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    int getPrincipal(Scanner scanner){
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        return principal;
    }
    float getRate(Scanner scanner){
        System.out.print("Rate: ");
        float rate = scanner.nextFloat();
        return rate;
    }

    byte getYears(Scanner scanner){
        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        return period;
    }

    double calculateMortgage(double principal, double rate, int period) {
        double monthlyRate = (rate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        return mortgage;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Mortgage Calculator");
        MortgageCalculator mainInstance = new MortgageCalculator();
        double principal = mainInstance.getPrincipal(scanner);
        double rate = mainInstance.getRate(scanner);
        int period = mainInstance.getYears(scanner);
        double mortgage = mainInstance.calculateMortgage(principal, rate, period);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        scanner.close();
    }
}
