public class Equals {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = String.class;

        String s = "Hello";
        Class cls1 = s.getClass();

        Class cls2 = Class.forName("java.lang.String");

        System.out.println(cls);
        System.out.println(cls1);
        System.out.println(cls2);
    }

}