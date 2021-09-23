package src.main.lesson4.core;

public class L005Enum {
    public static void main(String[] arts) {
        System.out.println("枚举类型，边界值");
        func1();
        func2();
        func3();
        func4();
    }

    public static void func1() {
        System.out.println(EnumModel.BLU);
        System.out.println(EnumModel.ONE);
    }

    public static void func2() {
        EnumModel em = new EnumModel();
        System.out.println(em.intro);
    }

    public static void func3() {
        String s = WeekDay.SUN.name();  // SUN 返回常量名
        int n = WeekDay.THU.ordinal();  // 4   返回定义的常量的顺序，从0开始计数

        // 虽然是引用，但是相比较可以用 == 和 equals
        String a = "SUN";
        if (a == (WeekDay.SUN.name())) {
            System.out.println("相等");
        }

        // 给enum添加其他字段、方法等
        System.out.println(WeekDay2.MON);  // 星期一ttt1
    }

    // 一般用在switch,不需要进行name()
    public static void func4() {
        WeekDay2 day = WeekDay2.THU;

        System.out.println(day);    // 星期四ttt4

        switch (day) {
            case SUN:
                System.out.println("当前日期是sun，星期天");
                break;
            case THU:
                System.out.println("THU aaa");      // 会匹配到此处，根据name，而不是toString()
                break;
            case MON:
            case FRI:
            case SAT:
            case TUE:
            case WED:
            default:
                System.out.println("没有");
        }
    }

}

class EnumModel {
    public static final int ONE = 1;
    public static final int TWO = 2;

    public static final String RED = "red";
    public static final String BLU = "blue";

    public String intro = "非静态字段";
}

// enum定义的类型就是class,和其他class没有区别
// enum定义的枚举是引用类型
// 引用类型比较，要始终使用equals()方法，但enum类型可以例外
enum WeekDay {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}

// 因为enum本身是class，所以我们可以定义private的构造方法，并且，给每个枚举常量添加字段
enum WeekDay2 {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    WeekDay2(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    // System.out.println(WeekDay2.MON); 会直接调用这方法
    @Override
    public String toString() {
        return this.chinese + "ttt" + this.dayValue;
    }
}