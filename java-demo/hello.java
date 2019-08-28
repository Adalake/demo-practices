/* 基本数据类型 */
// public class Hello {
//     public static void main(String[] args) {
//         System.out.println("Hello, world!");
//     }
// }

// 我们定义了一个名为main的方法。方法是可执行的代码块，一个方法除了方法名main，还有用()括起来的方法参数。
// 这里的main方法有一个参数，参数类型是String[]，参数名是args，public、static用来修饰方法，这里表示它是一个公开的静态方法。
// void是方法的返回类型，而花括号{}中间的就是方法的代码。
//类首字母大写
//而关键字static是另一个修饰符，它表示静态方法，后面我们会讲解方法的类型，目前，我们只需要知道，Java入口程序规定的方法必须是静态方法，方法名必须为main，括号内的参数必须是String数组。

//在Java中，变量分为两种：基本类型的变量和引用类型的变量。

// public class Hello {
//     public static void main(String[] args) {
//         int x = 100;
//         System.out.println(x);
//         x = 200;
//         System.out.println(x);
//         char a = 'A';
//         System.out.println(a);
//         final double PI = 3.14;
//         System.out.println(PI);
//     }
// }

// 注意到第一次定义变量x的时候，需要指定变量类型int，因此使用语句int x = 100;。而第二次重新赋值的时候，变量x已经存在了，不能再重复定义，因此不能指定变量类型int，必须使用语句x = 200;。

// public class Hello {
//     public static void main(String[] args) {
//         float n = 100f;
//         System.out.println("n=" + n);


//         n = 200f;
//         System.out.println("n=" + n);

//         float x = n;
//         System.out.println("x=" + x);
//         System.out.println("n=" + n);
//     }
// }

//对于 float 类型，需要加上f后缀。如： float x =100f;
//字符类型 char 表示一个字符，如： char a = 'A'; char zh = '中'
//注意char类型使用单引号'，且仅有一个字符，要和双引号"的字符串类型区分开。
//定义变量的时候，如果加上final修饰符，这个变量就变成了常量。根据习惯，常量名通常全部大写。如： final double PI = 3.14; // PI是一个常量
// public class Hello {
//     public static void main(String[] args) {
//         int[] ns = new int[5];
//         ns[0] = 68;
//         ns[1] = 79;
//         ns[2] = 91;
//         ns[3] = 85;
//         ns[4] = 62;
//         System.out.println(ns);       
//     }
// }


// 定义一个数组类型的变量，使用数组类型“类型[]”，例如，int[]。和单个基本类型变量不同，数组变量初始化必须使用new int[5]表示创建一个可容纳5个int元素的数组。
// 数组是引用类型，并且数组的大小不可变。数组的3种表示如下：

// public class Hello {
//     public static void main(String[] args) {
//         int[] x = new int[5];
//         int[] y = new int[] { 6, 7, 8, 9, 1 };
//         int[] z = { 6, 7, 8, 9, 1 };
//         System.out.println(x.length + y.length + z.length);
//     }
// }

public class Hello {
    public static void main(String[] args) {
        String[] names = { "A", "B", "C" };
        String x = names[1];
        names[1] = "cat";
        System.out.println(x);
    }
}

//以上打印"B"，不是"cat"，因为数组是引用类型而不是值类型