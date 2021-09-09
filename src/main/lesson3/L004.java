package src.main.lesson3;

public class L004 {
    public static void main(String[] args) {
        System.out.println("面向对象 - lesson4 抽象类");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
    }

    // 抽象的好处：具体的业务逻辑由不同的子类实现，调用者并不关心。
    public static void func1() {
        SomePeople somePeople = new Student();
        System.out.println(somePeople.name);  // mm
        somePeople.setName("曹操");
        System.out.println(somePeople.name);  // 曹操
        somePeople.getIntro();                // 继承抽象方法，必须实现抽象函数
        // somePeople.sayHello();             // 由于使用的是SomePeople somePeople = new Student()引用，他没有这个方法，参考func2
    }

    public static void func2() {
        Student somePeople = new Student();   // 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程
        somePeople.sayHello();
    }
}



abstract class SomePeople {
    public String name = "mmmmmmmm";

    public abstract void getIntro();

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends SomePeople{
    @Override
    public void getIntro() {
        System.out.println("继承抽象方法，必须实现抽象函数");
    }

    public void sayHello() {
        System.out.println("学生对其他人sayHello");
    }
}
