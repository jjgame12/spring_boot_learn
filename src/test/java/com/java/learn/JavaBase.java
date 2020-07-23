package com.java.learn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class JavaBase {

    @Test
    public void testDouble() {
        DecimalFormat df = new DecimalFormat("0.00");
        double d = 1.323322;
        System.out.println(df.format(d));
    }

    @Test
    public void testNullInt() {
        // Integer不能为null去转换
        Integer in = null;
        int i = in;
        log.info("in = [{}]", i);
    }

    @Test
    public void test() {
        String a = null;
        System.out.println(a);

        String b = "";
        System.out.println(b == null);
    }

    @Test
    public void testConcurrentHashmap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        if (map.isEmpty()) {
            System.out.println("map is null. initial");
        }

        map.put("a", "1");
        map.put("b", "2");

        if (!map.isEmpty()) {
            System.out.println("map is not null.");
        }

        map.clear();
        if (map.isEmpty()) {
            System.out.println("map is cleared.");
        }
    }

    @Test
    public void testThread() {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest, "A").start();
        new Thread(threadTest, "B").start();
    }

    @Test
    public void testMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "111");
        map.put("b", "222");

        String key = "a";
        String result = map.containsKey(key) ? map.get(key) : "no key";
        System.out.println(result);

        key = "c";
        result = map.containsKey(key) ? map.get(key) : "no key";
        System.out.println(result);

        String value = map.get(key);
        System.out.println(null == value);

        value = null;
        key = "a";
        value = map.get(key);
        System.out.println(null == value);
    }

    @Test
    public void testNull() {
        List list = new ArrayList<Integer>();
        System.out.println(list);
        log.info(list.toString());


        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void testStringNull() {
        String str = "";
        if ("".equals(str)) {
            System.out.println("yes");
        }
    }

    @Test
    public void testE() {
        try {
            testEx();
        } catch (Exception e) {
            log.info("err -> [{}]", e.getMessage());
        }
    }

    public void testEx() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            log.info("error");
            throw new Exception("catch");
//            return;
        } finally {
            log.info("finally");
            throw new Exception("finally");
        }

//        log.info("go on");
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<String>(5);
        log.info("size=[{}]", list.size());
        log.info("isEmpty: [{}]", list.isEmpty());
        list.add("abc");
        list.add("def");
        log.info(list.get(0));
        log.info(list.toString());
        log.info("isEmpty: [{}]", list.isEmpty());
        log.info("contains abc: [{}]", list.contains("abc"));
        log.info("contains yut: [{}]", list.contains("yut"));
    }

    @Test
    public void testAddAll() {
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("dtg");
        List<String> strings1 = new ArrayList<>();
        strings1.addAll(strings);
        System.out.println(strings1);
        System.out.println(strings.get(0) == strings1.get(0));
        strings.set(0, "kk");
        System.out.println("------");
        System.out.println(strings);
        System.out.println(strings1);

        System.out.println("------");
//        strings.clear();
        System.out.println(strings.size());
        System.out.println(strings);
        strings1.addAll(strings);
        System.out.println(strings1);
    }

    @Test
    public void testReplace() {
        String str = "/kk/bb";
        String str1 = "/kk/bb/kk";
        String str2 = StringUtils.replace(str, "/kk", "uu");
        String str3 = StringUtils.replace(str1, "/kk", "uu");
        System.out.println(str2);
        System.out.println(str3);
        str = str.replaceFirst("kk", "uu");
        str1 = str1.replaceFirst("kk", "uu");
        System.out.println(str);
        System.out.println(str1);
    }

    @Test
    public void testArr() {
        List<String> strings = new ArrayList<>();
        strings.forEach(str -> {
            System.out.println(str);
        });
    }

//    @Test
//    public void testToString() {
//        Shuxing shuxing = new Shuxing("a", "dn", "wawa");
//        System.out.println(shuxing.toString());
//    }

    @Test
    public void t() {
        Integer i = null;
        System.out.println(null == i);

        Integer j = 1;
        int k = 1;
        System.out.println(j == k);
    }

    @Test
    public void testLombok() {
        Shuxing shuxing1 = Shuxing.builder().a("a").b("b").c("c").build();
        Shuxing shuxing2 = new Shuxing();
        Shuxing shuxing3 = new Shuxing("a", "b", "cd");

        System.out.println(shuxing1);
        System.out.println(shuxing2);
        System.out.println(shuxing3);
    }

    @Test
    public void testSwitch() {
        Integer i = 1;
        for (int j = 0; j < 3; j++) {
            try {
                switch (i) {
                    case 1:
                        System.out.println("i = 1");
                        System.out.println("yeah");
                        break;

                    case 2:
                        System.out.println("i = 2");
                        System.out.println("heihei");
                        break;

                    default:
                        System.out.println("default");
                        System.out.println("really");
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("end");
                return;
            }
            System.out.println("good");
            System.out.println("---------");
            i++;
        }

        System.out.println("good");
    }

    @Test
    public void testSet() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);

        Set<String> set = new HashSet<>(list);
        System.out.println(set.size());
        set.forEach(str -> {
            System.out.println(str);
        });

        List<String> list2 = new ArrayList<>(set);
        System.out.println(list2);
    }

    @Test
    public void testStream() {
        List<Shuxing> list = new ArrayList<>(3);
        list.add(new Shuxing("a", "aa", "aaa"));
        list.add(new Shuxing("b", "bb", "bbb"));
        list.add(new Shuxing("c", "cc", "ccc"));
        list.add(new Shuxing("b", "bb", "bbb"));

        Set<String> newList = list.stream().map(Shuxing::getC).collect(Collectors.toSet());
        List<Shuxing> list2 = new ArrayList<>(3);
        list2.add(new Shuxing("a", "aa", "ddd"));
        list2.add(new Shuxing("b", "bb", "eee"));
        list2.add(new Shuxing("c", "cc", "eee"));
        newList.addAll(list2.stream().map(Shuxing::getC).collect(Collectors.toList()));
        System.out.println(newList);
    }

    @Test
    public void testContains() {
        List<String> a = new ArrayList<>();
        a.add("ab");
        a.add("xs");
        a.add("cd");
        a.add("ee");
        a.add("wq");

        List<String> b = null;
//        System.out.println("a > b is null : fact: " + a.containsAll(b));

        b = new ArrayList<>();
        System.out.println("a > b is empty : fact: " + a.containsAll(b));

        b.add("ab");
        b.add("xs");
        b.add("cd");

        System.out.println("a > b : fact: " + a.containsAll(b));

        b.add("ty");
        System.out.println("a <> b : fact: " + a.containsAll(b));

    }

    @Test
    public void testDate() {
//        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Date date = new Date();
        System.out.println("now is " + date);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("date string = " + sf.format(date));
//        sf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date newDate = sf.parse(sf.format(date));
            System.out.println("new Date is " + newDate);
            System.out.println("14:56 is " + sf.parse("2019-11-15T14:56:23"));
        } catch (ParseException e) {
            System.out.println("parse error");
            e.printStackTrace();
        }

    }

    @Test
    public void test$name() {
        ABC$abc abc$abc = new ABC$abc();
        abc$abc.name = "wawa";
        System.out.println(abc$abc.name);
    }
}

class ABC$abc {
    String name;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Shuxing {
    private String a;
    private String b;
    private String c;
}

class ThreadTest implements Runnable {

    void syn() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("syn1");
            syn2();
        }
    }

    void syn2() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("syn2");
        }
    }

    @Override
    public void run() {
        syn();
    }
}

