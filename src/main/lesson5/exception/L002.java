package src.main.lesson5.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import src.main.lesson5.exception.BaseException.UserNotFoundException;

import java.util.function.Supplier;
import java.util.logging.Logger;


public class L002 {

/*
* 标准库定义的常用异常分类

Exception
│
├─ RuntimeException             // 运行时异常不需要强制捕获
│  │
│  ├─ NullPointerException
│  │
│  ├─ IndexOutOfBoundsException
│  │
│  ├─ SecurityException
│  │
│  └─ IllegalArgumentException
│     │
│     └─ NumberFormatException
│
├─ IOException
│  │
│  ├─ UnsupportedCharsetException
│  │
│  ├─ FileNotFoundException
│  │
│  └─ SocketException
│
├─ ParseException
│
├─ GeneralSecurityException
│
├─ SQLException
│
└─ TimeoutException

*/

/*
好的编码习惯可以极大地降低Exception的产生，例如：
1. 初始化成员变量时，给初始值，如"",0等 （空字符串""而不是默认的null可避免很多NullPointerException）

*/

    // 使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量
    public static final Log log = LogFactory.getLog(L002.class);

    public static void main (String[] args) {
        dispatch();
    }

    public static void dispatch() {
        try {
            // func1(-7, "");
            // func2();
            // func3();
            func4();
        } catch (IllegalArgumentException e) {
            System.out.println("年龄只能是正整数");
        } catch (NullPointerException e) {
            System.out.println("名字不能为空");
        } catch (UserNotFoundException e) {
            System.out.println("用户不存在，自定义异常");
        }
    }

    public static void func1(int age, String name) {

        if (name.isEmpty()) {
            throw new NullPointerException();
        }
        if (age <= 0) {
            throw new IllegalArgumentException();
        }
    }

    // 自定义异常，通常通过runningTimeException派生，因为不需要强制捕获
    public static void func2() {
        throw new UserNotFoundException();
    }

    // JDK Logging 标准库日志类
    // 日志的输出可以设定级别。JDK的Logging定义了7个日志级别，从严重到普通： SEVERE WARNING INFO CONFIG FINE FINER FINEST
    // 因为默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来。
    // Logging系统在JVM启动时读取配置文件并完成初始化，一旦开始运行main()方法，就无法修改配置
    public static void func3() {
        Logger logger = Logger.getGlobal();
        logger.info("信息模式info");
        logger.warning("警告模式");
        logger.fine("被忽略ignored.");
        logger.severe("严重模式信息");
    }


    // Commons Logging 第三方日志库
    // ide 导入第三方包方案 https://blog.csdn.net/hwt1070359898/article/details/90517291
    // 它可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统
    // 默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging
    // 使用：第一步，通过LogFactory获取Log类的实例； 第二步，使用Log实例的方法打日志。
    // Commons Logging定义了6个日志级别：FATAL ERROR WARNING INFO DEBUG TRACE
    public static void func4() {
        System.out.println("第三方日志库l002");

        // 使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量
        // Log log = LogFactory.getLog(L002.class);
        // log.info("hhh");

        L002.log.info("日志开始223");
        L002.log.warn("日志结束ADF");
        L002.log.error("可以throw异常", new NullPointerException("异常"));
    }
}


