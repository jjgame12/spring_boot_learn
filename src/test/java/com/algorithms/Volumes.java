package com.algorithms;

/*

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49

 */
public class Volumes {
    public static void main(String[] args) {
        int[] test1 = new int[] {1,8,6,2,5,4,8,3,7};

        Volumes v = new Volumes();
        System.out.println(v.maxArea(test1));
    }

    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }

        if (height.length < 2) {
            return 0;
        }

        int length = height.length;
        int max = 0;
        for (int i = 0;i < length;i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        int maxVolume = 0;
        for (int h = 1;h <= max;h++) {
            int xMin = getLower(h, height);
            int xMax = getHigher(h, height);
            if (xMax == -1 || xMin == -1) {
                continue;
            }
            int volume = (xMax - xMin) * h;
            if (volume > maxVolume) {
                maxVolume = volume;
            }
        }
        return maxVolume;
    }

    public int getLower(int h, int[] height) {
        for (int i = 0;i < height.length;i++) {
            if (height[i] >= h) {
                return i;
            }
        }
        return -1;
    }

    public int getHigher(int h, int[] height) {
        for (int i = height.length-1;i >= 0;i--) {
            if (height[i] >= h) {
                return i;
            }
        }
        return -1;
    }
}
