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

// public class Poly {
//     public static void main(String[] agrs) {
//         Person x = new Student();
//         x.run();
//     }
// }
// abstract class Person {
//     public abstract void run();
// }
// class Student extends Person {
//     @Override
//     public void run() {
//         System.out.println("233hiehie");
//     }
// }

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

/* 接口 */

// 如果一个抽象类没有字段，所有方法全部都是抽象方法：
// abstract class Person {
//     public abstract void run();
//     public abstract String getName();
// }
// 就可以把该抽象类改写为接口：interface。
// 在Java中，使用interface可以声明一个接口：
// interface Person {
//     void run();
//     String getName();
// }
// 接口不能定义实例字段，接口也不能由构造函数。所以必须在实现接口的class里定义构造函数和字段。
// 因为接口没有构造函数，所以在实现接口的 class 里不需要在构造函数里写 super()。

// 当一个具体的class去实现一个interface时，需要使用implements关键字。
// 我们知道，在Java中，一个类只能继承自另一个类，不能从多个类继承。
// 但是，一个类可以实现多个interface，例如：
// class Student implements Person, Hello { // 实现了两个interface
//     ...
// }

// public class Poly {
//     public static void main(String[] agrs) {
//         Person x = new Student("xiaohua");
//         x.run();
//         System.out.println(x.getName());
//     }
// }

// interface Person {
//     void run();
//     String getName();
// }

// class Student implements Person {
//     private String name;  //实例字段 String name 不能在接口定义。
    
//     public Student(String name) {
//         this.name = name;    // 易遗漏, Interfaces cannot have constructors
//     }
//     @Override
//     public void run() {
//         System.out.println("ziji go");
//     }
//     @Override
//     public String getName() {
//         return name;
//     }
// }

// 一个interface可以继承自另一个interface。interface继承自interface使用extends，它相当于扩展了接口的方法。例如：
// interface Hello {
//     void hello();
// }
// interface Person extends Hello {
//     void run();
//     String getName();
// }


// 静态字段
// public class Poly {
//     public static void main(String[] args) {
//         Person ming = new Person("Xiao Ming", 12);
//         Person hong = new Person("Xiao Hong", 15);
//         Person.number = 88;
//         System.out.println(Person.number);
//         // hong.number = 99;
//         System.out.println(ming.number);
//     }
// }

// class Person {
//     public String name;
//     public int age;

//     public static int number;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }
// }

// 静态方法
// public class Poly {
//     public static void main(String[] agrs) {
//         Person.setNumber(99);
//         System.out.println(Person.number);
//     }
// }
// class Person {
//     public static int number;
//     public static void setNumber(int value) {
//         number = value;
//     }
// }
// 上面这段，给 value 赋值的话，因为是只有一个独立空间的静态字段，所以 number 也会改变。因为静态方法也不属于实例，所以无法通过 this 访问。
// 因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
// 实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段。

// default 方法
// public class Poly {
//     public static void main(String[] agrs) {
//         Person x = new Student("ns");
//         x.run();
//     }
// }

// interface Person {
//     String getName();
//     default void run() {
//         System.out.println(getName());
//     }
// }

// class Student implements Person {
//     protected String name;
//     public Student(String name) {
//         super();
//         this.name = name;
//     }
//     @Override
//     public String getName() {
//         return this.name;
//     }
// }
// 实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
// 如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
// default方法和抽象类的普通方法是有所不同的。
// 因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。

// 因为interface是一个纯抽象类，所以它不能定义实例字段。
// 但是，interface是可以有静态字段的，并且静态字段必须为final类型：
// public interface Poly {
//     public static final int number = 1;
//     public static final String name = "hhh";
// }
// 可以简写为:
// public interface Poly {
//     int number = 1;
//     String name = "hhh";
// }

/* 作用域 */
// 定义为public的class、interface可以被其他任何类访问,不同包的也可以
// 定义为public的field、method可以被其他类访问，前提是首先有访问class的权限
// 定义为private的field、method无法被其他类访问
// 由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限
// protected作用于继承关系。定义为protected的字段和方法可以被子类访问，以及子类的子类


