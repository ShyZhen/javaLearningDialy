// 包，内部类，静态内部类，匿名类

// 在Java虚拟机执行的时候，JVM只看完整类名，因此，只要包名不同，类就不同。
package src.main.lesson3;

public class L007 {
    public static void main(String[] args) {
        // 同级下的package，不需要import引入即可访问
        L008.h1();

        // 内嵌类，使用时候必须先实例化父级
        L008 l008 = new L008();
        L008.Inner inner = l008.new Inner();
        inner.h1();

        // 静态内部类，不需要实例化父级
        L008.Inner2 inner2 = new L008.Inner2();
        inner2.h1();

        // 匿名函数
        l008.asyncHello();
    }
}
