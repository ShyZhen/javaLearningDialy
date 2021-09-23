package src.main.lesson4.core;

import java.math.BigDecimal;
import java.math.BigInteger;

public class L006Record {
    public static void main(String[] args) {
        func1();
        func2();
        func3();
    }

    public static void func1() {
        int x = 10;
        int y = 20;
        int x1 = 100;
        int y1 = 200;

        Point p1 = new Point(x, y);
        System.out.println(p1.x());
        System.out.println(p1.y());

        Point p2 = new Point(x1,y1);
        System.out.println(p2.x());
        System.out.println(p2.y());
    }

    // BigInteger
    // 在Java中，由CPU原生提供的整型最大范围是64位long型整数.直接通过cpu指令集进行计数，速度非常快。
    // 如果超过了：java.math.BigInteger就是用来表示任意大小的整数。BigInteger内部用一个int[]数组来模拟一个非常大的整数。
    // 和long型整数运算比，BigInteger不会有范围限制，但缺点是速度比较慢
    public static void func2() {
        BigInteger bn = new BigInteger("123123123123123");
        BigInteger bn2 = new BigInteger("123123123123123");

        // 对BigInteger做运算的时候，只能使用实例方法
        BigInteger bn3 = bn.add(bn2);

        System.out.println(bn);
        System.out.println(bn3);
    }

    public static void func3() {
        // BigInteger 也是继承number，所以可以转换类型

        // 转换为byte：byteValue()
        // 转换为short：shortValue()
        // 转换为int：intValue()
        // 转换为long：longValue()
        // 转换为float：floatValue()
        // 转换为double：doubleValue()

        // 如果BigInteger表示的范围超过了基本类型的范围，转换时将丢失高位信息，即结果不一定是准确的。
        // 如果需要准确地转换成基本类型，可以使用intValueExact()、longValueExact()等方法，在转换时如果超出范围，将直接抛出ArithmeticException异常。

        BigInteger bn2 = new BigInteger("123");

        byte b = bn2.byteValue();
        short s = bn2.shortValue();
        System.out.println(b);

        // 和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数
        BigDecimal bd = new BigDecimal("123123123123123.123123123123123");
        System.out.println(bd);
    }
}

// 不可变类 没有setXxx、全部属性都是私有化、final，无法被继承者修改
final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public String toString() {
        return String.format("Point[x=%s, y=%s]", x, y);
    }

}