/* final 修饰符 */
// 用final修饰class可以阻止被继承
// 用final修饰method可以阻止被子类覆写
// 用final修饰field可以阻止被重新赋值
// 用final修饰局部变量可以阻止被重新赋值


/* 枚举 */
// public class Poly {
//     public static void main(String[] agrs){
//         weekday x = weekday.SUM;
//         if (x==weekday.SUM) {
//             System.out.println(x.toString());
//         }
//     }
// }
// enum weekday {
//     SUM, 
//     MON, 
//     TUE;
// }
// enum定义的类型就是class
// 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
// 只能定义出enum的实例，而无法通过new操作符创建enum的实例；
// 定义的每个实例都是引用类型的唯一实例；

// 例如，我们定义的Color枚举类：

// public enum Color {
//     RED, GREEN, BLUE;
// }
// 编译器编译出的class大概就像这样：

// public final class Color extends Enum { // 继承自Enum，标记为final class
//     // 每个实例均为全局唯一:
//     public static final Color RED = new Color();
//     public static final Color GREEN = new Color();
//     public static final Color BLUE = new Color();
//     // private构造方法，确保外部无法调用new操作符:
//     private Color() {}
// }

/* 泛型 */

// 未使用 #泛型# 前：
// public class Poly {
//     public static void main(String[] agrs) {
//         Pair x = new Pair("hh","zz");
//         System.out.println(x.getFirst());
//     }
// }
// class Pair {
//     private String first;
//     private String last;
//     public Pair(String first, String last) {
//         this.first = first;
//         this.last = last;
//     }
//     public String getFirst() {
//         return first;
//     }
//     public String getLast() {
//         return last;
//     }
// }

// 使用 #泛型# :
// public class Poly {
//     public static void main(String[] agrs) {
//         Pair<String> x = new Pair<String>("hh", "zz");   //可以省略后面的String，编译器可以自动推断泛型类型：Pair<String> x = new Pair<>("hh", "zz");
//         System.out.println(x.getFirst());
//     }
// }

// class Pair<T> {
//     private T first;
//     private T last;
//     public Pair(T first, T last) {
//         this.first = first;
//         this.last = last;
//     }
//     public T getFirst() {
//         return first;
//     }
//     public T getLast() {
//         return last;
//     }
// }


// 可以在接口中定义泛型类型，实现此接口的类必须实现正确的泛型类型。

// import java.util.Arrays;
// public class Poly {
//     public static void main(String[] args) {
//     String[] ss = new String[] { "Orange", "Apple", "Pear" };
//     Arrays.sort(ss);
//     System.out.println(Arrays.toString(ss));
//     }
// }

// 因为String本身已经实现了Comparable<String>接口。如果换成我们自定义的Person类型试试：
// import java.util.Arrays;
// public class Poly {
//     public static void main(String[] args) {
//         Person[] ps = new Person[] {
//             new Person("Bob", 61),
//             new Person("Alice", 88),
//             new Person("Lily", 75),
//         };
//         Arrays.sort(ps);
//         System.out.println(Arrays.toString(ps));
//     }
// }
// class Person implements Comparable<Person> {   //??不是很懂
//     String name;
//     int score;
//     Person(String name, int score) {
//         this.name = name;
//         this.score = score;
//     }
//     public int compareTo(Person other) {
//         return this.name.compareTo(other.name);
//     }
//     public String toString() {
//         return this.name + "," + this.score;
//     }
// }

// 静态泛型方法应该使用其他类型区分

// 多个泛型.例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>
public class Poly {
    public static void main(String[] agrs) {
        Pair<String, Integer> x = new Pair<>("hah", 233); 
        System.out.println(x.getFirst());
    }
}
class Pair<T, K> {
    public T first;
    public K last;

    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return this.first;
    }
}
