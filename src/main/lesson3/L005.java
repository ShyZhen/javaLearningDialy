package src.main.lesson3;

public class L005 implements Person,Man {
    public static void main(String[] args) {
        System.out.println("面向对象 - lesson5 接口");
        dispatch();
    }


    public static void dispatch() {
        func1();
    }

    public static void func1() {
        L005 l005 = new L005();
        System.out.println(l005.getName());     // 实现接口getName方法
        System.out.println(Person.getAge());    // 20 静态方法不能被子接口、类继承，调用形势：接口名.静态方法名
        l005.run();                             // 实现接口run方法
        System.out.println(l005.getSex(9));     // 女
        l005.defaultFunc();                     // default 方法重写
    }

    @Override
    public String getName() {
        return "实现接口getName方法";
    }

    @Override
    public void run () {
        System.out.println("实现接口run方法");
    }

    @Override
    public String getSex(int n) {
        String sex;
        if (n == 0) {
            sex = "男";
        } else {
            sex = "女";
        }
        return sex;
    }

    @Override
    public void defaultFunc() {
        System.out.println("default 方法重写");
    }
}




// 接口不能有字段
// 如果一个抽象类没有字段，所有方法全部都是抽象方法,就可以改写为接口interface
// 一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface
interface Person {
    String getName();

    // 定义静态函数需要写函数体body
    // 允许通过将相关的方法内聚在接口中，而不必创建新的对象
    static int getAge() {
        return 0;
    }

    void run();

    // default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改。
    // 只在需要的地方进行调用、重写即可
    default void defaultFunc() {
        System.out.println("default 方法，继承者不强制重写");
    }
}

interface Man {
    String getSex(int type);
}
