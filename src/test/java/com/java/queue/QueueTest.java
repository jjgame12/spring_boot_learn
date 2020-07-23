package com.java.queue;

import org.junit.Test;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest<k extends Comparable> {
    public void q() {
        PriorityQueue q = new PriorityQueue();

    }

    @Test
    public void test1() {
        Queue<Integer> queue = new LinkedList<>();
        if (queue.poll() == null) {
            System.out.println("null");
        }
    }

    @Test
    public void testTime() {
        System.out.println(System.currentTimeMillis());
    }
}
