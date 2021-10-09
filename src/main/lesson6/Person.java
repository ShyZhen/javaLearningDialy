package src.main.lesson6;

public class Person {
    public String name = "";
    public int age = 1;
    public String bio = "说点什么吧~";
    private int grade;

    public String intro() {
        return "我叫" + this.name + ", 今年" + this.age + "岁";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
