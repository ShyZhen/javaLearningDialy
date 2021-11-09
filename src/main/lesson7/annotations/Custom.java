package src.main.lesson7.annotations;

import java.lang.annotation.*;

/**
 * 自定义注解 @interface语法来定义注解
 * 仅有一个public 注解与文件同名
 *
 * 元注解：
 *   1. @Target可以定义Annotation能够被应用于源码的哪些位置 类或接口、字段、方法、构造函数、方法参数等
 *   2. @Retention定义了Annotation的生命周期（默认CLASS）,自定义注解的通常是RUNTIME。 仅编译期SOURCE，仅class文件CLASS，运行期RUNTIME
 *   3. @Repeatable这个元注解可以定义Annotation是否可重复(不常用)。比如多个@Custom().
 *   4. @Inherited定义子类是否可继承父类定义的Annotation,仅针对@Target(ElementType.TYPE)类型（类或接口），并且仅针对class的继承
 *
 * @Author zhenhuaixiu
 * @Date 2021/10/28 16:33
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
public @interface Custom {
    // 把最常用的参数定义为value()，推荐所有参数都尽量设置默认值
    // 必须设置@Target和@Retention，@Retention一般设置为RUNTIME，因为我们自定义的注解通常要求在运行期读取。
    // 一般情况下，不必写@Inherited和@Repeatable
    int type() default 0;
    String level() default "info";
    String value() default "";
}








@Target({ElementType.ANNOTATION_TYPE})
@interface ReportNew {
    int type() default 0;
    String level() default "info";
    String value() default "";
}