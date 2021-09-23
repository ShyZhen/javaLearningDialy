package src.main.lesson4.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

class TestBean {
    private String name;
    private int age;
    private boolean flag;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isFlag() {
        return flag;
    }
}

public class L004JavaBean {
    public static void main(String[] args) throws IntrospectionException {
        System.out.println("Java Bean");
        func1();
        func2();
    }

    public static void func1() {
        TestBean tb = new TestBean();
        tb.setName("张三");
        System.out.println(tb.getName());
    }

    public static void func2() throws IntrospectionException {
        BeanInfo binfo = Introspector.getBeanInfo(TestBean.class);

        for (PropertyDescriptor pd: binfo.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
        }
    }
}
