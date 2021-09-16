package src.main.lesson4.core;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class L001String {
    public static void main(String[] args) {
        System.out.println("java 核心类 lang");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
        func4();
        func5();
    }

    // 实际上字符串在String内部是通过一个char[]数组表示的
    // String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
    // 两个字符串比较，必须总是使用equals()
    public static void func1() {
        String s1 = new String("你好");
        String s2 = "你好";
        String s3 = "你好";
        String s4 = new String("你好");

        // 比较字符串的时候，必须使用equals()方法而不能用==
        Boolean flag1 = s1 == s2;       // false
        Boolean flag2 = s1.equals(s2);  // true
        Boolean flag3 = s2 == s3;       // true  // Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然s2和s3的引用就是相同的
        System.out.println(s1+s2);      // 你好你好

        // 自动把所有相同的字符串当作一个对象放入常量池，值不同肯定在编译的时候就是两个了，毕竟是引用类型
        s3 = "你不好";
        System.out.println(s2);         // 你好

        System.out.println(s1==s4);      // false  // 两个都是引用
    }

    public static void func2() {
        String s1 = "hellllo";
        System.out.println(s1);    // hellllo

        s1 = s1.toUpperCase(Locale.ROOT);
        System.out.println(s1);    // HELLLLO
    }

    public static void func3() {
        String s1 = "hello world!";

        // 判断字符串中是否包含指定的字符或字符串
        Boolean f1 = s1.contains("ld");  // true
        System.out.println(f1);

        // 提取子串 索引从0开始
        String s1Sub = s1.substring(6);
        String s1Sub2 = s1.substring(6, 8);  // 开始，结束
        System.out.println(s1Sub);    // world!
        System.out.println(s1Sub2);   // wo

        // trim 去除首位空白字符 \t，\r，\n
        // strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除
        String s2 = "\r hello world!\r\n";
        System.out.println(s2.trim());

        // 判断字符串是否为空、空白字符串
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        // 替换子串 replace()  replaceAll()
        String res = s1.replace("l","x");
        String res2 = s1.replace("llo","x");
        System.out.println(res);    // hexxo worxd!
        System.out.println(res2);    // hex world!   s1还是以前的不影响

        // 分割字符串为数组 split()
        String s3 = "a-v-d-a-e-tsdf";
        String[] s3s = s3.split("-");
        System.out.println(Arrays.toString(s3s));  // [a, v, d, a, e, t]
        System.out.println(Arrays.toString(s1.split(" ")));  // [hello, world!]

        // 数组拼接成字符串 join()
        String[] s4 = {"as", "cs", "ov"};
        String s4s = String.join("",s4);
        String s4ss = String.join(",",s4);
        System.out.println(s4s);      // ascsov
        System.out.println(s4ss);     // as,cs,ov

        // 格式化字符串 替换占位符，然后生成新的字符串
        String s5 = "你好，%s朋友，年龄%d的朋%dd朋友友!";
        System.out.println(String.format(s5, "修哥", 18, 19));
        System.out.printf(s5, "修哥", 18, 19);

        // 类型转换
        // 任意基本类型或引用类型转换为字符串
        String.valueOf(123);  // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"

        // 字符串转换为int，就需要根据情况,如果是非法的（无法转换任何进制的）字符串，就报错
        Integer.parseInt("234");  // 234
        Integer.parseInt("ff", 16);  // 按十六进制转换，255

        // 字符串转换为Boolean
        Boolean.valueOf("wer");  // false
        Boolean.valueOf("TRUE"); // true
        Boolean.parseBoolean("sdf"); // false
        Boolean.parseBoolean("truE");// true

        // 转换为char[]：字符串在String内部是通过一个char[]数组表示的
        char[] c1 = {'a','b','c'};
        String s6 = new String(c1);
        System.out.println(s6);    // abc

        String s7 = "你好啊djx";
        char[] c2 = s7.toCharArray();
        System.out.println(c2);   // 你好啊djx

        // 把字符串转换编码byte[]
        // Java的String和char在内存中总是以Unicode编码表示
        // char类型实际上就是两个字节的Unicode编码
        String s8 = "shyZ大哥";
        byte[] bb = s8.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bb));  // [115, 104, 121, 90, -27, -92, -89, -27, -109, -91]

        // 把已知编码的byte[]转换成String
        String s9 = new String(bb, StandardCharsets.UTF_8);
        System.out.println(s9);                  // shyZ大哥
    }

    // 通过new String(c1)创建的s1会复制一个新的值，修改外部c1不会影响s1
    // Java字符串String是不可变对象,对他的操作不改变原内容，而是返回新字符串（查找、替换、大小写转换等）
    // 从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用,参考FUNC5
    public static void func4() {

        char[] c1 = {'a', 'v', 'e'};
        String s1 = new String(c1);
        System.out.println(s1);    // ave

        c1[1] = '改';
        System.out.println(s1);    // ave
    }

    // 使用int[]测试,如果更改了外部的n，会影响Score s的值，因为是直接传的引用
    // 针对传入有可能改变的对象，需要复制一份：在传入Score之前Arrays.copyOf、或者在Score对象中进行copy
    public static void func5() {
        int[] n = {11,22,33,44,55};
        Score s = new Score(n);
        System.out.println(Arrays.toString(s.getScore()));  // [11, 22, 33, 44, 55]

        n[1] = 999;
        System.out.println(Arrays.toString(s.getScore()));  // [11, 999, 33, 44, 55]
    }
}

class Score {
    private int[] scores;
    public Score(int[] s) {
        // this.scores = s;
        this.scores = Arrays.copyOf(s, s.length);
    }

    public int[] getScore() {
        return this.scores;
    }
}
