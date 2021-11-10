package src.main.lesson7;

import src.main.lesson6.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhenhuaixiu
 * @Date 2021/11/9 10:00
 * @Version 1.0
 */
// Java的泛型是采用擦拭法实现的
public class FanXing {
    public static void main(String[] args) {
        //func1();
        //func2();
        //func3();
        func5();
    }

    // ArrayList，它可以看作“可变长度”的数组
    // (没有泛型) 需要强制转型
    public static void func1() {
        ArrayList list1 = new ArrayList();
        list1.add("hello");
        list1.add(19);

        // 强制转型
        String val1 = (String) list1.get(0);
        Integer val2 = (Integer) list1.get(1);

        System.out.println(val1);    // hello
        System.out.println(val2);    // 19

        System.out.println(list1);   // [hello, 19]
    }

    // (使用泛型) 编译器将针对类型做检查，则不需要强制转型
    public static void func2() {
        ArrayList<String> list1 = new ArrayList<String>();

        list1.add("只能是字符串类型");
        list1.add("4");

        String val1 = list1.get(0);
        String val2 = list1.get(1);

        System.out.println(val1);    // 只能是字符串类型
        System.out.println(val2);    // 4

        System.out.println(list1);    // [只能是字符串类型, 4]
    }

    // 难度升级，泛型放自定义对象实例
    public static void func3() {
        ArrayList<Person> personArrayList = new ArrayList<Person>();

        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "张三";
        p2.name = "李四";

        personArrayList.add(p1);
        personArrayList.add(p2);


        Person val1 = personArrayList.get(0);
        Person val2 = personArrayList.get(1);

        System.out.println(val1.name);  // 张三
        System.out.println(val2.name);  // 李四

        System.out.println(personArrayList);    // [只能是字符串类型, 4]
    }

    // 向上转型为list
    // 所有list继承类都使用List向上转型的话，方便后续修改，比如把ArrayList改成其他实现类。
    // （转型后只能使用List类中定义的接口，实现类自定义的方法不能使用）
    // 泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）
    public static void func4() {
        // 可以省略后面的Person，编译器可以自动推断泛型类型：
        List<Person> personList = new ArrayList<>();
    }



    // 泛型的局限性
    // - Java的泛型是由编译器在编译时实行的，编译器内部永远把所有类型T视为Object处理，但是，在需要转型的时候，编译器会根据T的类型自动为我们实行安全地强制转型
    // - 无法取得带泛型的Class,getClass()后都是Person<Object>类型
    // - 不能实例化T类型，必须借助额外的Class<T>参数
    public static void func5() {
        // 由于java的泛型实现方式是擦拭法，即统统按照Object处理泛型，在需要转型的时候，根据T的类型自动安全强制转型。
        // 所以泛型支持的不能是基本类型，比如int、char、byte等等，因为基本类型并不继承Object,需要使用对应的引用类型
        // List<int> ints = new ArrayList<>();   // 会报错

        List<Integer> integers = new ArrayList<>();


        // 无法取得带泛型的Class,都是Pair<Object>
        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1==c2); // true
        System.out.println(c1==Pair.class); // true



        // extends通配符
        Pair<Integer> p3 = new Pair<>(123, 456);
        Pair<? extends Object> p4 = new Pair<>("Hello", "world");
        Pair<? extends Number> p5 = new Pair<>(33,22);

        PairNew<Integer> p6 = new PairNew<>(33,22);
        // PairNew<String> p7 = new PairNew<>("sss", "fff");  // 报错，因为已经限制了泛型为继承Number

    }
}





// 编写泛型类
class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}


//使用类似<? extends Number>通配符作为方法参数时表示：
//方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
//方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
//即一句话总结：使用extends通配符表示可以读，不能写。
//使用类似<T extends Number>定义泛型类时表示：
//泛型类型限定为Number以及Number的子类。
class PairNew<T extends Number> {
    private T first;
    private T last;
    public PairNew(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}

