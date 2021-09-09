package src.main.lesson3.classServer;

public class BaseServer {

    public final String str;

    public int price = 90;

    protected String name = "父类名字";

    public BaseServer() {
        this.str = "用final修饰的字段在初始化后不能被修改,可以不给值，然后在构造方法中初始化final字段";
        System.out.println("BaseServer构造函数"+this.price);
    }

    public String ovrd() {
        return "子类定义了一个完全相同（返回类型、参数）的方法，就是重写override，也称为多态";
    }

    public final String noOvrd() {
        return "final 不允许子类重写的方法";
    }

}
