public class InnerClass {
    public void test(Bird bird) {
        System.out.println(bird.getName() + " could fly " + bird.fly() + " miles.");
    }

    public static void main(String[] args) {
        // 例子1:
        InnerClass innerClass = new InnerClass();
        innerClass.test(new Bird() { // topic 匿名内部类
            public int fly() {
                return 10000;
            }

            public String getName() {
                return "Geese";
            }
        });

        // 例子2:
        noNameClass noName = new noNameClass();
        IInterface iNoName = noName.dest();
        iNoName.print1();

        noNameClass normalName = new noNameClass();
        normalName.normal();
    }
}

abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}

// 匿名内部类是直接使用new来生成一个对象的引用。当然这个引用是隐式的。

// 对于上面这段匿名内部类代码其实是可以拆分为如下形式：
// class WildGoose extends Bird{
// public int fly() {
// return 10000;
// }
// public String getName() {
// return "大雁";
// }
// }

// WildGoose wildGoose = new WildGoose();
// test.test(wildGoose);

// 假如要执行的任务需要一个对象，但却不值得创建全新的对象
//（原因可能是所需的类过于简单，或是由于他只在一个方法内部使用），匿名类就显得很有用。
// 匿名类尤其适合在Swing应用程式中快速创建事件处理程式。

// 例子2
interface IInterface {
    void print1();
}

class noNameClass {
    public IInterface dest() {
        return new IInterface() {
            public void print1() {
                System.out.println("Hello I am an Inner");
            }
        }; // 这里得加分号
    }

    public void normal() {
        System.out.println("I am normal");
    }
}