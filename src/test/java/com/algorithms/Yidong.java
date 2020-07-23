package com.algorithms;

import org.junit.Test;

import java.util.Scanner;

public class Yidong {
    public static void main1(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str = scanner.nextLine();

        int T = Integer.parseInt(str);
        if (T < 1 || T > 5) {
            return;
        }

        String[] results = new String[T];
        String[] line = null;
        for (int i = 0;i < T;i++) {
            results[i] = "Yes";
            str = scanner.nextLine();
            int N = Integer.parseInt(str);
            if (N < 1 || N > 100) {
                return;
            }
            line = scanner.nextLine().split(" ");
            if (line.length != N) {
                return;
            }
            for (int k = 0;k < (N-1);k++) {
                int current = Integer.parseInt(line[k]);
                int next = Integer.parseInt(line[k+1]);
                if (current == 0 && next == 0) {
                    results[i] = "No";
                    break;
                }
                if (current != 0 && next != 0) {
                    results[i] = "No";
                    break;
                }
            }
            int lastFirst = Integer.parseInt(line[0]);

            for (int j = 1;j < N;j++) {
                line = scanner.nextLine().split(" ");
                if (line.length != N) {
                    return;
                }
                if (lastFirst == 0 && Integer.parseInt(line[0]) == 0) {
                    results[i] = "No";
                }
                if (lastFirst != 0 && Integer.parseInt(line[0]) != 0) {
                    results[i] = "No";
                }
                for (int k = 0;k < (N-1);k++) {
                    int current = Integer.parseInt(line[k]);
                    int next = Integer.parseInt(line[k+1]);
                    if (current == 0 && next == 0) {
                        results[i] = "No";
                        break;
                    }
                    if (current != 0 && next != 0) {
                        results[i] = "No";
                        break;
                    }
                }
                lastFirst = Integer.parseInt(line[0]);
            }
        }

        for (int i = 0;i < T;i++) {
            System.out.println(results[i]);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str = scanner.nextLine();

        int current = Integer.parseInt(str);
        int result = current;
        for (int i = current+1;i < 999998;i++) {
            String nexts = String.valueOf(i);
            int sum1 = Integer.parseInt(String.valueOf(nexts.charAt(0))) +
                    Integer.parseInt(String.valueOf(nexts.charAt(1))) +
                    Integer.parseInt(String.valueOf(nexts.charAt(2)));

            int sum2 = Integer.parseInt(String.valueOf(nexts.charAt(3))) +
                    Integer.parseInt(String.valueOf(nexts.charAt(4))) +
                    Integer.parseInt(String.valueOf(nexts.charAt(5)));

            if (sum1 == sum2) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt());
        }
    }
}
