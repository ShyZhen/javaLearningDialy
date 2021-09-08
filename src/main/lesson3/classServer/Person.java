package src.main.lesson3.classServer;

public class Person {
    public String name = "默认名";
    public int age = 0;
    private String idCardStr;
    private String[] hobby;
    private int[] hobby2;

    public String intro() {
        String intro;
        intro = "hello,my name is "+this.name+", age is "+this.age+",IDCard is "+ this.idCardStr;
        return  intro;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid name value");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public void setIdCardStr(String idCardStr) {
        this.idCardStr = idCardStr;
    }

    // 可变参数 可变参数可以改写为String[]
    public void setHobby(String... hobby) {
        this.hobby = hobby;
    }
    // 数组形势 可变参数可以改写为String[]
    public void setHobbyArr(String[] hobby) {
        this.hobby = hobby;
    }

    public void setHobbyArr2(int[] hobby) {
        this.hobby2 = hobby;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getIdCardStr() {
        return this.idCardStr;
    }

    public String[] getHobby() {
        return this.hobby;
    }

    public int[] getHobby2() {
        return this.hobby2;
    }

}