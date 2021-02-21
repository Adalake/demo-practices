public class Test {
    public static void main(String[] args) {

        var a = 1;
        // var b = 1;
        // var c = 1;
        var A = 0;
        A = a++;
        // var B = ++b;
        // c = c++;
        // System.out.println(a); // 2
        // System.out.println(b); // 2
        // System.out.println(c); // 1
        System.out.println(A); // 1
        // System.out.println(B); // 2
    }
}