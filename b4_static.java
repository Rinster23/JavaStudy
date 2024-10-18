class b4_Person{
    public String name;
    public int age;
    // 静态字段只有一个共享空间 所有实例都会共享该字段
    // 通过类名.静态字段来访问
    public static int numLegs;
    // 静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
    // 静态方法是属于类本身的方法 可以在不创建类的实例的情况下被调用
    public static void setNum(int value){
        numLegs = value;
    }
}

// 接口中可以有静态字段 且必须为final类型
// 实际上，因为interface的字段只能是public static final类型，所以我们可以把这些修饰符都去掉