package src.main.lesson1;

public class L002 {
    public static void dispatch() {
        System.out.println("lesson 2");

        L002 obj = new L002();
        obj.func1(3);

        obj.func2();

        System.out.println(obj.sumOf(100));

        func4();
        func5();
    }

    // for循环
    public void func1(Integer num) {
        Byte times = 10;
        if (num < times) {
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        }
    }

    // 简单运算 (定义任何变量时候，尽量使用最接近的范围)
    public void func2() {
        // Integer是int的包装类，int则是java的一种基本数据类型
        // Integer实际是对象的引用，当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值
        byte m = 27;
        int i = 10 * 10 + 5;
        Integer j = i/10;
        Integer o = i%10;
        int n = m+i-j;    // n无法定义为byte,计算结果为较大类型的整型,可以强转 byte n =(byte) (m+i-j);若超出范围的强制转型会得到错误的结果，最高位字节将被扔掉

        System.out.print("i:"+i);
        System.out.print("j:"+j);
        System.out.print("o:"+o);
        System.out.println("n:"+n);


        // https://www.cnblogs.com/guodongdidi/p/6953217.html
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer aa = 100;
        Integer bb = 100;
        int c = 100;

        System.out.print(a == b);     //false
        System.out.print(aa == bb);   //true
        System.out.print(a == aa);    //false
        System.out.print(a == c);     //true
        System.out.println(aa == c);    //true
    }

    // 计算前n个自然数的和
    public int sumOf(int n) {
        int sum = 0;

        //
        for (int i=0; i<=n; i++) {
            sum +=i;
        }

        //
        sum = (1 + n) * n / 2;

        return sum;
    }

    // 浮点数无法准确表示,涉及到花费的存分
    public static void func4() {
        double x = 1.00 / 10;  // x:0.1
        double y = 0.01 / 10;  // y:0.001
        double z = 1 - 0.9;    // z:0.09999999999999998

        System.out.println("x:"+x);
        System.out.println("y:"+y);
        System.out.println("z:"+z);
    }

    // 数字取整、四舍五入
    public static void func5() {
        // 四舍五入
        long round = Math.round(1.499);
        long round2 = Math.round(1.5);
        System.out.println(round);
        System.out.println(round2);

        // 向上取整
        int s = (int) Math.ceil(1.1);
        System.out.println(s);

        // 向下取整
        int t = (int)Math.floor(1.6);
        System.out.println(t);

        // 四舍五入也可以 直接+0.5，然后强转int
        int x = (int) (5.1 + 0.5);
        System.out.println(x);
    }

    // 布尔运算
    public static void func6() {
        boolean isGreater = 5 > 3; // true

        int age = 12;
        boolean isZero = age == 0; // false
        boolean isNonZero = !isZero; // true
        boolean isAdult = age >= 18; // false
        boolean isTeenager = age >6 && age <18; // true

        // 三元 求绝对值
        int n = -100;
        int x = n >= 0 ? n : -n;
        System.out.println(x);
    }
}
