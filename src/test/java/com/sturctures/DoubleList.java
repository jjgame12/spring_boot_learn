package com.sturctures;

public class DoubleList {
    public static void main(String[] args) {
        DoubleList d = new DoubleList();
        System.out.println(d.size());

        d.addFirst(new Node(1, 1));
        d.addFirst(new Node(2, 2));
        System.out.println(d.size());

        d.removeLast();
        System.out.println(d.size());
    }

    private Node head;
    private Node tail;
    private int len = 0;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node x) {
        Node next = head.next;
        if (next != null) {
            head.next = x;
            x.next = next;
            x.prev = head;
            next.prev = x;
        }

        len++;
    }

    public void remove(Node x) {
        if (x == null) {
            return;
        }

        Node tNext = x.next;
        Node tPrev = x.prev;
        tPrev.next = tNext;
        tNext.prev = tPrev;
        len--;
    }

    public Node removeLast() {
        Node last = tail.prev;
        if (last == null) {
            return null;
        }

        len--;
        if (last.prev != null) {
            last.prev.next = tail;
            tail.prev = last.prev;
        }
        return last;
    }

    public int size() {
        return len;
    }
}

class Node {
    public int key;
    public int val;
    public Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
