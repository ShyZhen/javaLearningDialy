package src.main.lesson8;

import java.time.DayOfWeek;
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
        //func3();
        //func4();
        //func5();
        func6();
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

    // 两个key应该是内容相同，但不一定是同一个对象。作为key获取的map值是一样的，但是他们两个key不是一个对象，无法直接==
    public static void func4() {
        Map<String, Integer> map = new HashMap<>();

        String key1 = "aaa";
        String key2 = new String("aaa");
        map.put(key1, 12345);

        System.out.println(map.get(key1));  // 12345
        System.out.println(map.get(key2));  // 12345

        System.out.println(key1 == key2);       // false
        System.out.println(key1.equals(key2));  // true
        System.out.println(map.get(key1) == map.get(key2));  // true
    }

    // 我们经常使用String作为key，因为String已经正确覆写了equals()方法。但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。
    // HashMap为什么能通过key直接计算出value存储的索引? 相同的key对象（使用equals()判断时返回true）必须要计算出相同的索引，否则，相同的key每次取出的value就不一定对。
    // 通过key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。
    // 作为key的对象必须正确覆写equals() 和 hashCode()方法。 （针对自己写的对象作为key，因为java的引用类型都实现了这些）
    // 正确编写equals：找出需要比较的字段，引用类型使用`Objects.equals()`比较，基本类型使用`==`比较
    public static void func5() {
        String key1 = "aaa";
        String key2 = new String("aaa");

//        Integer a = 3;
//        a.hashCode();

        System.out.println(key1.equals(key2));  // true
        System.out.println(key1 == key2);       // false
        System.out.println(key1.hashCode());    // 96321
        System.out.println(key2.hashCode());    // 96321
    }

    // HASH 冲突：不同对象算出来的hashcode一样：假设a和b的hashcode一样：
    // - hashmap的值不会覆盖，当索引值相同时，在HashMap中实际存储的不是一个Student实例，而是一个List，包含两个entry，一个是a的映射，一个是b的映射。
    // - 在查找的时候，比如map.get("a"),HashMap内部找到的其实是List<Entry<String, Student>>,还要遍历这个List,并找到一个key为a的Entry，才会返回对应的实例。
    // - 在冲突的时候，最简单的解决办法是上面这种用List存储相同的key-value，如果冲突的概率越大，List就越长，Map的get方法效率就越低，所以尽量不同的对象hashCode尽量不相等。
    // - hashCode编写的越好，HashMap工作效率越高。
    // - 要key与hash同时匹配才会认为是同一个key




    // 因为HashMap是一种通过对key计算hashCode()，通过空间换时间的方式，直接定位到value所在的内部数组的索引，因此，查找效率非常高

    // 枚举类型 EnumMap
    // 如果作为key的对象是enum类型,根据enum类型的key直接定位到内部数组的索引，并不需要计算hashCode()，不但效率最高，而且没有额外的空间浪费
    // （因为枚举已经确定key了，并且没有重复，所以不需要再次计算hashCode）
    public static void func6() {
        Map<DayOfWeek, String> weekStringMap = new EnumMap<>(DayOfWeek.class);

        weekStringMap.put(DayOfWeek.MONDAY, "周一难受上班");
        weekStringMap.put(DayOfWeek.THURSDAY, "周二难受");
        weekStringMap.put(DayOfWeek.FRIDAY, "周五舒服要放假");

        System.out.println(weekStringMap);
        System.out.println(weekStringMap.get(DayOfWeek.THURSDAY));


        // 自定义枚举
        Map<StudentType, String> studentTypeStringMap = new EnumMap<StudentType, String>(StudentType.class);

        studentTypeStringMap.put(StudentType.BADBOY, "这个人是坏男生");
        studentTypeStringMap.put(StudentType.GOODGIRL, "这个人是好女孩");

        System.out.println(studentTypeStringMap);
        System.out.println(studentTypeStringMap.get(StudentType.GOODGIRL));
    }

}

// 自定义枚举
enum StudentType {
    GOODBOY,

    GOODGIRL,

    BADBOY,

    BADGIRL,
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