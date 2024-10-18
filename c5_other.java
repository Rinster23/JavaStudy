import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class c5_other {
    public static void main(String[] args) {
        // 我们使用的整数范围超过了long型 只能用软件来模拟一个大整数。java.math.BigInteger就是用来表示任意大小的整数
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000
        // 对BigInteger做运算的时候，只能使用实例方法，例如，加法运算
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780
        // 也可以转换为其他基本数据类型
        // 和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489
        BigDecimal d1 = new BigDecimal("123.4500");
        BigDecimal d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2,因为去掉了00

        d1 = new BigDecimal("123.456");
        d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false,因为scale不同
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为3
        System.out.println(d1.compareTo(d2)); // 0 = 相等, -1 = d1 < d2, 1 = d1 > d2

        // 常用工具
        Math.abs(-100); // 100
        Math.pow(2, 10); // 2的10次方=1024
        Math.sqrt(2); // 1.414...
        Math.exp(2); // 7.389...
        Math.log(4); // 1.386...
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        Math.sin(Math.PI / 6); // sin(π/6) = 0.5

        Random r = new Random();    // 可以传入seed
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double
        // 需要使用安全随机数的时候，必须使用SecureRandom，绝不能使用Random！
    }
}
