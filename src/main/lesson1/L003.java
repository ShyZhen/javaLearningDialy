package src.main.lesson1;

public class L003 {
    public static void main(String[] args) {
        System.out.println("独立 lesson 3");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
        func4();
    }

    public static void func1() {
        // 字符类型 基本类型
        char c1 = '甄';
        // 字符串类型 引用类型
        String c2 = "char 定义的只能用单引号,而string用双引号";

        // 显示字符的Unicode编码
        int n1 = c1;
        System.out.println(n1);

        // 字符串连接
        // 如果用+连接字符串和其他数据类型，会将其他数据类型先自动转型为字符串，再连接
        String c3 = c2 + c1 + 888;
        System.out.println(c3);
    }

    public static void func2() {
        String s = "字符串改变是引用改变";
        System.out.println(s);

        String t = s;
        System.out.println(t);

        s = "从新赋值，改变引用,但是赋值给t的是s的之前的值（之前的值的引用），而不是引用指针，cow机制";
        System.out.println(t);
    }

    public static void func3() {
        char a = 'r';
        char b = '修';
        char c = '哥';

        // String s = a+b+c;  // 报错，字符，不是字符串，+是字符串连接符号
        int s = a+b+c;
        System.out.println(s);
    }

    // 拼接字符串 将Unicode拼接成字符串
    // 只要有一个是字符串(String)类型，系统会自动将另一个操作数转换为字符串然后再进行连接
    public static void func4() {
        int a = 72;
        int b = 105;
        int c = 65281;

        String s = "" + (char) a + (char) b + (char) c;
        System.out.println(s);
    }

}
