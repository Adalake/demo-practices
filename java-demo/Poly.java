//-------------------------------------------------------------------》 /* 面向对象基础 */      以下每一个 Poly 都是可以编译的。
// Poly，全称polymorphism

// @Override

// public class Poly {
//     public static void main(String[] agrs){
//         Person x = new Student();
//         x.run();
//     }
// }
// class Person {
//     public void run() {
//         System.out.println("father go");
//     }
// }
// class Student extends Person {
//     @Override   
//     public void run() {
//         System.out.println("ziji go");
//     }
// }

// 在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）
// @Override 不是必须添加的，但是如果添加了，编译器遇到子类不同名就会报错。
// 如果上面这段代码没有添加@Override，且子类的方法名不是run()；无论引用变量的声明类型与其实际类型是否相符（无论是 Person x = new Student();  还是 Student x = new Student(); ），那么编译器会运行父类，即输出 "father go"

// Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。  ==》 我现在的理解：子类继承于父类，编译时调用子类的方法。

// 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。例如：
// Person p = new Student();
// p.run(); // 无法确定运行时究竟调用哪个run()方法

// ---------------------------------------------------

// public class Poly {  
//     public static void main(String[] agrs) {
//             Income[] incomes = new Income[] { 
//                 new Income(3000),
//                 new Salary(7500),
//                 new Allowance(15000)
//             };
//             System.out.println(totalTax(incomes));
//         }

//         public static double totalTax(Income... incomes) {
//             double total = 0;
//             for (Income income: incomes) {       ----》怎么可以这样用？？？
//                 total = total + income.getTax();
//             }
//             return total;
//     }
// }

// class Income {
//     protected double income;
//     public Income(double income) {
//         this.income = income;
//     }
//     public double getTax() {
//         return income * 0.1;
//     }
// }

// class Salary extends Income {
//     public Salary(double income) {
//         super(income);
//     }
//     @Override
//     public double getTax() {
//         if (income <= 5000) {
//             return 0;
//         }
//         return (income - 5000) * 0.2;
//     }
// }
// class Allowance extends Income {
//     public Allowance(double income) {
//         super(income);
//     }
//     @Override
//     public double getTax() {
//         return 0;
//     }
// }


// 下面展示了 #可变参数# 的作用
// public class Poly {
//     public static void main(String[] agrs) {
//         Person x = new Person("a", "b");
//         System.out.println(x.getName());
//         Person y = new Person("a", "d","wd");
//         System.out.println(y.getName());
//     }
// }
// class Person {
//     private String[] names;
//     public Person(String...names) {
//         this.names = names;
//     }
//     public String getName() {
//         return names[1];
//     }
// }

// ----------------------------------------------------------------------

// 在子类的覆写(@Override)中，如果要调用父类的被覆写的方法，可以通过 super 来调用：
// public class Poly {
//     public static void main(String[] agrs) {
//         Student x = new Student();
//         System.out.println(x.hello());
//     }
// }
// class Person {
//     protected String name;
//     public String hello() {
//         return "father say hi";
//     }
// }
// class Student extends Person {
//     @Override
//     public String hello() {
//         return super.hello() + " " + "ziji go";
//     }
// }

/* 抽象类 */
// 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
// 因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）。
// 使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类：
// Person p = new Person(); // 编译错误

public class Poly {
    public static void main(String[] agrs) {
        Person x = new Student();
        x.run();
    }
}
abstract class Person {
    public abstract void run();
}
class Student extends Person {
    @Override
    public void run() {
        System.out.println("233hiehie");
    }
}

// 请看抽象类的返回类型不为 void 的情况：
// public class Poly {
//     public static void main(String[] agrs) {
//         Person x = new Student();
//         System.out.println(x.run());
//     }
// }
// abstract class Person {
//     public abstract String run();
// }
// class Student extends Person {
//     @Override
//     public String run() {
//         return "233";
//     }
// }