package src.main.lesson3.classServer;

public class Mobile extends BaseServer {

    public Book book;

    // 重写父类字段或者方法
    public int price;

    public String name = "子类名";

    // 任何class的构造方法，第一行语句必须是调用父类的构造方法
    // 如果没有，编译器会帮我们自动加一句super()调用父类构造方法
    public Mobile() {
        super();
        System.out.println("Mobile构造函数"+this.price);
    }

    public String getName() {
        return this.name + super.name;
    }

    public void setBook() {
        this.book = new Book("手机的维护", 88);
    }

    public Book getBook() {
        return this.book;
    }

    // 加上@Override可以让编译器帮助检查是否进行了正确的覆写,不是必须的
    @Override
    public String ovrd() {
        return "mobile的ovrd方法，重写override";
    }

    public String ovrd(String str) {
        return "由于参数不同，不是重写，是一个新方法";
    }

    // 用final修饰的方法不能被Override
    // 用final修饰的类不能被继承
//    public String noOvrd() {
//        return "final 不允许子类重写的方法";
//    }

}
