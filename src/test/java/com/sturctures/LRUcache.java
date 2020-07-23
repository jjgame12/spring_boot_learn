package com.sturctures;

import java.util.HashMap;

public class LRUcache {
    public static void main(String[] args) {
        LRUcache cache = new LRUcache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(3,3);
        cache.put(6,6);
        System.out.println(cache.get(2));
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUcache(int cap) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = cap;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // 将访问的节点置于首位
        Node x = map.get(key);
        cache.remove(x);
        cache.addFirst(x);
        return x.val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 将访问的节点置于首位
            Node temp = map.get(key);
            cache.remove(temp);
            cache.addFirst(x);
            // 更新map中的值
            map.put(key, x);
            return;
        }

        // 不存在
        if (cache.size() == cap) {
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(x);
        map.put(key, x);
    }
}
