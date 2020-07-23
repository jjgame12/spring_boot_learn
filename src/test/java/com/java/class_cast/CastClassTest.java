package com.java.class_cast;

import org.junit.Test;

/**
 * 测试类型转换
 */
public class CastClassTest {
    /**
     * 类型转换的时候，基类和子类强行类型转换可以通过编译，但是运行时会抛出异常
     * 不相干的类互转时连编译都无法通过
     */
    @Test
    public void test1() {
        CastA castA = new CastA();
        try {
            CastB castB = (CastB) castA;
        } catch (Exception e) {
            System.out.println(e);
        }

        // 编译无法通过
//        CastC castC = (CastC) castA;
    }
}

class CastA {

}

class CastB extends CastA {

}

class CastC {

}
