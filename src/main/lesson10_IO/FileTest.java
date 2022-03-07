package src.main.lesson10_IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @Author zhenhuaixiu
 * @Date 2022/3/7 14:30
 * @Version 1.0
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //func1();
        //func2();
        //func3();
        //unc4();
        func5();
    }

    public static void func1() {
        // 根据当前平台打印"\"或"/"
        //System.out.println(File.separator);

        // 绝对路径和相对路径都可以
        File file = new File("src/main/lesson10_IO/temp.txt");
        //File file2 = new File("E:\\githubShyzhen\\javaLearningDialy\\src\\main\\lesson10_IO\\temp.txt");


        // 调用isFile()，判断该File对象是否是一个已存在的文件，调用isDirectory()，判断该File对象是否是一个已存在的目录：
        System.out.println(file.isFile());       // TRUE
        System.out.println(file.isDirectory());  // FALSE


        // boolean canRead()：是否可读；
        // boolean canWrite()：是否可写；
        // boolean canExecute()：是否可执行；
        // long length()：文件字节大小。
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.length());
    }

    // 创建和删除文件
    public static void func2() throws IOException {
        File file = new File("src/main/lesson10_IO/temp-new.txt");
        if (!file.isFile()) {
            if (file.createNewFile()) {
                // 创建成功，进行操作
            } else {
                throw new IOException("创建文件失败");
            }
        } else {
            // 文件已经存在，进行其他操作
            System.out.println("已经存在了");

            if (file.delete()) {
                System.out.println("删除成功");
            }
        }


        // 读写一哥临时文件，再JVM退出时自动删除该文件
        File tempFile = File.createTempFile("temp-", ".txt");  // 临时文件的前缀和后缀
        tempFile.deleteOnExit();                                   // JVM退出时自动删除
        System.out.println(tempFile.isFile());
        System.out.println(tempFile.getAbsolutePath());
    }


    // 遍历文件和目录
    // 当File对象表示一个目录时，可以使用list()和listFiles()列出目录下的文件和子目录名
    // listFiles()提供了一系列重载方法，可以过滤不想要的文件和目录
    public static void func3() {
        java.io.File file = new File("src/main/lesson10_IO");

        System.out.println(Arrays.toString(file.list()));     // [FileTest.java, temp-new.txt, temp.txt]
        System.out.println(Arrays.toString(file.listFiles()));// [src\main\lesson10_IO\FileTest.java, src\main\lesson10_IO\temp-new.txt, src\main\lesson10_IO\temp.txt]


        // 过滤
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //System.out.println(dir);      // src\main\lesson10_IO
                //System.out.println(name);     // FileTest.java | temp-new.txt | temp.txt
                return name.endsWith("java");
            }
        });

        if (files != null) {
            for (File fileName:files) {
                System.out.println(fileName);  // src\main\lesson10_IO\FileTest.java
            }
        }
    }


    // boolean mkdir()：创建当前File对象表示的目录；
    // boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
    // boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
    public static void func4() {
        java.io.File file = new File("src/main/lesson10_IO/aaa");
        System.out.println(file.mkdir());

        java.io.File file2 = new File("src/main/lesson10_IO/bbb/vvv/ddd");
        System.out.println(file2.mkdirs());
    }


    // Path对象 与File类似，操作更简单
    public static void func5() {
        Path path = Paths.get("src/main/lesson10_IO");
        System.out.println(path);
        System.out.println(path.toAbsolutePath());    // 转换为绝对路径
        System.out.println(path.normalize());         // 转换为规范路径

        File file = path.toFile();                    // 转换为File对象
        System.out.println(Arrays.toString(file.list()));   // [FileTest.java, temp-new.txt, temp.txt]
    }
}
