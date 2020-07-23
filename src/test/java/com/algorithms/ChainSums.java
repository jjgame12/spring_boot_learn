package com.algorithms;

import org.junit.Test;

import java.util.*;

public class ChainSums {
    public static void main(String[] args) {
        ChainSums s = new ChainSums();
        ListNode l1 = s.initNodes(1);
        ListNode l2 = s.initNodes(2);
        ListNode l3 = s.addTwoSums(l1, l2);
        s.printNodes(l1);
        System.out.println("---");
        s.printNodes(l2);
        System.out.println("---");
        s.printNodes(l3);
    }

    @Test
    public void testInitNodes() {
        ChainSums s = new ChainSums();
        ListNode t = s.initNodes(3);
        s.printNodes(t);
    }

    public void printNodes(ListNode nodes) {
        while (nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }

    public ListNode initNodes(int len) {
        if (len <= 0) {
            return null;
        }

        ListNode res = new ListNode(len);
        ListNode ptr = res;
        while (--len > 0) {
            ptr.next = new ListNode(len);
            ptr = ptr.next;
        }

        return res;
    }

    public ListNode addTwoSums(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = revertToArray(l1);
        ArrayList<Integer> arr2 = revertToArray(l2);
        if(arr1 == null && arr2 == null) {
            return null;
        }

        int len1 = arr1.size() - 1;
        int len2 = arr2.size() - 1;
        if (len1 < len2) {
            ArrayList<Integer> tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
            len1 = arr1.size() - 1;
            len2 = arr2.size() - 1;
        }
        // Initial the ArrayList
        ArrayList<Integer> sumArr = new ArrayList<>(len1+1);
        for (int i = 0;i <= len1;i++) {
            sumArr.add(0);
        }
        int flag = 0;
        for (int i = len2;i >= 0;i--) {
            int sum = arr1.get(len1) + arr2.get(i) + flag;
            if (sum > 9) {
                flag = 1;
                sum -= 10;
            } else {
                flag = 0;
            }
            sumArr.set(len1, sum);
            len1--;
        }
        while (len1 >= 0) {
            int sum = arr1.get(len1) + flag;
            if (sum > 9) {
                flag = 1;
                sum -= 10;
            } else {
                flag = 0;
            }
            sumArr.set(len1, sum);
            len1--;
        }
        ListNode result = null;
        ListNode ptr = null;
        if (flag == 1) {
            result = new ListNode(flag);
            ptr = result;
            ptr.next = new ListNode(sumArr.get(0));
            ptr = ptr.next;
        } else {
            result = new ListNode(sumArr.get(0));
            ptr = result;
        }

        for (int i = 1;i < sumArr.size();i++) {
            ptr.next = new ListNode(sumArr.get(i));
            ptr = ptr.next;
        }
        return result;
    }

    public ArrayList<Integer> revertToArray(ListNode nodes) {
        ListNode ptr = nodes;
        int len = 0;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }
        ArrayList<Integer> res = new ArrayList<>(len);
        ptr = nodes;
        while (ptr != null) {
            res.add(ptr.val);
            ptr = ptr.next;
        }
        return res;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
