package src.main.lesson1;

import java.util.Arrays;

public class L004 {
    public static void main(String[] args) {
        System.out.println("lesson 4: array");
        dispatch();
    }

    public static void dispatch() {
        System.out.println(Arrays.toString(func1()));
        func2();
        func3();
        func4();
        func5();
        stringArr();
        exam();
    }

    // 返回数字数组
    public static int[] func1() {
        int[] arr  = new int[2];
        arr[1] = 66;
        arr[0] = 55;
        return arr;
    }

    // 数组键值不能超过定义的个数（从0开始，准确来说是等于n-1）
    public static void func2() {
        String[] arr = new String[3];
        arr[0] = "你好啊";
        arr[2] = "第三个";
        arr[1] = "大家好";

        char[] arr2 = new char[4];
        arr2[0] = 'z';
        arr2[1] = 'h';
        arr2[2] = 'x';
        arr2[3] = '发';

        byte[] arr3 = new byte[3];
        arr3[0] = 56;
        arr3[1] = 127;
        arr3[2] = -128;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    // 修改数组的某个值、默认值、长度
    public static void func3() {
        int[] arr = new int[6];
        arr[0] = 22;
        arr[1] = 33;

        System.out.println(arr.length);       // 6 （获取数组长度，是定义长度，因为就算没定义值，默认是0）
        System.out.println(arr[0] + arr[1]);  // 55
        System.out.println(arr[3]);           // 0 （数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false）

        arr[3] = 44;
        System.out.println(arr[3]);           // 44 （可以修改数组中的某一个元素，使用赋值语句，例如，arr[3] = 44）
    }

    // 直接在定义时候直接指定元素，自动推算数组长度
    public static void func4() {
        int[] arr = new int[]{22,33,44,55,66};
        int[] arr2 = {22,33,44,55,66};           // 简写
        System.out.println(arr.length);          // 5
    }

    // 数组是引用类型，并且数组大小不可变
    // 下文中函数其实没改变数组大小，而是类似字符串，只是改变了引用、指向了一个新的数组（原有的4个元素的数组并没有改变）
    // 但是，如果使用arr[1] = xx进行重新赋值，其实是改变的原本的内存地址，因为int是基本类型，与string不同
    public static void func5() {
        int[] arr;

        arr = new int[]{22,33,44,55};
        System.out.println(arr.length);  // 4

        arr = new int[]{22,33};
        System.out.println(arr.length);  // 2

        arr = new int[]{22,33,44,55,66};
        System.out.println(arr.length);  // 5
    }

    // 非基本类型数组：字符串数组
    public static void stringArr() {
        String[] arr1;
        arr1 = new String[]{"aa","bb"};

        // 快捷定义
        String[] arr2 = new String[] {"aa","bb"};
        String[] arr3 = {"aa","bb"};

        System.out.println(arr1.length);  // 5

        arr1[1] = "更改键值为1的值,只是更改他的引用";
    }

    public static void exam() {
        String[] names = {"ABC","XYZ","ZOO"};
        String s = names[1];

        System.out.println(Arrays.toString(names));  // [ABC, XYZ, ZOO]

        names[1] = "cat";

        System.out.println(Arrays.toString(names));  // [ABC, cat, ZOO]

        System.out.println(s);                       // XYZ
    }
}
