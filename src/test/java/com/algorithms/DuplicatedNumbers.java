package com.algorithms;

/*
由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。

如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。

现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。

请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。

 

示例：

输入：
s1 ="acb",n1 = 4
s2 ="ab",n2 = 2

返回：
2
 */

public class DuplicatedNumbers {
    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;

        DuplicatedNumbers d = new DuplicatedNumbers();
        System.out.println(d.getMaxRepetitions(s1, n1, s2, n2));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        String completeS1 = getCompleteStr(s1, n1);
        String completeS2 = getCompleteStr(s2, n2);
        int len1 = completeS1.length();
        int len2 = completeS2.length();
        if (len1 < len2) {
            return 0;
        }

        int times = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1) {
            if (completeS1.charAt(p1) == completeS2.charAt(p2)) {
                if (p2 == len2-1) {
                    times++;
                    // reset
                    p1++;
                    p2 = 0;
                    continue;
                }
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        return times;
    }

    public boolean contain(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 < length2) {
            return false;
        }

        int times = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < length1 && p2 < length2) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                if (p2 == length2-1) {
                    return true;
                }
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        return false;
    }

    public String getCompleteStr(String s, int n) {
        String result = "";
        while (n-- > 0) {
            result += s;
        }
        return result;
    }
}
