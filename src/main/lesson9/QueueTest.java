package src.main.lesson9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 * @Author zhenhuaixiu
 * @Date 2022/3/4 14:15
 * @Version 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        //func1();
        //func2();
        func3();
    }

    // 队列 Queue 先进先出
    // List可以在任意位置进行添加和删除元素，而Queue只有两个操作：把元素添加到末尾 和 从头部取出元素
    public static void func1() {
        // 在Java的标准库中，队列接口Queue定义了以下几个方法：
        //
        // int size()：获取队列长度；
        // boolean add(E) / boolean offer(E)：添加元素到队尾；
        // E remove() / E poll()：获取队首元素并从队列中删除；
        // E element() / E peek()：获取队首元素但并不从队列中删除。
        //
        // add 这套方法会抛出异常，而offer 只会返回真假，poll peek获取的时候如果没有也仅仅返回null，不会出异常

        Queue queue = new LinkedList();
        queue.add("Apple");
        queue.add("Cherry");
        queue.add("Pear");
        queue.offer("Phone");
        queue.offer("Computer");

        System.out.println(queue);  // [Apple, Cherry, Pear, Phone, Computer]

        queue.remove("Pear");       // [Apple, Cherry, Phone, Computer]
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);  // [Cherry, Phone, Computer]
    }

    // 带有优先级的队列 PriorityQueue [praɪˈɔːrəti kjuː]
    public static void func2() {
        // Queue<String> stringQueue = new LinkedList<>();
        Queue<String> stringQueue = new PriorityQueue<>();

        stringQueue.offer("ab");
        stringQueue.offer("sssss");
        stringQueue.offer("sss");
        stringQueue.offer("aaaa");
        stringQueue.offer("bbb");

        System.out.println(stringQueue);
        System.out.println(stringQueue.poll());  // aaaa
        System.out.println(stringQueue.poll());  // ab
        System.out.println(stringQueue.poll());  // bbb
        System.out.println(stringQueue.poll());  // sss
        System.out.println(stringQueue.poll());  // sssss
        System.out.println(stringQueue.poll());  // null
    }

    // Java集合提供了接口Deque来实现一个双端队列，它的功能是：
    //
    // 既可以添加到队尾，也可以添加到队首；
    // 既可以从队首获取，又可以从队尾获取。
    //
    // 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
    // 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
    // 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
    // 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
    // 避免把null添加到队列。
    public static void func3() {
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("aaaa");
        deque.offerFirst("bbbb");
        deque.offerFirst("ccc");
        deque.offer("ccc");
        deque.offerLast("EEE");
        System.out.println(deque);

    }

    // 栈 Stack
    // 后进先出，电梯
    // 只能不断地往Stack中压入（push）元素，最后进去的必须最早弹出（pop）【不弹出使用peek()】
    public static void func4() {
        // 使用Deque
    }
}
