package com.java.learn;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Method;

public class ReflectLearn {
    @Test
    public void testReflectObjcet() {
        try {
            Class wawaClass = Class.forName("com.java.learn.WWa");
            // 生成对象
            Object wawaObject = wawaClass.newInstance();
            WWa wawa = (WWa)wawaObject;
            System.out.println("wawa name = " + wawa.getName());
            System.out.println("wawa sex = " + wawa.getSex());
            System.out.println("-----------------------");
            wawa.setSex("woman");
            wawa.setName("wawa");
            System.out.println("wawa name = " + wawa.getName());
            System.out.println("wawa sex = " + wawa.getSex());
        } catch (Exception e) {
            System.out.println("error...");
            e.printStackTrace();
        }
    }

    @Test
    public void testReflectPublicMethod() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");

        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            Method doPlayMethod = waWaClass.getMethod("doPlay");
            String result = (String)doPlayMethod.invoke(wawa);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testReflectPublicMethodWithParams() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");

        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            Method doPlayMethod = waWaClass.getMethod("doPlay", String.class);
            String result = (String)doPlayMethod.invoke(wawa, "wa");
            // 不能传递null参数
//            String result0 = (String)doPlayMethod.invoke(wawa, null);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testReflectPrivateMethod() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");

        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            // 注意这里用getMethod是获取不到私有方法的
            Method privatePlayMethod = waWaClass.getDeclaredMethod("privatePlay");
            // 还必须将accessible设置为true
            privatePlayMethod.setAccessible(true);
            String result = (String)privatePlayMethod.invoke(wawa);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllMethods() {
        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            // 可以获取私有的还有canEqual，canEqual是lombok添加的，但是没有线程相关的
            Method[] privateMethods = waWaClass.getDeclaredMethods();
            for (Method method : privateMethods) {
                System.out.println(method.getName());
            }
            System.out.println("-----------------");
            // 多了些与线程有关的方法，但是没有私有的
            Method[] publicMethods = waWaClass.getMethods();
            for (Method method : publicMethods) {
                System.out.println(method.getName());
            }

            System.out.println("******************");

            // 另一种写法
            Method[] privateMethods2 = WWa.class.getDeclaredMethods();
            for (Method method : privateMethods2) {
                System.out.println(method.getName());
            }
            System.out.println("-----------------");
            // 多了些与线程有关的方法，但是没有私有的
            Method[] publicMethods3 = WWa.class.getMethods();
            for (Method method : publicMethods3) {
                System.out.println(method.getName());
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testCanEqual() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");
        System.out.println(wawa.canEqual(wawa));

        Wawa wawa1 = new Wawa.Builder().build();
        System.out.println(wawa.canEqual(wawa1));

        WWa wawa2 = new WWa();
        System.out.println(wawa.canEqual(wawa2));
    }

    @Test
    public void testGetAllTyMethods() {
        try {
            Class waWaClass = Class.forName("com.java.learn.Ty");
            // 可以获取私有的，没有canEqual，但是没有线程相关的
            Method[] privateMethods = waWaClass.getDeclaredMethods();
            for (Method method : privateMethods) {
                System.out.println(method.getName());
            }
            System.out.println("-----------------");
            // 多了些与线程有关的方法，但是没有私有的
            Method[] publicMethods = waWaClass.getMethods();
            for (Method method : publicMethods) {
                System.out.println(method.getName());
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testReflectPublicMethodWithObjectParams() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");

        LeafParam leafParam = new LeafParam();
        leafParam.setParam1("1");
        leafParam.setParam2("2");

        RootParam rootParam = leafParam;

        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            // 不能这么写，会抛java.lang.NoSuchMethodException
//            Method doPlayMethod = waWaClass.getMethod("getLeafParam", RootParam.class);
            Method doPlayMethod = waWaClass.getMethod("getLeafParam", LeafParam.class);
            // 可以接受实际是子类的基类对象
            String result = (String)doPlayMethod.invoke(wawa, rootParam);
            System.out.println(result);

            // 但是不能接受本身就只是基类的对象
//            rootParam = new RootParam();
//            rootParam.setParam1("1");
//            result = (String)doPlayMethod.invoke(wawa, rootParam);

            result = (String)doPlayMethod.invoke(wawa, leafParam);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Test
    public void testReflectPublicMethodWithFanxingParams() {
        WWa wawa = new WWa();
        wawa.setName("ChenWawa");

        Fanxing<Integer> fanxing = new Fanxing<>();
        fanxing.setCode("1");
        fanxing.setData(2);

        Fanxing<String> fanxing1 = new Fanxing<>();
        fanxing1.setCode("1");
        fanxing1.setData("2");

        try {
            Class waWaClass = Class.forName("com.java.learn.WWa");
            Method doPlayMethod = waWaClass.getMethod("getCode", Fanxing.class);
            // 实际调用时会在invoke方法内部出错
//            String result = (String)doPlayMethod.invoke(wawa, fanxing);
            String result = (String)doPlayMethod.invoke(wawa, fanxing1);
            System.out.println(result);

            // 与上面比较，getCodeWithoutData方法内部不会实际调用fanxing中的不一致的data，所以可以
            Method method = waWaClass.getMethod("getCodeWithoutData", Fanxing.class);
            // 因为泛型擦除和替换，所以虽然函数中的泛型T要求是String，但是这里用Integer仍然能够通过编译，
            // 如果C++应该揪不行，但是在实际函数执行中如果再涉及到T，就可能出现异常
            result = (String)method.invoke(wawa, fanxing);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}

class Ty {
    private String id;
    private String name;

    public void get() {

    }

    private void getP() {

    }
}

@Data
class WWa {
    private String name;
    private String sex;

    public String doPlay() {
        System.out.println(name + " doPlay() is invoked.");
        return "This is " + name + ", doPlay";
    }

    public String doPlay(String name) {
        System.out.println(name + " doPlay(String name) is invoked.");
        return "This is " + name + ", doPlay(String name)";
    }

    private String privatePlay() {
        System.out.println(name + " privatePlay() is invoked.");
        return "This is " + name + ", privatePlay";
    }

    public String getLeafParam(LeafParam leafParam) {
        System.out.println("param2 = " + leafParam.getParam2());
        return leafParam.getParam2();
    }

    public String getCode(Fanxing<String> fanxing) {
        System.out.println("code = " + fanxing.getCode());
        System.out.println("data = " + fanxing.getData());
        return fanxing.getCode();
    }

    // 不能和上面的方法共存，因为泛型擦除后这就不能叫做重构方法
//    public String getCode(Fanxing<Integer> fanxing) {
//        System.out.println("code = " + fanxing.getCode());
//        System.out.println("data = " + fanxing.getData());
//        return fanxing.getCode();
//    }

    public String getCodeWithoutData(Fanxing<String> fanxing) {
        System.out.println("code = " + fanxing.getCode());
//        System.out.println("data = " + fanxing.getData());
        return fanxing.getCode();
    }
}

@Data
class RootParam {
    private String param1;
}

@Data
class LeafParam extends RootParam {
    private String param2;
}

@Data
class Fanxing<T> {
    private String code;
    private T data;
}
