
public class c3_enum {
    public static void main(String[] args) {
        // 为了让编译器能自动检查某个值在枚举的集合内，并且不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用enum来定义枚举类
        Weekday day = Weekday.SUN;
        // enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较
        System.out.println(day == Weekday.FRI);
        System.out.println(day.dayValue == 0);
        String s = Weekday.SUN.name(); // "SUN"
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
    // 默认情况下，对枚举常量调用toString()会返回和name()一样的字符串。但是，toString()可以被覆写，而name()则不行。
    // 我们可以给Weekday添加toString()方法
}