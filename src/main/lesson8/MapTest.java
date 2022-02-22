package src.main.lesson8;

import java.util.*;

/**
 * @Author zhenhuaixiu
 * @Date 2021/12/15 16:38
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        //func1();
        //func2();
        func3();
    }

    // List是有序列表，如果有一个Student实例的List,要在List中根据name找到特定的Student实例，怎么处理？
    // 最简单的方案是，遍历所有List,并判断name是否相等，然后返回。
    // 这种操作很常见，使用List遍历的效率非常低，所以Map这种键值对（key-value）映射表的数据结构可以高效的通过key查询value
    public static void func1() {
        List<Student> students = new ArrayList<Student>();
        Student s1 = new Student("张三", 80);
        Student s2 = new Student("李四", 90);
        students.add(s1);
        students.add(s2);

        System.out.println(students.get(0).toString());

        // 遍历查找名字为李四的学生成绩
        String searchName = "李四";
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student currStu = studentIterator.next();
            if (currStu.getName().equals(searchName)) {
                System.out.println(currStu.getGrade());
            }
        }
    }

    // 用Map来实现查询name的Student
    // 和List类似，Map也是一个接口，最常用的实现类是HashMap
    public static void func2() {
        Student s1 = new Student("张三", 80);
        Student s2 = new Student("李四", 90);
        Student s3 = new Student("王五", 98);
        Map<String, Student> studentMap = new HashMap<String, Student>();

        studentMap.put(s1.getName(), s1);
        studentMap.put(s2.getName(), s2);
        studentMap.put(s3.getName(), s3);

        System.out.println(studentMap);

        // 查找名字为李四的学生成绩
        String searchName = "李四";
        Student currStu = studentMap.get(searchName);

        if (currStu != null) {
            System.out.println(currStu.getGrade());
        } else {
            System.out.println("not exist");
        }

        // 如果只是想查询某个key是否存在，可以调用boolean containsKey(K key)方法


        System.out.println(currStu == s2);    // true

        // 始终牢记：Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉(但value是可以重复)

    }


    // 遍历Map
    // 遍历Map时，不可假设输出的key是有序的！
    public static void func3() {
        Student s1 = new Student("张三", 80);
        Student s2 = new Student("李四", 90);
        Student s3 = new Student("王五", 98);
        Map<String, Student> studentMap = new HashMap<String, Student>();

        studentMap.put(s1.getName(), s1);
        studentMap.put(s2.getName(), s2);
        studentMap.put(s3.getName(), s3);

        // System.out.println(studentMap);


        // keySet()方法返回的Set集合，它包含不重复的key
        String[] keys = studentMap.keySet().toArray(new String[0]);

        for (String key : keys) {
            Student student = studentMap.get(key);
            System.out.println("key:"+ key + " val:" + student);
        }

        // values返回值的集合
        // System.out.println(studentMap.values());

        // entrySet返回key-value映射的集合
        // System.out.println(studentMap.entrySet());

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            // System.out.println(entry);                        // 一个k=>value对象： 李四=name=李四 grade=90
            // System.out.println(entry.getKey());
            // System.out.println(entry.getValue());
            System.out.println("key:"+ entry.getKey() + " val:" + entry.getValue());
        }
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
}