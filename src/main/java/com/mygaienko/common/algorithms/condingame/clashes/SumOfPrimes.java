package com.mygaienko.common.algorithms.condingame.clashes;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class SumOfPrimes {

    /**
     * Auto-generated code below aims at helping you parse
     * the standard input according to the problem statement.
     **/

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.err.println(N);

        divide(N);
    }

    public static void divide(int n) {
        AtomicLong sum = new AtomicLong();

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);

        divideAndSum(n, primes, 0, sum);

        System.out.println(sum.get());
    }

    public static void divideAndSum(int N, List<Integer> primes, int i, AtomicLong sum) {
        if (primes.size() <= i) {
            return;
        }

        int prime = primes.get(i);
        int left = N % prime;
        if (left == 0) {
            int divided = N / prime;
            sum.addAndGet(prime);
            divideAndSum(divided, primes, i, sum);
        } else {
            divideAndSum(N, primes, i + 1, sum);
        }

    }
}
