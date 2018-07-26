## Kotlin 类型安全（对空指针的优化处理）

---

+ 首先我们看下面的一段 java 代码：

```
public static void main(String[] args){
    System.out.println(getName().length());
}

public static String getName(){
    return null;
}
```

+ 如果运行 main 函数，jvm 会报 `Exception in thread "main" java.lang.NullPointerException` 的错误。相信大家在 codding 的时候稍有不慎就会遇到这个问题，非常让我们头疼。为了安全起见，我们要做大量的空指针判断，我们的时间严重浪费了在这些毫无技术含量的处理上。于是我们的 main 函数变成了：

```
public static void main(String[] args) {
    String name = getName();
    if (null == name) {
        System.out.println("未获取到 name！");
        return;
    }
    System.out.println(name.length());
```

+ 但是 Kotlin 的出现，挽救了我们处理空指针的时间。同样的我们看下面一段代码：

```
fun getName(): String {
    return null // 这种情况在 Kotlin 中是不允许的
}
```

+ 同样是返回一个 `String` 类型的 `getName()` 函数，在 Kotlin 中如果返回 `null` 是无法通过编译的。
+ 这样做，很显然避免的了出现空指针的可能性，但是问题又来了，如果 `getName()` 就是可以返回 `null` 呢？很简单，我们在返回值类型后面加一个 `?` 就表示可以返回 `null` 了，于是代码变成了：

```
fun getName(): String? {
    return null
}
```

+ 那接着问题又来了，这样不是又跟 Java 一样了吗？同样存在空指针的危险：

```
fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    println(getName().length) // 编译通不过，getName()有可能为null
}
```

+ 由于上面的那段代码编译无法通过，于是只好进行空指针判断了

```
fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    var name = getName()
    if(null==name){
        println("未获取到 name！")
        return
    }
    println(name.length)
}
```

+ 这样一来，Kotlin 代码和 Java 就一样了，没什么优点了！不！其实上面的代码是可以简化的

```
fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    println(getName()?.length) // null
}
```

+ 上面的代码的意思就是，如果 `getName()` 不为空，则打印长度，否则就返回。
+ 如果知道一个值不可能为空，但是在定义的时候定义了有可能为空，而且也不想在判断，该怎么将解决？

```
val aString: String? = "Hello Kotlin"
println(aString.length) // 编译错误
```

+ 这个时候就可以使用强制执行，就是在变量后面加两个 `!`

```
val aString: String? = "Hello Kotlin"
println(aString!!.length) // 12
```
