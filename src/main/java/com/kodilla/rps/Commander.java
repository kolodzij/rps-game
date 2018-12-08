package com.kodilla.rps;

import java.util.Scanner;

public class Commander {
    private static Scanner scanner = new Scanner(System.in);

    public static void startInfo() {
        System.out.println("Witaj! Rozpoczynasz grę w kamień-papier-nożyce.");
        System.out.println("Informacja dot. klawiszy służących do obsługi gry: ");
        System.out.println("klawisz 1 - zagranie \"kamień\"");
        System.out.println("klawisz 2 - zagranie \"papier\"");
        System.out.println("klawisz 3 - zagranie \"nożyce\"");
        System.out.println("klawisz x - zakończenie gry");
        System.out.println("klawisz n - uruchomienie gry od nowa");
    }

    public static String getName() {
        System.out.println("Podaj proszę swoje imie: ");
        String name = scanner.next();
        return name;
    }

    public static int getMove() {
        System.out.println("Podaj swój ruch: ");
        return getNumber(1,3);
    }

    public static int getRoundCount() {
        System.out.println("Podaj proszę liczbe rund: ");
        return getNumber();
    }

    private static int getNumber() {
        return getNumber(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int getNumber(int minValue, int maxValue) {
        int number = -1;
        boolean isCorrectRound = false;
        do {
            String move = scanner.next();
            try {
                number = Integer.parseInt(move);

                if (number > maxValue || number < minValue) {
                    System.out.println("Wartość poza dopuszczalnym zakresem, podaj liczbę: ");
                }
                else {
                    isCorrectRound = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wartość niepoprawna, podaj liczbę: ");
            }

        } while (!isCorrectRound);
        return number;
    }

    public static void getRoundInfo(int number) {
        System.out.println("Runda " + number);
    }

    public static void showRemis() {
        System.out.println("Remis");
    }

    public static void showUserLost() {
        System.out.println("Przegrałeś");
    }

    public static void showUserWin() {
        System.out.println("Wygrałeś");
    }

    public static boolean playAgain() {
        System.out.println("Chcesz kontynuować grę? Y/N");
        boolean isAgain = false;
        Scanner scanner = new Scanner(System.in);
        String again = scanner.nextLine();
        try {
            if (again.toUpperCase().equals("Y")) isAgain=true;
            else if  (again.toUpperCase().equals("N")) isAgain=false;
        } catch (NumberFormatException e) {
            System.out.println("Wartość niepoprawna.");
        }
        return isAgain;
    }

    public static void gameOver(int userScore, int computerScore) {
        System.out.println("Koniec gry");
        if (userScore==computerScore) System.out.println("Remis");
        else if (userScore<computerScore) System.out.println("Przegrałeś. Wynik: " + userScore + " : " + computerScore);
        else  System.out.println("Wygrałeś. Wynik: " + userScore + " : " + computerScore);
    }

    // Czy chcesz zagrać jeszcze raz
    // Koniec gry. Wynik: ... ...
    // Podaj ilosc rund ?

}
