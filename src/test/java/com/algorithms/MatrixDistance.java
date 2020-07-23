package com.algorithms;

/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1

注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */

import java.util.ArrayList;
import java.util.Stack;

public class MatrixDistance {
    public static void main(String[] args) {
        int[][] a = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = 0;
            }
        }
        a[1][1] = 1;
        a[0][0] = 1;

        MatrixDistance m = new MatrixDistance();
        m.updateMatrix(a);
        int[][] result = m.updateMatrix(a);
        if (result == null) {
            return;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] update(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int firstLen = matrix.length;
        if (firstLen == 0) {
            return null;
        }
        int secondLen = matrix[0].length;
        if (secondLen == 0) {
            return null;
        }
        int[][] result = new int[firstLen][secondLen];
        int rightNumber = 0;
        Stack<Integer> turnIndex1 = new Stack<>();
        Stack<Integer> turnIndex2 = new Stack<>();
        Stack<Integer> tempIndex1 = new Stack<>();
        Stack<Integer> tempIndex2 = new Stack<>();
        for (int i = 0; i < firstLen; i++) {
            for (int j = 0; j < secondLen; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    turnIndex1.push(i);
                    turnIndex2.push(j);
                    rightNumber++;
                    continue;
                }
                result[i][j] = -1;
            }
        }
        int distance = 1;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (rightNumber < firstLen * secondLen) {
            while (!turnIndex1.empty()) {
                int i = turnIndex1.pop();
                int j = turnIndex2.pop();
                int x;
                int y;
                for (int k = 0; k < 4; k++) {
                    x = i + dx[k];
                    y = j + dy[k];
                    if (checkValidIndex(x, y, firstLen, secondLen)) {
                        if (result[x][y] == -1) {
                            result[x][y] = distance;
                            tempIndex1.push(x);
                            tempIndex2.push(y);
                            rightNumber++;
                        }
                    }
                }
            }
            Stack<Integer> temp = turnIndex1;
            turnIndex1 = tempIndex1;
            tempIndex1 = temp;
            temp = turnIndex2;
            turnIndex2 = tempIndex2;
            tempIndex2 = temp;
            distance++;
        }

        return result;
    }

    public boolean checkValidIndex(int i, int j, int firstLen, int secondLen) {
        return i >= 0 && i < firstLen && j >= 0 && j < secondLen;
    }


}
