package src.main.lesson9;

import java.util.*;

/**
 * @Author zhenhuaixiu
 * @Date 2022/3/3 14:57
 * @Version 1.0
 */
public class TreeMapTest {
    public static void main(String[] args) {
        //func1();
        //func2();
        func3();
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