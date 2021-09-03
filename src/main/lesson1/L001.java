package src.main.lesson1;

public class L001 {
    public static void dispatch() {
        System.out.println("lesson 2");
        say("你好");

        int n = hello(99);
        System.out.println(n);

        n = 5050;
        System.out.println(n);

        zhen();

        zhen2();

        zhen3();

        // 非静态函数调用
        L001 aa = new L001();
        aa.zhen4();
    }

    // 没返回函数
    public static void say (String var1) {
        System.out.println("say function" + var1);
    }

    // 返回int类型
    private static int hello (Integer var1) {
        return var1 + 100;
    }

    // cow 写时复制
    public static void zhen() {
        int a = 300;
        int b = a;
        a -= 100;
        System.out.println("b:"+b);
        System.out.println("a:"+a);
    }

    // 基本类型的变量 (基本数据类型是CPU可以直接进行运算的类型)
    public static void zhen2() {
        byte a = -128;
        short b = -32768 ;
        int c = -2147483648 ;
        long d = -9223372036854775808L;  // 后面加 'L'
        float e = (float) 3.14;          // 后面加 'f'（3.14f）, 或者前面加类型
        double f = 3.14;
        char g = ' ';
        char g2 = '字';                  // 注意char类型使用单引号'，且仅有一个字符，要和双引号"的字符串类型区分开
        boolean flag = 4>5;

        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        System.out.println("d:"+d);
        System.out.println("e:"+e);
        System.out.println("f:"+f);
        System.out.println("g:"+g);
        System.out.println("g2:"+g2);
        System.out.println("flag:"+flag);
    }

    // 引用类型的变量
    public static void zhen3() {
        String str = "hello zhx";
        final double PI = 3.14;      // 常量 不可再次赋值

        System.out.println("str:"+str);
        System.out.println("PI:"+PI);
    }

    // 变量作用域 非静态函数调用
    public void zhen4()
    {
        Integer aa = 44;

        {
            System.out.println("上文定义aa，在代码块中有效："+aa);

            // 代码块里的变量，作用域只在代码块里
            Integer bb1 = 55;
            System.out.println("代码块中定义bb1："+bb1);

            // 可以更新上文中定义的变量
            aa = 66;
            System.out.println("代码块更新外面aa："+aa);
        }

        System.out.println("代码块外，aa被更新："+aa);

        Integer bb1 = 77;
        System.out.println("下文中重复定义bb1："+bb1);
    }
}
