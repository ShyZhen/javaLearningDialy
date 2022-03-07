package src.main.lesson9;

import java.util.Iterator;
import java.util.List;

/**
 * @Author zhenhuaixiu
 * @Date 2022/3/4 16:45
 * @Version 1.0
 */
public class IteratorTest {
    public static void main(String[] args) {
        func1();
    }

    // Java的集合类都可以使用for each循环，List、Set和Queue会迭代每个元素，Map会迭代每个key。
    public static void func1() {
        List<String> list = List.of("aaa","vvv","sss","bbb");
        System.out.println(list.get(0));

        // for each会自动编译成迭代器iterator
        for (String key: list) {
            System.out.println(key);
        }

        //
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
