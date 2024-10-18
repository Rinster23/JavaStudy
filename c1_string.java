import java.util.StringJoiner;

public class c1_string {
    public static void main(String[] args) {
        // 字符串不可变
        String s = "HELLO";
        s = s.toLowerCase();
        System.out.println(s);  // HELLO
        s.equals("HELLO");
        s.equalsIgnoreCase("HeLlo");
        s.contains("ll");
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"
        String trimmed = "  \tHello\r\n ".trim(); // "Hello"
        "  Hello   ".strip(); // stripLeading, stripTrailing
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符
        s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
        s = "A,B,C,D";
        String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
        String[] arr = {"A", "B", "C"};
        s = String.join("***", arr); // "A***B***C"
        s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        // %s：显示字符串；%d：显示整数；%x：显示十六进制整数；%f：显示浮点数。

        //类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
        int n1 = Integer.parseInt("123"); // 123
        boolean b1 = Boolean.parseBoolean("true"); // true
        char[] cs = "Hello".toCharArray(); // String -> char[]
        s = new String(cs); // char[] -> String 这也是String的原始构造方法
        cs[0] = 'X';  // s不会改变，这是因为通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，而是会复制一份

        // 可以直接用+拼接字符串 但是循环拼接字符串会创建很多新的字符串临时对象，浪费内存
        // StringBuilder
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        s = sb.toString();
        // 允许链式操作，原理见Adder
        sb = new StringBuilder(1024);
        sb.append("Mr ").append("Bob").append("!").insert(0, "Hello, ");
        var adder = new c1_Adder();
        int res = adder.add(3).add(5).inc().add(10).value();

        // StringJoiner 需import
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        s = String.join(", ", names);
    }
}

class c1_Adder {
    private int sum = 0;

    public c1_Adder add(int n) {
        sum += n;
        return this;
    }

    public c1_Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}