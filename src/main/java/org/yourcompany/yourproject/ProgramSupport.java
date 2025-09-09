package org.yourcompany.yourproject;

import java.util.Scanner;

public class ProgramSupport {

    static int sumIncome;
    static int sumExpenses;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "";

        while (!input.equals("end")) {
            input = operation(input);
        }
    }

    private static String operation(String operation) {
        System.out.println("""
                              Выберите операцию и введите её номер:
                              1. Добавить новый доход
                              2. Добавить новый расход
                              3. Выбрать систему налогообложения
                              """);

        operation = scanner.nextLine();
        switch (operation) {
            case "1" ->
                calculateIncome();
            case "2" ->
                calculateExpenses();
            case "3" ->
                enterSystem();
            case "end" ->
                System.out.println("Программа завершена");
            default ->
                System.out.println("Неизвестная операция");
        }

        return operation;
    }

    private static void calculateIncome() {
        int income;
        System.out.println("Введите доход: ");
        income = scanner.nextInt();
        scanner.nextLine();
        sumIncome = sumIncome + income;
    }

    private static void calculateExpenses() {
        int expenses;
        System.out.println("Введите расход: ");
        expenses = scanner.nextInt();
        scanner.nextLine();
        sumExpenses = sumExpenses + expenses;
    }

    private static void enterSystem() {
        int usnIncome = Math.max(0, sumExpenses * 6 / 100);
        int taxableBase = Math.max(0, sumExpenses - sumExpenses);
        int usnIncomeMinus = taxableBase * 15 / 100;
        int economy = Math.abs(usnIncome - usnIncomeMinus);
        if (usnIncome > usnIncomeMinus) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + usnIncomeMinus + " рублей");
            System.out.println("Налог на другой системе: " + usnIncome + " рублей");
            System.out.println("Экономия: " + economy + " рублей");
        } else if (usnIncome < usnIncomeMinus) {
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + usnIncome + " рублей");
            System.out.println("Налог на другой системе: " + usnIncomeMinus + " рублей");
            System.out.println("Экономия: " + economy + " рублей");
        } else {
            System.out.println("Обе системы дают одинаковый налог: " + usnIncome + " рублей");
        }

        System.out.println("Программа завершена");

    }
}
