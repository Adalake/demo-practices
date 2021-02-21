
public class GetInstanceTest {
    public static void main(String[] args) {
        fruilt f = Factory.getInstance("qOrange");
        f.eat(); // 输出 I am an orange.

        Apple a = new Apple();
        Apple b = new Apple();
        System.out.println(a.equals(b)); // 返回false, 因为不是同一个对象
    }
}

interface fruilt {
    public abstract void eat();
}

class Apple implements fruilt {
    public void eat() {
        System.out.println("I am an apple.");
    }
}

class Orange implements fruilt {
    public void eat() {
        System.out.println("I am an orange.");
    }
}

// 构造工厂类 单例模式
class Factory {
    public static fruilt getInstance(String fruiltName) {
        fruilt f = null;
        if ("qApple".equals(fruiltName)) {
            f = new Apple();
        }
        if ("qOrange".equals(fruiltName)) {
            f = new Orange();
        }
        return f;
    }
}

// 当出现新水果时, 得去改动Factory的代码. 由此引出了反射.

// 使用 Object 的 equals() 方法是比较两个对象的内存地址是否相等，
// 即若 object1.equals(object2) 为 true，则表示 equals1 和 equals2 实际上是引用同一个对象

// 在覆写 equals 时推荐使用 getClass 进行类型判断。而不是使用 instanceof。