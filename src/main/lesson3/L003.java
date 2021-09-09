package src.main.lesson3;

import src.main.lesson3.classServer.BaseServer;
import src.main.lesson3.classServer.Book;
import src.main.lesson3.classServer.Mobile;

public class L003 {

    public static void main(String[] args) {
        System.out.println("面向对象 - lesson3 继承");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
        func4();
        func5();
        func6();
    }

    public static void func1() {
        System.out.println("执行func1");
        Mobile mobile = new Mobile();
        // 输出如下：
        // 面向对象 - lesson3 继承
        // 执行func1
        // BaseServer构造函数90
        // Mobile构造函数0
    }

    public static void func2() {
        Mobile mobile = new Mobile();
        System.out.println("func2:"+mobile.getName());  // 子类名父类名字

        mobile.setBook();
        Book mobileBook = mobile.getBook();
        System.out.println("func2:"+mobileBook.intro());  // 大家好：手机的维护,88
    }

    // 子类定义了一个完全相同（返回类型、参数）的方法，就是重写override
    public static void func3() {
        Mobile mobile = new Mobile();
        System.out.println("func3:"+mobile.ovrd());
    }

    // 多态: 针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
    // 多态的特性就是，运行期才能动态决定调用的子类方法
    public static void func4() {
        // 向下转型会失败，不能把父类变为子类，因为子类功能比父类多，报错：ClassCastException
        // Mobile mobile = (Mobile) new BaseServer();
        // System.out.println(mobile.ovrd());

        BaseServer baseServer = new Mobile();
        System.out.println("func4:"+baseServer.ovrd());  // func4:mobile的ovrd方法，重写override
    }

    // 多态的例子,计算交的税
    // 如果我们要新增一种稿费收入，只需要从Income派生，然后正确覆写getTax()方法就可以。把新的类型传入totalTax()，不需要修改任何代码。
    // php 的多态体现在对参数的【类型约束】，传入一个对象实例，调用对象共同拥有的方法（一般是继承、重写后的）
    public static void func5() {
        Duotai.handle();
    }

    public static void func6() {
        Mobile mobile = new Mobile();
        System.out.println(mobile.noOvrd());
    }
}
