package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of rows in square matrix:");
        String in = "";
        try {
            in = bufferedReader.readLine();

            int num = Integer.parseInt(in);

            int[][] matrix = new int[num][num];

            System.out.println("Enter matrix rows with elements separated by single space and rows separated by new lines. ");
            for (int i = 0; i < num; i++) {
                in = bufferedReader.readLine();
                String[] nums = in.split(" ");
                for (int j = 0; j < nums.length; j++) {
                    matrix[i][j] = Integer.parseInt(nums[j]);
                }
            }

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(matrix[i][j]);
                    System.out.print("  ");
                }
                System.out.println();
            }

            if (num % 2 == 0) {
                System.out.println("Solution is " + getSumOfDiagonals(matrix, num));
            } else {
                System.out.println("Solution is " + (getSumOfDiagonals(matrix, num) - matrix[(num - 1) / 2][(num - 1) / 2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid inputs");
        }
    }

    private static int getSumOfDiagonals(int[][] matrix, int num) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i + j == (num - 1)) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}
