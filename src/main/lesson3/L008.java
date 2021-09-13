package src.main.lesson3;

public class L008 {
    private String name = "内嵌类可以访问私有化属性";
    private static String name2 = "静态内部类可以访问静态属性";

    public static void h1() {
        System.out.println("同级下的package，不需要引入即可访问");
    }

    // 内部类
    class Inner {
        public void h1() {
            System.out.println("内嵌类，使用时候必须先实例化父级."+ L008.this.name);
        }
    }

    // 静态内部类
    static class Inner2 {
        public void h1() {
            System.out.println("静态内部类，不需要实例化父级."+L008.name2);
        }
    }

    // 匿名函数
    public void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, 匿名函数."+L008.this.name);
            }
        };
        new Thread(r).start();
    }
}
