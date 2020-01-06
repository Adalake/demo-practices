import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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

        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        RearlStudent test = new RearlStudent();
        test.update();

        PetRestaurant dog = new Dog();
        PetRestaurant cat = new Cat();
        Test testNow = new Test();
        testNow.buyx(dog); // 接口的作用
        testNow.buyx(cat);
        dog.buy(); // 如果没有Test这个类, 那么要调用buy()这个要写成这样
        cat.buy(); // 如果没有Test这个类, 那么要调用buy()这个要写成这样
        System.out.println("________");
        new Cat(cat);

        Map<PersonQ, Integer> mapq = new TreeMap<>(new Comparator<PersonQ>() {
            public int compare(PersonQ p1, PersonQ p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        mapq.put(new PersonQ("Tom"), 1);
        mapq.put(new PersonQ("Bob"), 2);
        mapq.put(new PersonQ("Lily"), 3);
        for (PersonQ key : mapq.keySet()) {
            System.out.println(key);
        }
        System.out.println(mapq.get(new PersonQ("Bob")));
    }
}

class Person {
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

class Student extends Person {
    public String loud;

    public Student(String name) {
        super(name);
        System.out.println("然后调用子类的构造方法，所以这条第二行输出： from Student");
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

interface students {
    void update();
}

class RearlStudent implements students {
    @Override
    public void update() {
        System.out.println("122");
    }
}

interface PetRestaurant {
    public void buy();
}

class Dog implements PetRestaurant {
    @Override
    public void buy() { // 这个类方法的修饰符是public
        System.out.println("I am dog, I want to eat");
    }
}

class Cat implements PetRestaurant {
    public Cat(PetRestaurant pet) {
        pet.buy();
    }

    public Cat() {
    }

    @Override
    public void buy() {
        System.out.println("I am cat, I want to eat");
    }
}

// 下面这个类相当于一个接待顾客的类，即店小二，他接待所有实现了我这个宠物店接口的动物，传进来一个PetRestaurant
// 类型的宠物，注意，这个PetRestaurant是接口
class Test {
    public void buyx(PetRestaurant pet) {
        pet.buy();
        System.out.println("from Test");
    }
}

// 接口作为类的参数传入

class PersonQ {
    public String name;

    PersonQ(String name) {
        this.name = name;
    }

    public String toString() { // 如果没有这个,输出变成hash值?
        return "{PersonQ: " + name + "}";
    }
}