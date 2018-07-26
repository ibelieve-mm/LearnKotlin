## Kotlin 智能类型转换

---

### 对于子父类之间的类型转换

+ 先看这样一段 Java 代码

```
public class Person{
}

public class Student extends Person{
    public  void study(){
        System.out.println("我在学习一门新的语言 Kotlin ！");
    }
}

public static void main(String[] args){
    Person person = new Student();
    if(person instanceof Student){
        ((Student) person).study();
    }
}
```

+ 尽管在 main 函数中，对 `person` 这个对象进行了类型判断，但是在使用的时候还是需要强制转换成 `Student` 类型，这样是不是很不智能？
+ 同样的情况在 Kotlin 中就变得简单多了

```
fun main(args: Array<String>) {
    val person: Person = Student()
    if (person is Student) {
        person.study()
    }
}
```

+ 在 Kotlin 中，只要对类型进行了判断，就可以直接通过父类的对象去调用子类的函数了

---

### 安全的类型转换
+ 还是上面的那个例子，如果我们没有进行类型判断，并且直接进行强转，会怎么样呢？

```
public static void main(String[] args) {
    Person person = new Person();
    ((Student) person).study();
}
```

+ 结果就只能是 `Exception in thread "main" java.lang.ClassCastException`
+ 那么在 Kotlin 中是不是会有更好的解决方法呢？

```
val person: Person = Person()
val student:Student? =person as? Student
println(student) // null
```
+ 在转换操作符后面添加一个 `?`，就不会把程序 crash 掉了，当转化失败的时候，就会返回一个 `null`


---

### 在空类型中的智能转换
+ 需要提前了解 Kotlin 类型安全的相关知识（[Kotlin 中的类型安全（对空指针的优化处理）](https://www.jianshu.com/p/68927b1790b4)）

```
val aString: String? = "Hello Kotlin"
if (aString is String) {
    println(aString.length)
}
```

+ `aString` 在定义的时候定义成了有可能为 `null`，按照之前的写法，我们需要这样写

```
val aString: String? = "Hello Kotlin"
println(aString?.length)
```

+ 但是已经进行了是否为 `String` 类型的判断，所以就一定 ***不是*** 空类型了，也就可以直接输出它的长度了