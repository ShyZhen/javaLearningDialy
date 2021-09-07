package src.main.lesson2;

import java.util.Locale;

public class L002 {
    public static void main(String[] args) {
        dispatch();
    }

    public static void dispatch() {
        System.out.println(func1());
        func2();
        func3(5);
        func4(100);
        func5();
        System.out.println(func6());
        func7();
        func8();
    }

    // 复习 字符串数组+循环拼接 返回字符串
    public static String func1() {
        String[] strArr = new String[]{"lesson","2","-","流程控制"};

        String str = "";
        for (int i = 0; i < strArr.length; i++) {
            str += strArr[i];
        }

        return str;
    }

    // 使用 == 判断引用类型不靠谱
    // ==表示“引用是否相等”，或者说，是否指向同一个对象
    // 要判断引用类型的变量内容是否相等，必须使用equals()方法
    public static void func2() {
        String str1 = "hello";
        String str2 = "HELLO".toLowerCase(Locale.ROOT);

        System.out.printf("%s,%s \n",str1,str2);

        if (str1 == str2) {
            System.out.println("==相等");
        } else {
            System.out.println("==不相等");
        }

        // 执行语句s1.equals(s2)时，如果变量s1为null会报错NullPointerException，利用短路运算符&&避免
        if (str1 != null && str1.equals(str2)) {
            System.out.println("equals相等");
        } else {
            System.out.println("equals不相等");
        }
    }

    // switch
    // switch语句还可以匹配字符串。字符串匹配时，是比较“equals内容相等”,
    public static void func3(int type) {
        switch (type) {
            case 1:
                System.out.println("第一种模式");
                System.out.println("开始开始");
                break;
            case 2:
                System.out.println("第二种模式");
                break;
            case 3:
                System.out.println("第三种模式");
                break;
            default:
                System.out.println("退出");
                break;
        }

        //  Java 12 表达式语法
//        switch (type) {
//            case 1 -> {
//                System.out.println("第一种模式");
//                System.out.println("开始开始");
//            }
//            case 2 -> System.out.println("第二种模式");
//            case 3 -> System.out.println("第三种模式");
//            default -> System.out.println("退出");
//        }
    }

    // 循环 从1加到num的和
    public static void func4(int num) {
        int i = 1;
        int sum = 0;
        while(i <= num) {
            sum +=i;
            i++;
        }
        System.out.println(sum);
    }

    // 计算从m到n的和
    public static void func5() {
        int sum = 0;
        int m = 20;
        int n = 100;
        while (m <= n) {
            sum +=m;
            m++;
        }
        System.out.println(sum);
    }

    // do where 循环计算1到100的和
    public static int func6() {
        int res = 0;
        int i = 1;
        do {
            res +=i;
            i++;
        } while (i<=100);

        return  res;
    }

    // foreach 遍历数组
    // for each循环的写法更简洁,但是for each循环无法指定遍历顺序，也无法获取数组的索引
    public static void func7() {
        int[] array = {22,55};
        for (int val: array) {
            System.out.println(val);
        }
    }

    // for 循环 倒序遍历数组
    public static void func8() {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i = ns.length -1; i>=0; i--) {
            System.out.printf("%d,",ns[i]);
        }


        // for each循环对数组求和
        int[] ns2 = { 1, 4, 9, 16, 25 };
        int sum = 0;
        for (int val: ns2) {
            sum += val;
        }
        System.out.println(sum); // 55
    }

    // break语句可以跳出当前循环；
    // break语句通常配合if，在满足条件时提前结束整个循环；
    // break语句总是跳出最近的一层循环；
    // continue语句可以提前结束本次循环；
    // continue语句通常配合if，在满足条件时提前结束本次循环。

}
