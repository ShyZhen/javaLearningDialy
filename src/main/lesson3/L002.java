package src.main.lesson3;

import src.main.lesson3.classServer.Book;

public class L002 {
    public static void main(String[] args) {
        System.out.println("面向对象 - lesson2");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
    }

    // 构造函数
    // 重载（Overload）：通过参数的不同，方法名相同，自动调用对应函数。
    // php 无法写同名函数，他的重载与大多数面向对象语言不同，是通过魔术方法实现的，如属性重载: __get() __set(),方法重载:__call() __callStatic()
    // 重写：继承父类，改写父类同名函数。
    public static void func1() {
        Book book1 = new Book("三国演义", 58);
        String intro1 = book1.intro();
        System.out.println(intro1);

        Book book2 = new Book();
        String intro2 = book2.intro();
        System.out.println(intro2);

        Book book3 = new Book("调用其他构造函数100块的");
        String intro3 = book3.intro();
        System.out.println(intro3);
    }

    public static void func2() {
        Book book = new Book();
        System.out.println(book.func123(5));
        System.out.println(book.func123("重载参数"));
    }
}
