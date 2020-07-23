package com.algorithms;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

import java.util.ArrayList;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr1 = new int[] {2,3,1,1,4};
        int[] arr2 = new int[] {3,2,1,0,4};

        JumpGame j = new JumpGame();
        System.out.println(j.canJump2(arr1));
        System.out.println(j.canJump2(arr2));
    }

    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int reachMaxIndex = 0;
        for (int i = 0;i < nums.length;i++) {
            if (i > reachMaxIndex) {
                return false;
            }
            int tempMaxIndex = nums[i] + i;
            if (reachMaxIndex < tempMaxIndex) {
                reachMaxIndex = tempMaxIndex;
            }
            if (reachMaxIndex >= nums.length-1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == 0 && i < nums.length-1) {
                indexes.add(i);
            }
        }

        if (indexes.isEmpty()) {
            return true;
        }
        int currentLen = 0;
        int index;
        boolean flag;
        while (currentLen < indexes.size()) {
            index = indexes.get(currentLen);
            flag = false;
            for (int i = 1;i <= index;i++) {
                if (nums[index - i] != 0 && nums[index - i] > i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            currentLen++;
        }

        return true;
    }

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        return isRight(0, nums.length, nums);
    }

    public boolean isRight(int index, int length, int[] nums) {
        if (index >= length) {
            return false;
        }

        if (index == length-1) {
            return true;
        }

        if (nums[index] <= 0) {
            return false;
        }

        for (int i = 1;i <= nums[index];i++) {
            if (isRight(index+i, length, nums)) {
                return true;
            }
        }

        return false;
    }
}
