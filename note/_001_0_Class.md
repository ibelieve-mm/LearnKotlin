## Kotlin 类0 - 类的简单使用

---

### 1. 创建一个简单的 `狗` 类

```
class 狗 constructor(var 毛色: String, var 身高: Int, var 叫声: String) : Any {}
```
> 1. `class` ：表示是一个类，后面接类名；
> 2. `constructor` ：表示构造函数，可省略；
> 3. `()` ：中的内容为参数列表；
> 4. 参数列表后面的 `:` 表示继承关系；
> 5. `Any()` ：`Any` 是kotlin 中所有类的超类，`()` 表示构造，不可省略，但整体是可以省略不写的；

+ 上面的写法是一个完整的类的写法，可省略为

```
class 狗(var 毛色: String, var 身高: Int, var 叫声: String)
```

### 2. 利用类初始化一个对象

```
var 比熊: 狗 = 狗("白色", 50, "汪汪汪")
```

+ 如果要在创建类的时候做一些事情，我们可以添加一个 `init{}` ，注意这里是一个代码块，所以用的是 `{}`

```
class 狗(var 毛色: String, var 身高: Int, var 叫声: String){
    init {
        println("创建了一条狗，毛色：$毛色，身高：$身高，叫声：$叫声")
    }
}
```

### 3. 继承关系
+ 创建一个 `狗` 类的超类，`动物`

```
class 动物(var 毛色: String, var 身高: Int, var 叫声: String)
```
> 创建了一个 `动物` 出来，但是要想被其他类继承，需要用 `open` 修饰符修饰，因为 kotlin 中，一个类默认的是 `final`，不能被继承

```
open class 动物(var 毛色: String, var 身高: Int, var 叫声: String)
```

+ 让 `狗` 去继承 `动物`

```
class 狗(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声) {
    init {
        println("创建了一条狗，毛色：$毛色，身高：$身高，身高：$叫声")
    }
}
```
> 1. 由于在 `动物` 中已经定义了3个变量 `毛色`、`身高`、`身高`，所以在创建 `狗` 的时候不需要再定义三个变量了，只需要将参数传入即可，所以在参数列表位置写的是 `(毛色: String, 身高: Int, 叫声: String)` ，并没有使用变量定义符 `var`；
> 2. 既然超类中已经定义了3个变量，所以在继承的时候需要将参数传入 `(毛色, 身高, 叫声)`

+ 为了进一步简化代码，我们可以将初始化代码块拿到超类中去

```
open class 动物(var 毛色: String, var 身高: Int, var 叫声: String) {
    init {
        println("创建了一只${this.javaClass.simpleName}，毛色：$毛色，身高：$身高，叫声：$叫声")
    }
}

class 狗(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声)
class 羊(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声)
```

+ 调用构造函数创建对象

```
var 比熊: 狗 = 狗("白色", 50, "汪汪汪")
var 山羊: 羊 = 羊("黑色", 80, "咩咩咩")
```

+ 输出结果为

```
创建了一只狗，毛色：白色，身高：50，叫声：汪汪汪
创建了一只羊，毛色：黑色，身高：80，叫声：咩咩咩
```