/* 输入与输出 */

// 如果要把数据显示成我们期望的格式，就需要使用格式化输出的功能。
// 格式化输出使用System.out.printf()，通过使用占位符%?，printf()可以把后面的参数格式化成指定格式

// public class If {
//     public static void main(String[] args) {
//         double x = 10.14159;
//         System.out.printf("%.2f\n", x);
//         int n = 12345000;
//         System.out.printf("n=%d, hex=%08x", n, n); 
//     }
// }

// 10.14
// n=12345000, hex=00bc5ea8

// System.out.println()来向屏幕输出一些内容。
// println是print line的缩写，表示输出并换行。因此，如果输出后不想换行，可以用print()

// 占位符	说明
// %d	格式化输出整数
// %x	格式化输出十六进制整数
// %f	格式化输出浮点数
// %e	格式化输出科学计数法表示的浮点数
// %s	格式化字符串

// Java提供的输出包括：System.out.println() / print() / printf()，其中printf()可以格式化输出；

// Java提供Scanner对象来方便输入，读取对应的类型可以使用：scanner.nextLine() / nextInt() / nextDouble() / ...

// double d = 3.1415926;
// System.out.printf("%.2f\n", d); // 显示两位小数3.14

// -----------------------------------------------

// import java.util.Scanner;
// public class If {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);  
//         System.out.print("Input your name: ");
//         String name = scanner.nextLine();
//         System.out.print("Input your age: ");
//         int age = scanner.nextInt();
//         System.out.printf("Hi, %s, your are %d", name, age);
//     }
// }

// ----------------------------------------------

// 创建Scanner对象并传入System.in。System.out代表标准输出流，而System.in代表标准输入流。
// 有了Scanner对象后，要读取用户输入的字符串，使用scanner.nextLine()，要读取用户输入的整数，使用scanner.nextInt()。
// Scanner会自动转换数据类型，因此不必手动转换。

// import java.util.Scanner;
// public class If {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter your last exam score: ");
//         float x = scanner.nextFloat();
//         System.out.print("Enter this exam score: ");
//         float y = scanner.nextFloat();
//         System.out.printf("z=%.3f", x/y);
//     }
// }

//输入小数，返回保留3位小数位的小数

// ----------------------------------------------

/* if判断语句 */

// import java.util.Scanner;
// public class If {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Input your exam score: ");
//         float x = scanner.nextFloat();
//         if (x > 60) {
//             System.out.printf("%.2f is passed!", x);
//         } else {
//             System.out.println(x + " is failed");
//         }
//     }
// }

// ----------------------------------------------

// import java.util.Scanner;

// public class If {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter your exam score: ");
//         float x = scanner.nextFloat();
//         if (x<60) {
//             System.out.printf("%.2f is a little bad", x);
//         } else if (x<80) {                      //此时表示 60 < x < 80
//             System.out.println("not bad");
//         } else {
//             System.out.println("well done");
//         }
//         System.out.println("end");
//     }
// }

// 在串联使用多个if时，要特别注意判断顺序。

// ----------------------------------------------


// 前面讲过了浮点数在计算机中常常无法精确表示，并且计算可能出现误差，因此，判断浮点数相等用==判断不靠谱。正确的方法是利用差值小于某个临界值来判断：
// public class If {
//     public static void main(String[] args) {
//         double x = 1 - 9.0/10.0;
//         System.out.println(x);
//         if (Math.abs(x - 0.1) < 0.00000001) {
//             System.out.println("x is 0.1");
//         } else {
//             System.out.println("x is NOT 0.1");
//         }
//     }
// }

// double x = 1 - 9.0/10.0; 和 double x = 1 - 9/10; ，输出是不一样的
// double x = 1 - 9/10; 输出： 1.0 。

// ----------------------------------------------

// public class If {
//     public static void main(String[] args) {
//         int n = 90;
//         if (n > 90) {
//             System.out.println("3");
//         } else if (n >= 60) {
//             System.out.println("2");
//         } else {
//             System.out.println("1");
//         }
//     }
// }

// 上面代码输出 2 ，原因是 > 和 >= 效果是不相同的

