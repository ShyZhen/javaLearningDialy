package src.main.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author zhenhuaixiu
 * @Date 2022/3/3 14:57
 * @Version 1.0
 */
public class TreeMapTest {
    public static void main(String[] args) throws IOException {
        //func1();
        //func2();
        //func3();
        func4();
        func5();
    }

    // SortedMap，它在内部会对Key进行排序。注意到SortedMap是接口，它的实现类是TreeMap。
    // String默认按字母排序
    public static void func1() {
        //SortedMap<String, Integer> stringStudentSortedMap = new TreeMap<>();
        Map<String, Integer> stringStudentSortedMap = new TreeMap<>();
        stringStudentSortedMap.put("zzz", 9191);
        stringStudentSortedMap.put("aaa", 9999);
        stringStudentSortedMap.put("ccc", 8888);
        stringStudentSortedMap.put("bbb", 7777);

        System.out.println(stringStudentSortedMap);

        for (String key : stringStudentSortedMap.keySet()) {
            System.out.println(stringStudentSortedMap.get(key));  // 9999 7777 8888 9191
        }
    }

    // inter默认从小到大排序
    public static void func2() {
        //SortedMap<String, Integer> stringStudentSortedMap = new TreeMap<>();
        Map<Integer, String> stringStudentSortedMap = new TreeMap<>();
        stringStudentSortedMap.put(91, "dddd");
        stringStudentSortedMap.put(9999, "aaa");
        stringStudentSortedMap.put(8888, "ccc");
        stringStudentSortedMap.put(7777, "bbb");

        System.out.println(stringStudentSortedMap);

        for (Integer key : stringStudentSortedMap.keySet()) {
            System.out.println(stringStudentSortedMap.get(key));    // dddd bbb ccc aaa
        }
    }

    // 自定义排序顺序和排序字段 （按照从大到小DESC）
    public static void func3() {
        Map<Integer, String> stringStudentSortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else {
                    return o1 > o2 ? -1 : 1;
                }
            }
        });

        stringStudentSortedMap.put(91, "dddd");
        stringStudentSortedMap.put(9999, "aaa");
        stringStudentSortedMap.put(8888, "ccc");
        stringStudentSortedMap.put(7777, "bbb");

        System.out.println(stringStudentSortedMap);

        for (Integer key : stringStudentSortedMap.keySet()) {
            System.out.println(stringStudentSortedMap.get(key));    // aaa ccc bbb dddd
        }
    }

    // 测试配置文件
    // 由于历史遗留原因，Properties内部本质上是一个Hashtable,它的设计实际上是有问题的，但是为了保持兼容性，现在已经没法修改了
    // Java默认配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释
    public static void func4() throws IOException {
        // String f = "E:\\githubShyzhen\\javaLearningDialy\\src\\demo.properties";
        String f1 = "src/demo.properties";
        String f2 = "src/new.properties";

        Properties properties = new Properties();
        properties.load(new java.io.FileInputStream(f1));

        // 果有多个.properties文件，可以反复调用load()读取，后读取的key-value会覆盖已读取的key-value
        // 可以把默认配置文件放到classpath中，然后，根据机器的环境编写另一个配置文件，覆盖某些默认的配置
        properties.load(new java.io.FileInputStream(f2));  // properties.load(new java.io.FileReader(f2, StandardCharsets.UTF_8));


        String cdnUrl = properties.getProperty("cdn_url");
        String tokenTtl = properties.getProperty("token_ttl");

        System.out.println(cdnUrl);
    }

    // 写入配置文件 setProperty  store
    // 完全覆写，相当于把以前的删掉重新生成新文件
    public static void func5() throws IOException {
        String f1 = "src/new2.properties";
        Properties properties = new Properties();

        properties.setProperty("admin_id", "99999");
        properties.store(new java.io.FileOutputStream(f1), "这是写入的properties注释");
    }
}











class Student {
    private String name;
    private int grade;

    public Student() {}

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "name="+getName()+" grade="+getGrade() + "\n";
    }

//    public boolean equals(Object o) {
//        if (o instanceof Student) {
//            Student p = (Student) o;
//            return Objects.equals(this.name, p.name);
//        }
//        return false;
//    }
}