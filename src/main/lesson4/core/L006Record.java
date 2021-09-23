package src.main.lesson4.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class L006Record {
    public static void main(String[] args) {
        func1();
        func2();
        func3();
        func4();
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

    public static void func4() {
        MathTest.abs();
        MathTest.random(10, 20);
        MathTest.random2();
        MathTest.random3();
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

class MathTest {
    public static void abs() {
        // abs(number)绝对值
        System.out.println(Math.abs(-99));
        System.out.println(Math.abs(-9.9));

        // 最大最下值
        System.out.println(Math.max(1.9, 40));
        System.out.println(Math.min(1.9, 40));

        // pow(x,y) x的y次方
        System.out.println(Math.pow(10,3));  // 1000.0

        // sqrt(x)  开方x  根号x
        System.out.println(Math.sqrt(2));   // 1.4142135623730951

        // e: 欧拉常数 自然对数的底数 约等于 2.718
        System.out.println(Math.E);         // 2.718281828459045

        // 计算e的x次方
        System.out.println(Math.exp(3));

        // 计算以e为底的对数
        System.out.println(Math.log(4));

        // 计算以10为底的对数
        System.out.println(Math.log10(1000));   // 3

        // 三角函数
        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0

        // 生成一个随机数x，x的范围是0 <= x < 1：
        System.out.println(Math.random());  // 0.22971956916882252
    }

    // 区间在 min - max 直之间的随机数
    public static void random(int min, int max) {
        double x = Math.random();
        double y = x * (max - min) + min;
        int n = (int) y;

        System.out.println(y);
        System.out.println(n);
    }

    // Math.random()调用的也是Random，是伪随机数，给定一个想同的种子的话，随机数就是一样的。
    public static void random2() {
        Random r = new Random();
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double

        System.out.println(r.nextInt(10));
    }

    // 真·随机数
    // SecureRandom就是用来创建安全的随机数的
    // SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。
    public static void random3() {
//        byte[] b = {1,2,4};
//        byte[] buffer = new byte[16];

        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(10));
    }

}
