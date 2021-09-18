package src.main.lesson4.core;

public class L003 {
    public static void main(String[] args) {
        dispatch();
    }

    public static void dispatch() {
        System.out.println("包装类型:自动装箱、拆箱");
        func1();
        func2();
        func3();
        func4();
        func5();
    }

    public static void func1() {
        Integer n1 = new Integer("43");
        Integer n2 = new Integer(43);
        System.out.println(n1 + n2);  // 86
    }

    public static void func2() {
        int i = 100;

        // 通过new操作符创建Integer实例，总是创建新的Integer实例 (不推荐使用,建议用Integer.valueOf)
        // 创建新对象时，优先选用静态工厂方法而不是new操作符
        Integer n1 = new Integer(i);

        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n2 = Integer.valueOf(i);

        // 通过静态方法valueOf(String)创建Integer实例:
        // valueOf方法内部调用的是十进制转换 Integer.parseInt("100", 10);
        Integer n3 = Integer.valueOf("100");

        System.out.println(n3.intValue());    // 100

        // 所有的包装类型都是不变类,Integer是引用类型，比较大小的时候都用equals
        // n2=n3这里是因为，编译器把Integer x=127自动变为Integer x=Integer.valueOf(127)，为了节省内存，Integer.valueOf()对于较小的数，始终返回相同的实例
        System.out.println(n1 == n2);       // false
        System.out.println(n2 == n3);       // true
        System.out.println(n1.equals(n2));  // true

        // Java编译器可以帮助我们自动在int和Integer之间转型
        // 把int变为Integer:自动装箱（Auto Boxing）;Integer变为int的赋值写法:称为自动拆箱（Auto Unboxing）
        Integer n4 = 200;
        int x = n4;
        Integer y = x;
        System.out.println(y);    // 200
    }

    public static void func3() {
        String s1 = String.valueOf("优先使用静态工厂方法，而不是new操作符");
        System.out.println(s1);

        byte b = 127;
        String s = "-128";
        Byte b1 = Byte.valueOf(b);
        Byte b2 = Byte.valueOf(s);
        System.out.println(b2);
    }

    // 包装类中定义的一些 有用的常量
    public static void func4() {
        Integer.toString(100); // "100",表示为10进制
        Integer.toString(100, 36); // "2s",表示为36进制
        Integer.toHexString(100); // "64",表示为16进制
        Integer.toOctalString(100); // "144",表示为8进制
        Integer.toBinaryString(100); // "1100100",表示为2进制

        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)
    }

    // 所有的整数、浮点数的包装类型都继承自Number，可以方便的直接通过包装类型获取各种基本类型
    public static void func5() {
        Number n1 = 27.28;

        // 获取byte, int, long, float, double:
        byte b = n1.byteValue();      // 27  最大-128~127  超过了会舍去二进制的最高位
        int n = n1.intValue();        // 27
        long ln = n1.longValue();     // 27
        float f = n1.floatValue();    // 27.28
        double d = n1.doubleValue();  // 27.28
    }

}
