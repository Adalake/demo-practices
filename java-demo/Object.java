//-------------------------------------------------------------------》 /* 面向对象基础 */

/* 方法 */

// class Person {
//     public String name;
//     public int age;
// }

// 一个class可以包含多个字段（field），字段用来描述一个类的特征。
// 上面的Person类，我们定义了两个字段，一个是String类型的字段，命名为name，一个是int类型的字段，命名为age。
// 因此，通过class，把一组数据汇集到一个对象上，实现了数据封装。
// public 是用来修饰字段的，它表示这个字段可以被外部访问

// Person ming = new Person();
// 定义了class，只是定义了对象模版，而要根据对象模版创建出真正的对象实例，必须用new操作符。
// 注意区分Person ming是定义Person类型的变量ming，而new Person()是创建Person实例

// 通过new操作符创建新的instance，然后用变量指向它，即可通过变量来引用这个instance；
// 指向instance的变量都是引用变量。
// public class Object {
//     public static void main(String[] agrs) {
//         Person hong = new Person();
//         hong.name = "Xiao Hong";
//         hong.age = 15;
//         System.out.println(hong.age);
//     }
// }

// 显然，直接操作field，容易造成逻辑混乱。为了避免外部代码直接去访问field，
// 我们可以用private修饰field，拒绝外部访问：
// class Person {
//     private String name;
//     private int age;
// }

// --------------------------------------------why-mark: 为什么类要放在对象后面才能编译通过-----------------

// 需要使用方法（method）来让外部代码可以间接修改field：

// public class Object {
//     public static void main(String[] agrs) {
//         Person ming = new Person();
//         ming.setName("xiao ming");
//         ming.setAge(20);
//         System.out.println(ming.getName()+","+ming.getAge());
//     }
// }

// class Person {
//     private String name;
//     private int age;

//     public void setName(String name) {
//         this.name = name;
//     }
//     public void setAge(int age) {
//         if (age < 0 || age > 100) {
//             throw new IllegalArgumentException("invalid age value");
//         }
//         this.age = age;
//     }
    
//     public String getName() {
//         return this.name;
//     }
//     public int getAge() {
//         return this.age;
//     }
// }

// 外部代码可以调用方法setName()和setAge()来间接修改private字段。
// 外部代码不能直接读取private字段，但可以通过getName()和getAge()间接获取private字段的值。

// 定义方法的语法：
// 修饰符 方法返回类型 方法名（方法参数列表） {若干方法语句； return 方法返回值}
// 修饰符 voif 方法名（方法参数列表） {若干方法语句}


// -----------------------------------------------------------

// private方法:

// public class Object {
//     public static void main(String[] args) {
//         Person ming = new Person();
//         ming.setBirth(2000);
//         System.out.println(ming.getAge());
//     }
// }

// class Person {
//     private String name;
//     private int birth;
//     public void setBirth(int birth) {
//         this.birth = birth;
//     }
//     public int getAge(){
//         return calcAge(2019);
//     }
//     private int calcAge(int currentYear) {
//         return currentYear - this.birth;
//     }
// }

// --------------------------------------------------------------------------------------

// 可变参数用类型...定义，可变参数相当于数组类型：
// class Group {
//     private String[] names;

//     public void setNames(String... names) {
//         this.names = names;
//     }
// }
// 上面的setNames()就定义了一个可变参数。调用时，可以这么写：

// Group g = new Group();
// g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
// g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
// g.setNames("Xiao Ming"); // 传入1个String
// g.setNames(); // 传入0个String


// --------------------------------------------------------------------------------------


// 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响：
// public class Object {
//     public static void main(String[] agrs) {
//         Person ming = new Person();
//         int n = 15;
//         ming.setAge(n);
//         System.out.println(ming.getAge());
//         n = 16;
//         System.out.println(ming.getAge());
//     }
// }

// class Person {
//     private String name;
//     private int age;

//     public void setAge(int age) {
//         this.age = age;
//     }
//     public int getAge() {
//         return this.age;
//     }
// }


// --------------------------------------------------------------------------------------


