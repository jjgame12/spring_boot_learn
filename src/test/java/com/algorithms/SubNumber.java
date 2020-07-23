package com.algorithms;

import org.junit.Test;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class SubNumber {
    @Test
    public void test() {
        SubNumber subNumber = new SubNumber();
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
//        System.out.println(subNumber.minSubArrayLen(s, nums));
        System.out.println(subNumber.func2(s, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        // 头指针、尾指针
        int i = 0;
        int j = 1;

        int result = 0;
        int current = nums[i];
        if (current >= s) {
            return 1;
        }
        for (;j < nums.length;j++) {
            current += nums[j];
            if (current >= s) {
                result = compare(result, j - i + 1);
                break;
            }
        }

        for (i = 1; i < nums.length; i++) {
            current -= nums[i - 1];
            if (current >= s) {
                result = compare(result, j - i + 1);
                continue;
            }
            // 提前退出
            if (j == nums.length) {
                if (current < s) {
                    break;
                }
            }

            for (j = j + 1; j < nums.length;j++) {
                current += nums[j];
                if (current >= s) {
                    result = compare(result, j - i + 1);
                    break;
                }
            }
        }
        return result;
    }

    public int func2(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        // 头指针、尾指针
        int i = 0;
        int j = 1;

        int result = 0;
        int current = nums[i];
        if (current >= s) {
            return 1;
        }
        for (;j < nums.length;j++) {
            current += nums[j];
            if (current >= s) {
                if (result == 0) {
                    result = j - i + 1;
                } else {
                    result = result < (j - i + 1) ? result : (j - i + 1);
                }
                break;
            }
        }

        for (i = 1; i < nums.length; i++) {
            current -= nums[i - 1];
            if (current >= s) {
                if (result == 0) {
                    result = j - i + 1;
                } else {
                    result = result < (j - i + 1) ? result : (j - i + 1);
                }
                continue;
            }
            // 提前退出
            if (j == nums.length) {
                if (current < s) {
                    break;
                }
            }

            for (j = j + 1; j < nums.length;j++) {
                current += nums[j];
                if (current >= s) {
                    if (result == 0) {
                        result = j - i + 1;
                    } else {
                        result = result < (j - i + 1) ? result : (j - i + 1);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private int compare(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return a < b ? a : b;
    }
}
