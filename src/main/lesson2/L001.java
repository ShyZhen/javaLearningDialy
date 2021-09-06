package src.main.lesson2;

import java.util.Scanner;

public class L001 {
    public static void main(String[] args) {
        System.out.println("lesson2 流程控制");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
    }

    // 格式化输出 `printf` %d整数 %f浮点数 %x十六进制整数 %e科学计数法表示的浮点数 %s字符串
    public static void func1() {
        double d = 12900000;

        System.out.println(d);       // 1.29E7 不适合人类阅读，使用下文格式化输出
        System.out.printf("%f",d);   // 12900000.000000
        System.out.printf("%.2f",d); // 12900000.00

        int n = 12900000;
        System.out.println(n);       // 12900000
        System.out.printf("%x, %.2f", n,d);  // c4d6a0, 12900000.00
    }

    // 输入
    public static void func2() {
        Scanner scanner = new Scanner(System.in);     // 创建Scanner对象并传入System.in, System.out代表标准输出流,而System.in代表标准输入流

        System.out.println("输入你的名字：");            // 打印提示

        String name = scanner.nextLine();             // 读取一行输入并获取:字符串

        System.out.println("输入你的年龄：");            // 打印提示

        int age = 0;
        if (scanner.hasNextInt()) {                   // 在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读
            age = scanner.nextInt();                  // 读取一行输入并获取:整数
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }


        System.out.printf("你好啊，%s同学,年龄：%d", name, age);
    }

    // 输入上次考试成绩（float）和本次考试成绩（float），然后输出成绩提高的百分比，保留两位小数位
    public static void func3() {
        Scanner scanner = new Scanner(System.in);

        float lastTimeScore = 0;
        float currentScore = 0;

        System.out.println("请输入上次分数：");
        if (scanner.hasNextFloat()) {
            lastTimeScore = scanner.nextFloat();
        } else {
            System.out.println("输入的不是浮点数！");
        }

        System.out.println("请输入本次分数：");
        if (scanner.hasNextFloat()) {
            currentScore = scanner.nextFloat();
        } else {
            System.out.println("输入的不是浮点数！");
        }

        float res = (currentScore - lastTimeScore) / lastTimeScore * 100;

        System.out.printf("分数提升：%.2f%%",res);
    }
}
