package src.main.lesson9;

import java.util.*;

/**
 * 使用 Collections 工具类
 *
 * @Author zhenhuaixiu
 * @Date 2022/3/7 10:25
 * @Version 1.0
 */
public class CollectionsTest {
    public static void main(String[] args) {
        //func1();
        //func2();
        //func3();
        func4();
    }


    // 创建空集合 要注意到返回的空集合是不可变集合，无法向其中添加或删除元素
    public static void func1() {

        // 创建空List：List<T> emptyList()
        // 创建空Map：Map<K, V> emptyMap()
        // 创建空Set：Set<T> emptySet()

        List<String> list = List.of();
        List<String> list1 = Collections.emptyList();


        // list.add("wsedrf");
        // list1.add("wsedrf");

        System.out.println(list);
        System.out.println(list1);
    }

    // 创建单元素集合，跟空集合一样，也是不可变集合，无法向其中添加或删除
    public static void func2() {

        List<String> list1 = List.of("apple");
        List<String> list2 = Collections.singletonList("apple");
        System.out.println(list1);
        System.out.println(list2);

        // List.of()无法进行添加和删除
        // stringList.add("23s");
        // System.out.println(stringList);


        /*
        List<String> list1 = List.of(); // empty list
        List<String> list2 = List.of("apple"); // 1 element
        List<String> list3 = List.of("apple", "pear"); // 2 elements
        List<String> list4 = List.of("apple", "pear", "orange"); // 3 elements
        */
    }

    // Collections 排序
    // Collections可以对List进行排序。因为排序会直接修改List元素的位置，因此必须传入可变List
    public static void func3() {
        // 不可更改，则不能进行排序
        // List<String> list4 = List.of("apple", "pear", "orange", "zzz", "abb", "bbb");
        // System.out.println(list4);    // [apple, pear, orange, zzz, abb, bbb]

        // 报错，因为list4是不可变的
        // Collections.sort(list4);
        // System.out.println(list4);


        // 使用可变列表
        List<String> list5 = new ArrayList<>();
        list5.add("apple");
        list5.add("pear");
        list5.add("orange");
        list5.add("zzz");
        list5.add("abb");
        list5.add("bbb");
        System.out.println(list5);    // [apple, pear, orange, zzz, abb, bbb]

        Collections.sort(list5);
        System.out.println(list5);    // [abb, apple, bbb, orange, pear, zzz]

        Collections.sort(list5, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Objects.equals(o1, o2)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        System.out.println(list5);    // [zzz, pear, orange, bbb, apple, abb]
    }


    // 洗牌 随机打乱内部顺序
    public static void func4() {
        // 使用可变列表
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        list.add("zzz");
        list.add("abb");
        list.add("bbb");
        // 洗牌前:
        System.out.println(list);    // [apple, pear, orange, zzz, abb, bbb]

        // 洗牌后:
        Collections.shuffle(list);
        System.out.println(list);    // 每次不同 随机顺序 [orange, apple, abb, bbb, zzz, pear]
    }
}
