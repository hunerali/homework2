package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row for shooting zone: ");
        var row = scanner.nextInt();
        System.out.print("Enter column for shooting zone: ");
        var column = scanner.nextInt();
        int firstIndex = rand.nextInt(row) + 1;
        int secondIndex = rand.nextInt(column) + 1;
        System.out.println(firstIndex + " " + secondIndex);
        var arr = createShootingZone(row + 1, column + 1);
        print(arr);

        while (true) {
            System.out.print("Enter first index: ");
            int guessFirstIndex = scanner.nextInt();
            System.out.print("Enter second index: ");
            int guessSecondIndex = scanner.nextInt();
            if (guessFirstIndex == firstIndex && secondIndex == guessSecondIndex) {
                arr[guessFirstIndex][guessSecondIndex] = "x | ";
                print(arr);
                System.out.println("You won");
                break;
            } else if (guessFirstIndex > 0 && guessFirstIndex < row && guessSecondIndex > 0 && guessSecondIndex < column) {
                arr[guessFirstIndex][guessSecondIndex] = "* | ";
                print(arr);
                System.out.println("Try again!");
            } else {
                System.out.println("There is no target in this index\n");
                print(arr);
                System.out.println("Try again!\n");
            }
        }
    }

    static void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    static String[][] createShootingZone(int row, int column) {
        String arr[][] = new String[row][column];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    arr[i][j] = j + " | ";
                } else if (j == 0) {
                    arr[i][j] = i + " | ";
                } else {
                    arr[i][j] = "- | ";
                }
            }
        }
        return arr;
    }
}

