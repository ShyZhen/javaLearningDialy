package src.main.lesson3;

import src.main.lesson3.classServer.Person;

import java.util.Arrays;

public class L001 {
    public static void main(String[] args) {
        System.out.println("面向对象");
        dispatch();
    }

    public static void dispatch() {
        func1();
        func2();
        func3();
        func4();
    }

    public static void func1() {
        Person shyZhen = new Person();

        String intro1 = shyZhen.intro();
        System.out.println(intro1);           // hello,my name is 默认名, age is 0,IDCard is null

        // public可以直接访问和赋值，private的只能调用类内部方法赋值
        shyZhen.name = "彦祖";
        shyZhen.setName("气势如虹王大爷");
        shyZhen.age = 18;
        shyZhen.setIdCardStr("232323233445");

        String intro2 = shyZhen.intro();      // hello,my name is 气势如虹王大爷, age is 18,IDCard is 232323233445
        System.out.println(intro2);

        // 可变参数，即数组
        shyZhen.setHobby("读书","写字","打游戏");                       // [读书, 写字, 打游戏]
        shyZhen.setHobbyArr(new String[] {"读书2","写字2","打游戏2"});  // [读书2, 写字2, 打游戏2]
        System.out.println(Arrays.toString(shyZhen.getHobby()));
    }

    // 更改传递的参数，看看对象是否有改变（传递的是引用还是copy的值）
    // 这里虽然传递的是string，但是更改值的时候是新地址，以前传的值已经无法改变了
    public static void func2() {
        Person person = new Person();
        String str1 = "一个简单的字符串";

        person.setName(str1);
        System.out.println(person.getName());  // 一个简单的字符串

        str1 = "修改字符串，对象名没跟着改变，cow";
        System.out.println(person.getName());  // 一个简单的字符串
    }

    // 引用类型参数的传递(比如数组)，调用方的变量，和接收方的参数变量，指向的是同一个对象
    // 上文中字符串没改变很好解释，更改字符串时，str1指向了一个新的地址，但是以前的值仍然存在，传递给对象的是这个以前的
    // 而本函数传递数组字符串，当更改某个值的时候，是在当前基础上更改了指针。
    // 而如果，重新定义数组，相当于开辟了一个新地址存储，再改都是改新的，传给对象的都是以前的，如func4()
    public static void func3() {
        Person person = new Person();
        String[] str1 = new String[]{"你好","我好"};

        person.setHobby(str1);
        System.out.println(Arrays.toString(person.getHobby()));  // [你好, 我好]

        str1[0] = "改变了";
        System.out.println(Arrays.toString(person.getHobby()));  // [改变了, 我好]
    }

    // 在更改数组前，重新定义一遍
    public static void func4() {
        Person person = new Person();
        int[] arr = new int[] {33,44,55};

        person.setHobbyArr2(arr);
        System.out.println(Arrays.toString(person.getHobby2()));  // [33, 44, 55]

        // 这里重新定义一次arr参数,导致后续更改arr是改变的新的值，传给对象的无法更改了已经
        arr = new int[] {66,77};
        System.out.println(Arrays.toString(person.getHobby2()));  // [33, 44, 55]

        arr[0] = 999;
        System.out.println(Arrays.toString(person.getHobby2()));  // [33, 44, 55]
    }
}
