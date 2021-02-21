// JVM为每个加载的class创建了对应的Class实例,并在实例中保存了该class的所有信息
// 通过Class实例获取class信息的方法称为反射

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
        String s = "hello";
        Class cls = s.getClass();
        System.out.println(cls);
        Class c1 = String.class;
        System.out.println(c1);
        Class c2 = Class.forName("java.lang.String");
        System.out.println(c2);

        Class StdClass = Student.class;
        System.out.println(StdClass);
        System.out.println(StdClass.getField("score"));
        System.out.println(StdClass.getField("name"));
        System.out.println(StdClass.getDeclaredField("grade"));
        // System.out.println(StdClass.getField("grade")); // 获取不到
        // System.out.println(StdClass.getDeclaredField("name")); // 获取不到
    }
}

class Person {
    public String name;
}

class Student extends Person {
    public int score;
    private int grade;
}

// getField: 获取一个类的public成员变量, 包括基类
// getDeclaredField: 获取一个类的所有成员变量, 不包括基类

class People {
    private String name;

    public People(String name) {
        this.name = name;
    }
}
