
// 我们需要在第一行声明这个class属于哪个package，如package xinqiao
// 不用public、protected、private修饰的字段和方法就是包作用域
// 在包内部有public修饰的也可以直接调用
// 使用其他包的类 import other.Person
// 一个.java文件只能包含一个public类，但可以包含多个非public类。
// 如果有public类，文件名必须和public类的名字相同。

// 用final修饰class可以阻止被继承
// 用final修饰method可以阻止被子类覆写
// 用final修饰field可以阻止被重新赋值
// 用final修饰局部变量可以阻止被重新赋值

// 类中成员可访问性
//          Private   无    Protected    Public
// 同一个类    √        √        √        √
// 同一个包    ×        √        √        √
// 子类       ×        ×        √        √
// 非子类      ×        ×        ×        √