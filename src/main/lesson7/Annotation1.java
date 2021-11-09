package src.main.lesson7;


import src.main.lesson7.annotations.Custom;

/**
 * 注解模块
 * 注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释“
 *
 * Java的注解可以分为三类：
 *   1. 由编译器使用的注解，如@Override @SuppressWarnings。
 *   2. 由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。
 *   3. 程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。
 *
 * @Author zhenhuaixiu
 * @Date 2021/10/28 15:56
 * @Version 1.0
 */

public class Annotation1 {

    public static int num1 = 99;

    public static void main(String[] args) {
        func1();
        func2();
    }

    @Custom
    public static void func1() {
        System.out.println(Annotation1.num1);

        Annotation1.num1 = 11;
        System.out.println(Annotation1.num1);
    }

    @Custom(level = "err", type = 9, value = "heng")
    public static void func2() {
        System.out.println("func2");
    }
}


