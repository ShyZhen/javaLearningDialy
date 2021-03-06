package src.main.lesson6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

// 反射：反射就是Reflection，Java的反射是指程序在运行期可以拿到一个对象的所有信息。
// 反射是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法
public class L001 {

    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        dispatch();
    }

    private static void dispatch() {
//        func1();
//        func4();
//        func6();
//        func7();
//        func8();
//        func9();
//        func10();
        func11();
    }

    private static void func1() {
        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("小明");

        System.out.println(func2(p1));
    }

    // 传入对象参数
    private static String func2(Person person) {
        return person.intro();
    }

    // class的本质是数据类型（type），包括interface。
    private static void func3() {

        // Double d = new Number(23);
        // Number n = new Double(23);

        // 无继承关系的数据类型无法赋值
        // Number n2 = new String("23");

        // class 是由jvm在执行过程中动态加载的，jvm在第一次读取到一种class类型时，将期加载到内存。
        // 每加载一种class，jvm就为其创建一个class的【实例】，并关联起来。注意：这里的class类型是一个名叫`Class`的class。
        // 只有jvm能创建`Class`实例。
        // public final class Class {
        //    private Class() {
        //
        //    }
        // }

        // 当JVM加载String类时，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来
        // Class cls = new Class(String);



        // 反射 Reflection
        // 由于jvm为每个加载的class创建了对应的`Class`实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现接口、方法、字段等，因此，
        // 如果获取了某个`Class`实例，就可以通过这个`Class`实例获取到对应的class的所有信息。
        // 这种通过`Class`实例获取class信息的方法称为反射。
    }


    // 获取class的Class实例，的三个方法
    private static void func4() {
        // 方法一：直接通过一个class的静态变量class获取
        Class cls1 = String.class;
        L001.logger.info(cls1.getPackageName());

        Person p1 = new Person();
        L001.logger.info(p1.name);

        // 方法二：有实例变量，通过该实例提供的`getCLass()`方法获取
        Class cls2 = p1.getClass();
        System.out.println(cls2);
        System.out.println(p1.getClass());

        Object obj1 = new Person();
        System.out.println(obj1.getClass());

        // 方法三：有class的完整类名，通过静态方法Class.forName()获取
        String s1 = (String.valueOf(cls2));
        try {
            Class cls3 = Class.forName(s1);
            Class cls4 = Class.forName("java.lang.String");
            System.out.println(cls3);
        } catch (ClassNotFoundException e) {
            System.out.println("没有这个类");
        }
    }

    private static void func5() {
        // 因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例
        Class cls1 = String.class;

        String s1 = "asdfkljsadflkj";
        Class cls2 = s1.getClass();

        System.out.println(cls2 == cls1);   // true



        // 用instanceof不但匹配指定类型，还匹配指定类型的子类。而用==判断class实例可以精确地判断数据类型，但不能作子类型比较
        // 因为反射的目的是为了获得某个实例的信息。因此，当我们拿到某个Object实例时，我们可以通过反射获取该Object的class信息
        Integer n = new Integer(123);

        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number;  // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
        // boolean b4 = n.getClass() == Number.class;  // false，因为Integer.class!=Number.class
    }


    // 要从Class实例获取获取的基本信息，参考下面的代码
    private static void func6() {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }
    private static void printClassInfo(Class cls) {
        System.out.println("----------------------");
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("----------------------");
    }


    // 这就是JVM动态加载class的特性:
    // jvm在执行java程序的时候，不是一次性把所有类加载到内存，而是第一次需要使用到的时候才加载。




    // 通过类获取字段
    // Field getField(name)：根据字段名获取某个public的field（包括父类）
    // Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
    // Field[] getFields()：获取所有public的field（包括父类）
    // Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
    private static void func7() {
        Class cls1 = Person.class;

        Person p1 = new Person();
        Class cls2 = p1.getClass();

        try {
            // 获取private字段"grade":
            System.out.println(cls1.getDeclaredField("grade"));

            // 获取public字段、继承的public字段
            System.out.println(cls2.getField("bio"));
            System.out.println(cls2.getField("name"));
            System.out.println(cls1.getField("age"));

            // 获取所有public的field（包括父类）
            System.out.println(Arrays.toString(cls1.getFields()));




            // 一个Field对象包含了一个字段的所有信息
            // getName()：返回字段名称，例如，"name"；
            // getType()：返回字段类型，也是一个Class实例，例如，String.class；
            // getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义
            Field ageField = cls1.getField("age");
            System.out.println(ageField.getName());
            System.out.println(ageField.getType());

            // PUBLIC=1, PRIVATE=2, PROTECTED=4, STATIC=8, FINAL=16, SYNCHRONIZED=32, VOLATILE=64, TRANSIENT=128, NATIVE=256, INTERFACE=512, ABSTRACT=1024, STRICT=2048
            System.out.println(ageField.getModifiers());



            // 根据字段获取字段值
            // 先获取Class实例，再获取Field实例，然后，用Field.get(Object)获取指定实例的指定字段的值
            // Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问
            ageField.setAccessible(true);
            Object obj1 = ageField.get(p1);
            System.out.println(obj1);               // 1

            // 设置字段值
            // 修改非public字段，需要首先调用setAccessible(true)。
            ageField.set(p1, 98);
            Object obj2 = ageField.get(p1);
            System.out.println(obj2);              // 98

            // 虽然反射可以获取private的值，但是并不意味着封装没意义，因为我们平时使用p.name来访问字段，编译器会根据修饰符决定是否允许访问，比较简单，而
            // 反射是一种非常规的用法，使用反射，首先代码非常繁琐，其次，它更多地是给工具或者底层框架来使用，目的是在不知道目标实例任何信息的情况下，获取特定字段的值

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("没有这个字段");
        }
    }




    // 获取所有method信息
    // Method getMethod(name, Class...)：获取某个public的Method（包括父类）
    // Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类,但包括私有）
    // Method[] getMethods()：获取所有public的Method（包括父类）
    // Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类，但包括私有）
    private static void func8() {
        Class cls1 = Person.class;

        Person p1 = new Person();
        Class cls2 = p1.getClass();

        try {
            // 获取intro方法，携带int参数(用于区分重载)
            Method introMethod = cls1.getDeclaredMethod("intro", int.class);
            System.out.println(introMethod);

            Method introMethod2 = cls1.getMethod("intro");
            System.out.println(introMethod2);

            System.out.println(Arrays.toString(cls1.getMethods()));




            // 一个Method对象包含一个方法的所有信息：
            // getName()：返回方法名称，例如："getScore"；
            // getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
            // getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
            // getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。




        } catch (NoSuchMethodException | SecurityException e) {
            System.out.println("没有这个方法");
        }
    }

    // 通过反射 调用类方法
    // 对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致
    // 调用静态方法时,invoke方法传入的第一个参数永远为null
    public static void func9() {
        Person person = new Person();
        person.setName("实例1");
        person.setAge(20);

        Class cls = Person.class;


        try {
            // 获取intro方法，携带int参数(用于区分重载)
            Method method1 = cls.getMethod("intro");
            Method method2 = cls.getDeclaredMethod("intro", int.class);  // 私有的，只能用getDeclaredMethod
            Method method3 = cls.getDeclaredMethod("invokeTest");

            System.out.println(method1);
            System.out.println(method2);
            System.out.println(method3);

            // invoke调用
            // 调用非public方法需要先设置setAccessible
            method1.setAccessible(true);
            method2.setAccessible(true);
            method3.setAccessible(true);

            String s = (String) method2.invoke(person, 222);
            System.out.println(s);          // 重载，我叫实例1, 今年20岁
            method3.invoke(null);           // 私有、静态方法,调用
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println(e);
        }
    }


    //  调用类的构造方法
    public static void func10() {
        // 1. new操作符 自动调用构造函数
        Person person = new Person();

        try {
            // 2. Class.newInstance() 它只能调用该类的public无参数构造方法（带有参数，或者不是public则不可以）,java9将被弃用
            Person person1 = Person.class.newInstance();

            // 3. Constructor
            Constructor<Person> constructor1 = Person.class.getConstructor();
            Constructor<Person> constructor2 = Person.class.getConstructor(String.class);
            constructor1.newInstance();
            constructor2.newInstance("33333");

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e);
        }
    }

    // 通过Class对象可以获取继承关系：
    // Class getSuperclass()：获取父类类型；
    // Class[] getInterfaces()：获取当前类实现的所有接口。
    public static void func11() {
        Class<Person> cls = Person.class;

        // 获取父类
        Class classes = cls.getSuperclass();

        // 获取继承的接口们
        Class[] interfaces = cls.getInterfaces();

        System.out.println(classes);
        System.out.println(Arrays.toString(interfaces));
    }


    // 动态代理
    public static void func12() {

    }












}
