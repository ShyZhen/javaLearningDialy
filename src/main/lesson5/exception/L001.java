package src.main.lesson5.exception;

import src.main.lesson4.core.L005Enum;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

//Java使用异常来表示错误，并通过try ... catch捕获异常；
//Java的异常是class，并且从Throwable继承；
//Error是无需捕获的严重错误，Exception是应该捕获的可处理的错误；
//RuntimeException无需强制捕获，非RuntimeException（Checked Exception）需强制捕获，或者用throws声明；
//不推荐捕获了异常但不进行任何处理。

public class L001 {
    public static void main(String[] args) {
        func1();
        func2();
        func3();
        func6();
        func7();
        func8();
    }






    public static void func1() {
        L005Enum.func1();
    }

    public static void func2() {
        exceptionTest();
    }

    // 捕获异常使用try...catch语句
    // 把可能发生异常的代码放到try {...}中，然后使用catch捕获对应的Exception及其子类
    // Throwable是异常体系的根，它继承自Object。Throwable有两个体系：Error和Exception
    // Error表示严重的错误，程序对此一般无能为力;而Exception则是运行时的错误，它可以被捕获并处理
    private static void exceptionTest()
    {
        String s = "12";
        try {
            s += "34";
            // s += "34aa";

            int n = Integer.parseInt(s);
            System.out.println(n);           // 1234
        } catch (Throwable e) {
            System.out.println("错误进到catch");
            e.printStackTrace();
        }
    }






    public static void func3() {
        System.out.println(Arrays.toString(toGBK("这种症状")));
    }

    // s.getBytes("GBK") 方法抛出了异常，该异常必须被捕获，要么try catch进行捕获，要么方法中进行抛出异常（如 toGBK2()）
    private static byte[] toGBK(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
            return s.getBytes(StandardCharsets.UTF_8);
        }
    }






    public static void func4()
    {
        try {
            toGBK2("必须捕获异常");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 不在调用层捕获，也必须在更高的调用层捕获
    // 调用该方法的地方也要抛出异常，最终到main
    private static byte[] toGBK2(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }






    // 多catch：子类必须写在前面
    // finally：无论是否有异常发生，如果我们都希望执行一些语句。非必须，总是最后执行。
    public static void func5()
    {
        try {
            func1();
            func2();
            System.out.println("无论是否异常都要执行");
        } catch (Exception e) {
            func3();
            System.out.println("无论是否异常都要执行");
        } catch (Throwable  e) {
            func4();
            System.out.println("无论是否异常都要执行");
        }


        try {
            func1();
            func2();
        } catch (Exception  e) {
            func3();
        } catch (Throwable  e) {
            func4();
        } finally {
            System.out.println("无论是否异常都要执行");
        }
    }







    // 当某个方法抛出了异常时，如果当前方法没有捕获异常，异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止
    public static void func6()
    {
        try {
            process1();
            System.out.println("func6正常执行");
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("func6出现了格式化异常");
        } catch (Throwable e) {
            //e.printStackTrace();
            System.out.println("func6未知异常");
        } finally {
            System.out.println("func6 over");
        }
    }
    private static void process1() {
        process2();
    }
    private static void process2() {
        Integer.parseInt("null");
    }





    // 抛出异常
    // 在catch子句中抛出新的异常，就相当于把抛出的异常类型“转换”
    // 在catch中抛出异常，不会影响finally的执行。JVM会先执行finally，然后抛出异常。
    public static void func7()
    {
        try {
            process3(null);
        } catch (Exception e) {
            // e.printStackTrace();
            // 捕获异常并再次抛出新的异常时，应该持有原始异常信息
            throw new IllegalArgumentException("(异常类型转换)非法输入", e);
        } finally {
            // 如果catch 和 finally都抛出了异常，那么catch的会被屏蔽，只抛出finally的异常。
            // 想把原始异常加进来，需要先定义异常变量，然后Throwable.addSuppressed()添加。
            // 通常不要在finally中抛出异常
            System.out.println("finally会执行");
        }
    }
    public static void func8()
    {
        // 不是函数抛出的异常，可以不使用try catch
        // process4(null);
    }

    private static void process3(String s) throws Exception {
        if (s == null) {
            throw new Exception("process3参数不能为null");
        }
    }

    private static void process4(String s) {
        if (s == null) {
            NullPointerException e = new NullPointerException("process4参数也不能为null");
            throw e;
        }
    }
}
