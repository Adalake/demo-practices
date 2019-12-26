// 输出：
// form Person  
// from Student
// null student run
// voice student say

public class Click {
    public static void main(String[] args) {
        Person ming = new Student("xiao ming");
        ming.run();
        ming.say("voice");
    }
}

public class Person {
    public String name;

    public Person(String name) {
        System.out.println("当调用子类Student的构造方法时，会先调用父类的构造方法。所以这条第一行输出：form Person");
    }

    public void run() {
    }

    public void say(String name) {
        System.out.println(name + " Person say");
    }
}

public class Student extends Person {
    public String loud;

    public Student(String name) {
        super(name);
        System.out.println("然后调用子类的构造方法，所以这条第二行输出：from Student");
    }

    @Override
    public void run() {
        System.out.println(name + " student run");
    }

    @Override
    public void say(String loud) {
        System.out.println(loud + " student say");
    }
}