// public class If {
//     public static void main(String[] agrs) {
//         int n = 60;
//         if (n > 90) {
//             System.out.println("3");
//         } else if ( n > 60 || n == 60 ) {
//             System.out.println("2");
//         } else {
//             System.out.println("1");
//         }
//         System.out.println("end");
//     }
// }

// ----------------------------------------------

// 在Java中，判断值类型的变量是否相等，可以使用==运算符。
// 但是，判断引用类型的变量是否相等，==表示“引用是否相等”，或者说，是否指向同一个对象

// public class If {
//     public static void main(String[] agrs) {
//         String x = "hello";
//         String y = "HELLO".toLowerCase();
//         if ( x == y ) {
//             System.out.println("x == y");
//         } else {
//             System.out.println("x != y");
//         }
//     }
// }

// 以上打印： x !== y

// ----------------------------------------------

// 要判断引用类型的变量内容是否相等，必须使用equals()方法：

// public class If {
//     public static void main(String[] agrs) {
//         String x = "hello";
//         String y = "HELLO".toLowerCase();
//         if (x.equals(y)){
//             System.out.println("x == y");
//         }
//         System.out.println("end");
//     }
// }

// public class If {
//     public static void main(String[] agrs) {
//         String y = "hello";
//         if (y.equals("hello")) {
//             System.out.println("233");
//         }
//         String x = null;
//         if (x != null && x.equals("hello")) {
//             System.out.println("456");
//         }
//         System.out.println("end");
//     }
// }

// 执行语句s1.equals(s2)时，如果变量s1为null，会报NullPointerException
// 要避免NullPointerException错误，可以利用短路运算符&&

// 小结：
// if ... else可以做条件判断，else是可选的；

// 不推荐省略花括号{}；

// 多个if ... else串联要特别注意判断顺序；

// 要注意if的边界条件；

// 要注意浮点数判断相等不能直接用==运算符；

// 引用类型判断内容相等要使用equals()，注意使用 x != null 来避免NullPointerException。

// import java.util.Scanner;
// public class If {
//     public static void main(String[] agrs) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("input your weight: ");
//         float x = scanner.nextFloat();
//         System.out.print("input your height: ");
//         float y = scanner.nextFloat();
//         float b = x/(y*y);
//         if ( b < 18.5 ) {
//             System.out.println("low");
//         } else if (b < 25) {
//             System.out.println("normal");
//         } else {
//             System.out.println("over");
//         }
//         System.out.printf("%.2f", b);
//     }
// }

/*  switch */
// import java.util.Scanner;

// public class If {
//     public static void main(String[] agrs) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("try input 1 or 2 or 3 or others: ");
//         int x = scanner.nextInt();
//         switch (x) {
//             case 1:
//             System.out.println("input = 1");
//             break;
//             case 2:
//             case 3:
//             System.out.println("input = 2 or 3");
//             break;
//             default:
//             System.out.println("input = unknow");
//             break;
//         }
//     System.out.println("switch end");
//     }
// }

// 每一个switch语句里的 break 和 default 要记得写
// 使用switch语句时，只要保证有break，case的顺序不影响程序逻辑，但是仍然建议按照自然顺序排列，便于阅读。
// switch的计算结果必须是整型、字符串或枚举类型

// -----------------------------------------------

// public class If {
//     public static void main(String[] agrs) {
//         int sum = 0;
//         int n =1;
//         while (n<=3) {
//             sum = sum + n;
//             n++;
//         }
//         System.out.println(sum);
//     }
// }
//把上面代码的 while 替换成 if ，将输出 1

// while循环在每次循环开始前，首先判断条件是否成立。如果计算结果为true，就把循环体内的语句执行一遍，
// 如果计算结果为false，那就直接跳到while循环的末尾，继续往下执行

// ！ while 循环未完待续 。。。
// form while to do while 都没看。。。     跳过------------------------------------------------------------

// -------------------------

//求1到3的和：
// public class If {
//     public static void main(String[] agrs) {
//         int sum = 0;
//         for (int i=1; i<=3; i++) {
//             sum = sum + i;
//             System.out.println(i); //输出1， 2， 3
//         }
//         System.out.println(sum);
//     }
// }

public class If {
    public static void main(String[] agrs) {
        int[] ns = {1, 2, 3, 4};
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }
}