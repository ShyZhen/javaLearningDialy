package src.main.lesson3.classServer;

// 这种方法名相同，但各自的参数不同，称为方法重载 (Overload)
// 重载的返回值类型通常都是相同的
// 重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单
public class Book {
    private String name = "水浒传";  // 默认null
    private int price;              // 默认0

    // 构造函数 构造方法的名称就是类名
    // 和普通方法相比，构造方法没有返回值（也没有void）
    public Book(String name, int price) {
        System.out.println("同名初始化构造方法");

        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            this.name = "默认书名";
        } else {
            this.name = name;
        }

        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("invalid price value,必须正整数");
        }
    }

    public Book() {

    }

    // 可以调用其他构造函数, 直接传参，即调用Book(String name, int price)
    public Book(String str) {
        this(str,100);
    }

    public String intro() {
        return "大家好：" + this.name + "," + this.price;
    }

    // 同名函数重载
    public String func123(int n) {
        return "重载方法123" +n;
    }
    // 同名函数重载
    public String func123(String str) {
        return "重载方法456"+str;
    }
}