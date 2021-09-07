package src.main.lesson2;

import java.util.Arrays;

// 数组操作
public class L003 {
    public static void main(String[] args) {
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
        func4();
        func5();
    }

    // 直接打印数组变量，得到的是数组在JVM中的引用地址
    public static void func1() {
        int[] arr1 = {22,33,44,55};

        // 直接打印是jvm中的引用地址
        System.out.println(arr1);                    // 例如：[I@1b6d3586

        // 可以使用foreach循环打印
        for (int n : arr1) {
            System.out.print(n + ", ");              // 22, 33, 44, 55,
        }

        // 使用java标准库
        System.out.println(Arrays.toString(arr1));  // [22, 33, 44, 55]
    }

    // 冒泡排序
    // 每一轮循环后，最大/最小的一个数被交换到末尾，因此，下一轮循环就可以“刨除”最后的，第二次循环可以-1-i
    public static void func2() {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        int temp;

        for (int i=0; i < ns.length-1; i++) {
            for (int j=0; j < ns.length-1-i; j++) {

                // 顺序，如果【前面】的大于【后面】的，就给他调换位置
                if (ns[j] > ns[j+1]) {
                    temp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = temp;
                }

                // 倒序，如果【后面】的大于【前面】的，就给他调换位置
                if (ns[j] < ns[j+1]) {
                    temp = ns[j+1];
                    ns[j+1] = ns[j];
                    ns[j] = temp;
                }

            }
        }

        // 排序后:
        System.out.println(Arrays.toString(ns));
    }

    // 使用内置库排序
    // 对数组排序实际上修改了数组本身，如果对string[]字符串数组排序，数据在内存中位置没变化，改变的是数组的指针
    public static void func3() {
        int [] arr2 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    // 多维数组
    public static void func4() {
        int[][] arrs = {
                {23,33,44},
                {123,133,144,129},
                {223,233,244,333,222},
        };

        System.out.println(arrs.length);                // 3
        System.out.println(Arrays.deepToString(arrs));  // [[23, 33, 44], [123, 133, 144, 129], [223, 233, 244, 333, 222]]
        System.out.println(arrs[2][3]);                 // 333
    }

    // 计算每个学生的平均分
    public static void func5() {

        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };

        double average = 0;
        double allScoresSum = 0;
        for (int[] val: scores) {
            // 每个学生的总分数
            double temp = 0;
            for (int s: val) {
                temp +=s;
            }
            // 每个学生的平均分之和
            allScoresSum += temp / val.length;
        }

        // 除以学生个数
        average = allScoresSum/scores.length;

        System.out.println(average);
        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }



}
