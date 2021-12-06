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
        //func1();
        func3();
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


    // List 是最基本的一种集合：它是一种有序列表
    public static void func3() {
        // list 的行为和数组几乎完全相同，内部按照元素的先后顺序存放，每个元素都可以通过索引确定自己的位置，也是从0开始
        // 但是，如果我们使用数组，在添加、删除元素的时候，非常不方便，比如删除其中某个元素，实际上是把该位置后面所有元素往前挪一个位置；而添加则是往后挪（因为数组是连续的内存）；这两种操作用数组实现非常麻烦。
        // 因此，实际应用中，需要增、删的有序列表，我们使用最多的是列表ArrayList。
        // ArrayList会自动维护顺序，size元素个数，当add的时候如果数组空间不够用了，会申请一个更大的数组，直接copy过去。

        // 数组
        String[] strings = new String[5];
        strings[0] = "hh";
        strings[1] = "oo";
        strings[2] = "ee";
        System.out.println(strings[1]);    // oo

        strings[1] = "rr";
        System.out.println(strings[1]);

        // List
        List<String> list = new ArrayList<>();
        list.add("qq");
        list.add("ww");
        list.add("ee");
        System.out.println(list.get(1));    // ww

        list.set(1,"rr");                   // 修改(替换)索引为1的元素（长度不变）
        System.out.println(list);           // [qq, rr, ee]

        list.add(1, "tt");                  // 指定位置添加
        System.out.println(list);           // [qq, tt, rr, ee]

        // 元素个数、长度
        System.out.println(list.size());     // 4
        System.out.println(strings.length);  // 5

        // ArrayList把添加和删除的操作封装起来，让我们操作List类似于操作数组，却不用关心内部元素如何移动
        //在末尾添加一个元素：boolean add(E e)
        //在指定索引添加一个元素：boolean add(int index, E e)
        //删除指定索引的元素：E remove(int index)
        //删除某个元素：boolean remove(Object e)
        //获取指定索引的元素：E get(int index)
        //获取链表大小（包含元素的个数）：int size()


        // LinkedList
        // LinkedList通过“链表”也实现了List接口，内部每一个元素都指向了下一个元素。
        // 通常情况下，我们总是优先使用ArrayList。

        //                   ArrayList      LinkedList
        //
        //获取指定元素         速度很快	        需要从头开始查找元素
        //添加元素到末尾 	     速度很快          速度很快
        //指定位置插入/删除     需要移动元素      不需要移动元素
        //内存占用             少              较大
        List<String> linkedList = new LinkedList<>();
        linkedList.add("index1");
        linkedList.add("index2");
        linkedList.add("index2");
        linkedList.set(2, "index3");
        System.out.println(linkedList);

        // for遍历list：一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢
        // 所以推荐使用迭代器 Iterator
        Integer size = linkedList.size();
        for (int i = 0; i < size; i++) {
            String s = linkedList.get(i);
            System.out.println(s);
        }

        // Iterator 是所有集合类都能使用的。他知道如何遍历一个list，不同的list类型返回的实例对象也是不同的，总有最高的访问效率
        // Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 以上两种方式等价于for each
        // Java的for each循环本身就可以帮我们使用Iterator遍历
        for (String s : linkedList) {
            System.out.println(s);
        }








        // 装入数组 array
        Integer size2 = linkedList.size();
        String[] array = linkedList.toArray(new String[5]);  // 一般会存入size，正好的个数。如果大于size，补null
        System.out.println(Arrays.toString(array));    // [index1, index2, index3, null, null]
    }


}
