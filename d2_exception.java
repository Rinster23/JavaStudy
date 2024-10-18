public class d2_exception {
    //Exception
    //├─ RuntimeException
    //│  ├─ NullPointerException
    //│  ├─ IndexOutOfBoundsException
    //│  ├─ SecurityException
    //│  └─ IllegalArgumentException
    //│     └─ NumberFormatException
    //├─ IOException
    //│  ├─ UnsupportedCharsetException
    //│  ├─ FileNotFoundException
    //│  └─ SocketException
    //├─ ParseException
    //├─ GeneralSecurityException
    //├─ SQLException
    //└─ TimeoutException
    public static void main(String[] args) {
        double x = Math.random() - 1;
        assert x >= 0 : "x must >= 0";
        //JVM默认关闭断言指令，即遇到assert语句就自动忽略了，不执行
        //要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言
        // java -ea d2_exception.java
        // 实际开发中，很少使用断言。更好的方法是编写单元测试
    }
}

//自定义异常
class myException extends RuntimeException {
    public myException() {
        super();
    }

    public myException(String message, Throwable cause) {
        super(message, cause);
    }

    public myException(String message) {
        super(message);
    }

    public myException(Throwable cause) {
        super(cause);
    }
}