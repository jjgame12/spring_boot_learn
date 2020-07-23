package com.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/*
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Island {
    public static void main(String[] args) {
        char[][] test = new char[][] {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        
        char[][] test2 = new char[][] {{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        Island island = new Island();
        System.out.println(island.numIslands(test2));
    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int firstLen = grid.length;
        if (firstLen == 0) {
            return 0;
        }
        int secondLen = grid[0].length;
        if (secondLen == 0) {
            return 0;
        }

        Queue<Integer> islandQueue = new LinkedList<>();
        int islandNum = 0;
        for (int i = 0;i < firstLen;i++) {
            for (int j = 0;j < secondLen;j++) {
                if (grid[i][j] == '1') {
                    islandNum++;
                    // 将整个岛屿进行标记
                    visit(i, j, grid, islandQueue);
                }
            }
        }
        return islandNum;
    }

    void visit(int i, int j, char[][] grid, Queue<Integer> islandQueue) {
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {1, -1, 0, 0};
        islandQueue.offer(i*grid[0].length + j);
        while (!islandQueue.isEmpty()) {
            int index = islandQueue.poll();
            int x = index / grid[0].length;
            int y = index % grid[0].length;
            // 标记为岛屿的已访问
            grid[x][y] = '0';
            for (int k = 0;k < 4;k++) {
                int x1 = x + dx[k];
                int y1 = y + dy[k];
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length) {
                    if (grid[x1][y1] == '1') {
                        islandQueue.offer(x1*grid[0].length + y1);
                    }
                }
            }
        }
    }

//    char[][] getFlagGrid(int firstLen, int secondLen) {
//        if (firstLen == 0 || secondLen == 0) {
//            return null;
//        }
//        char[][] result = new char[firstLen][secondLen];
//        for (int i = 0;i < firstLen;i++) {
//            for (int j = 0;j < secondLen;j++) {
//                result[i][j] =
//
//            }
//        }
//    }
}