// 引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。
// 双方任意一方对这个对象的修改，都会影响对方（因为指向同一个对象嘛）:
// public class Object {
//     public static void main(String[] agrs) {
//         Person ming = new Person();
//         String[] fullname = new String[] { "A", "Ha" };
//         ming.setName(fullname);
//         System.out.println(ming.getName());
//         fullname[0] = "B";
//         System.out.println(ming.getName());
//     }
// }

// class Person {
//     private String[] name;
//     public void setName(String[] name) {
//         this.name = name;
//     }
//     public String getName() {
//         return this.name[0] + "" + this.name[1];
//     }
// }

//注意，"B" 和 'B' 在Java中不一样。

// public class Object {
//     public static void main(String[] agrs) {
//         Person ming = new Person();
//         String x = "heihei";
//         ming.setName(x);
//         System.out.println(ming.getName());
//         x = "dadada";
//         System.out.println(ming.getName());
//     }
// }

// class Person {
//     private String name;

//     public void setName(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return this.name;
//     }
// }

// 方法可以让外部代码安全地访问实例字段；

// 方法是一组执行语句，并且可以执行任意逻辑；

// 方法内部遇到return时返回，void表示不返回任何值（注意和返回null不同）；

// 外部代码通过public方法操作实例，内部代码可以调用private方法；

// 理解方法的参数绑定。


// ----------------------------------------------------------------------------------------------------------------------------------


/* 构造方法 */

// 创建实例的时候，我们经常需要同时初始化这个实例的字段，例如：

// Person ming = new Person();
// ming.setName("小明");
// ming.setAge(12);

// 能否在创建对象实例时就把内部字段全部初始化为合适的值？这时，我们就需要构造方法。
// 创建实例的时候，实际上是通过构造方法来初始化实例的。
// 我们先来定义一个构造方法，能在创建Person实例的时候，一次性传入name和age，完成初始化：

// public class Object {
//     public static void main(String[] agrs) {
//         Person ming = new Person("xiao ming", 22);
//         System.out.println(ming.getName());
//         System.out.println(ming.getAge());
//         Person p = new Person();
//     }
// }
// class Person {
//     private String name = "Unamed";  //可以直接对字段进行初始化。可以但没必要。
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }
//     public Person() {

//     }
//     public String getName() {
//         return this.name;
//     }
//     public int getAge() {
//         return this.age;
//     }
// }

// 由于构造方法是如此特殊，所以构造方法的名称就是类名。构造方法的参数没有限制，在方法内部，也可以编写任意语句。
// 但是，和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
// 是不是任何class都有构造方法？是的。

// 那前面我们并没有为Person类编写构造方法，为什么可以调用new Person()？

// 原因是如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句，类似这样：

// class Person {
//     public Person() {
//     }
// }
// 要特别注意的是，如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法。
// 如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来。
// java中，若既初始化字段又初始化构造方法时。字段值由构造方法的代码确定

//可以定义多个构造方法，调用时会根据参数自动匹配到构造方法：
// class Person {
//     private String name;
//     private int age;
//     public Person() {

//     }
//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }
//     public Person(String name) {
//         this.name = name;
//         this.age = 12;  //当调用匹配到这个字段会直接给 age 赋值12
//     }
// }

public class Object {
    public static void main(String[] agrs) {
        Person ming = new Person("ming", 21);
        System.out.println(ming.getName());
        System.out.println(ming.getAge());
        Person hei = new Person("ming");
        System.out.println(hei.getName());
        System.out.println(hei.getAge());
        Person o = new Person(55);
        System.out.println(o.getName());
        System.out.println(o.getAge());
    }
}

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Person(String name) {
        this.name = name;
        this.age = 18;
    }
    public Person(int age) {
        this("dada", age);   //掉用另一个构造方法public Person(String, int)
    }
}

// 一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)

// 小结：
// 实例在创建时通过new操作符会调用其对应的构造方法，构造方法用于初始化实例；

// 没有定义构造方法时，编译器会自动创建一个默认的无参数构造方法；

// 可以定义多个构造方法，编译器根据参数自动判断；

// 可以在一个构造方法内部调用另一个构造方法，便于代码复用。