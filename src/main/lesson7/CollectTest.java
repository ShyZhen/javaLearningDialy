package src.main.lesson7;

import java.util.*;

/**
 * Java的集合类型。集合类型也是Java标准库中被使用最多的类型
 *
 * @Author zhenhuaixiu
 * @Date 2021/11/17 14:47
 * @Version 1.0
 */
public class CollectTest {
    public static void main(String[] args) {
        func1();
    }

    public static void func1() {
        String[] strings = new String[5];
        Integer length = strings.length;
        strings[0] = "hello";

        System.out.println(length);                        // 5
        System.out.println(Arrays.toString(strings));      // [hello, null, null, null, null]


        // 数组初始化后大小不可变；
        // 数组只能按索引顺序存取。
        String[] strings2 = new String[]{"sdf", "ss", "ff", "aa"};  // 定义以后长度不可变，就是4
        System.out.println(strings2[1]);
        System.out.println(strings2.length);
        System.out.println(Arrays.toString(strings2));
    }


    // 由于：数组初始化后大小不可变；数组只能按索引顺序存取
    // 因此，我们需要各种不同类型的集合类来处理不同的数据
    // 可变大小的顺序链表
    // 保证无重复元素的集合
    // ...
    // java标准库自带的java.util包提供了集合类：Collection,他是除Map外所有其他集合类的跟接口，如list
    public static void func2() {
        // java.util包主要提供了以下三种类型的集合
        // List：一种有序列表的集合，例如，按索引排列的Student的List；
        // Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
        // Map：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。



        // 我们要注意到有一小部分集合类是遗留类，不应该继续使用
        // Hashtable：一种线程安全的Map实现；
        // Vector：一种线程安全的List实现；
        // Stack：基于Vector实现的LIFO的栈。
        List<String> strings = new ArrayList<>();



        // Java的集合类定义在java.util包中，支持泛型，主要提供了3种集合类，包括List，Set和Map。Java集合使用统一的Iterator遍历，尽量不要使用遗留接口
    }


}
