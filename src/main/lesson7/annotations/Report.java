package src.main.lesson7.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zhenhuaixiu
 * @Date 2021/11/8 16:14
 * @Version 1.0
 */

// Retention 运行生命周期：
// SOURCE类型的注解在编译期就被丢掉了；
// CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM；
// RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int num() default  0;
    String value()default  "";
}
