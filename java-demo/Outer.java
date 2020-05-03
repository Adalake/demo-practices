public class Outer {
    private String name;
    private int age;

    public Outer() {
        System.out.println("father --outer");
    }

    /** 省略getter和setter方法 **/
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public class InnerClass {
        public InnerClass() {
            name = "May";
            age = 13;
            System.out.println("child --inner");
        }

        public void display() {
            System.out.println("name:" + getName() + "; age:" + getAge());
        }
    }

    public static void main(String[] args) {
        Outer outerClass = new Outer();
        Outer.InnerClass innerClass = outerClass.new InnerClass(); // 利用外部类的对象通过.new来创建内部类
        innerClass.display();
    }
}