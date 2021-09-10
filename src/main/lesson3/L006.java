package src.main.lesson3;

// 对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例

public class L006 {
    public static void main(String[] args) {
        System.out.println("面向对象 - lesson6 静态字段&静态方法");
        System.out.println("实例字段每个字段都有自己独立的空间，但是静态字段是共享的，他不属于任何一个实例");
        dispatch();
    }

    public static void dispatch() {
        func1();
    }

    // 静态字段并不属于实例,共享内存
    // 所以不推荐用[实例变量.静态字段]去访问静态字段,而是使用[类.字段],如TestBase.num
    public static void func1() {
        Test test = new Test();
        test.setNum(98);
        System.out.println(test.getNum());   // 98

        TestBase test2 = new Test();         // TestBase构造函数重载：重载构造函数  // Test构造函数
        TestBase test3 = new TestBase();     // TestBase默认没参数构造函数
        System.out.println(test2.getNum());  // 98
        System.out.println(test3.getNum());  // 98

        // 使用[类.字段] [类.静态方法]调用
        System.out.println(TestBase.num);    // 98
        System.out.println(TestBase.intDouble(55));    // 110
    }
}


class Test extends TestBase {

    public Test() {
        // 调用父类的构造函数必须在第一行，super必须在第一行。不写的话编译器自动给加。
        super("重载构造函数");
        System.out.println("Test构造函数");
    }
}

class TestBase {
    public static int num;

    public void setNum(int n) {
        Test.num +=n;
    }

    public int getNum() {
        return Test.num;
    }

    public TestBase() {
        System.out.println("TestBase默认没参数构造函数");
    }

    public TestBase(String str) {
        System.out.println("TestBase构造函数重载："+str);
    }

    public static int intDouble(int step) {
        return step * 2;
    }
}
