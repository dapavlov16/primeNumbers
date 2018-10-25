package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.print("До какого числа искать простые? ");
        int max = sc.nextInt();
        Prime primeList = new Prime(max);
        String dir = "ListOfPrimeNumsUpTo";
        dir += (max + ".txt");
        long timeWorkCode = System.currentTimeMillis() - start;
        primeList.writePrimes(dir,timeWorkCode);
        timeWorkCode = System.currentTimeMillis() - start;
        System.out.print("Простые числа записаны в файл " + dir + "\nВремя выполнения программы: " + timeWorkCode + " миллисекунд");
    }
}