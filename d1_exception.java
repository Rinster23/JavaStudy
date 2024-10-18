import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class d1_exception {
    public static void main(String[] args) {
        //必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。
        //不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。
        //在方法定义的时候，使用throws Xxx表示该方法可能抛出的异常类型。调用方在调用的时候，必须强制捕获这些异常，否则编译器会报错
        try {
            byte[] bs = toGBK("中文");
            System.out.println(Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        //多个catch语句只有一个能被执行
        //catch的顺序非常重要 子类必须写在前面
        //finally语句块保证有无错误都会执行
        //当某个方法抛出了异常时，如果当前方法没有捕获异常，异常就会被抛到上层调用方法，直到遇到某个try ... catch被捕获为止
        //printStackTrace()对于调试错误非常有用 可以回溯哪里出了异常
        //为了能追踪到完整的异常栈，在构造异常的时候，把原始的Exception实例传进去，新的Exception就可以持有原始Exception信息
    }

    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        // 用指定编码转换String为byte[]:
        return s.getBytes("GBK");
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);  //这里传入e, e.printStackTrace()才能追溯到原始的异常
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}
