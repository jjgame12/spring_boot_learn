package com.java.single;

import java.util.*;

interface Resource {
    int getI();
}

public final class SingleTon {
    private static final class ResourceImpl implements Resource {
        private int i;

        private ResourceImpl(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }

    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(20);
    }


    public static Resource getResource(){
        return ResourceHolder.resource;
    }

    public static void testMap(String[] args) {
        HashMap<String, StringBuffer> ht = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        sb.append("abc,");
        ht.put("1", sb);
        sb.append("def,");
        ht.put("2", sb);
        sb.append("mno,");
        ht.put("3", sb);
        sb.append("xyz.");
        ht.put("4", sb);

        int numObj = 0;
        Iterator it = ht.entrySet().iterator();
        while (it.hasNext()) {
            System.out.print("get StringBufffer " + (++numObj) + " from Hashmap: ");
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getValue());
        }
    }
}

