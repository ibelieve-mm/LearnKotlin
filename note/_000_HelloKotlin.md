## Kotlin 的基本语法、简单函数、基本数据类型

---

### 1. 语法

#### 1. 不需要使用分号作为语句结束，直接 enter 就可以；
#### 2. 定义一个简单的变量：

```
val aBoolean: Boolean = false

var bBoolean: Boolean = true
bBoolean = false
```
> 1. `val` 定义一个常量，一旦赋值就不能第二次赋值了，类似于Java中的 `final`；当然还可以这样写
> + 注意区别：Java 中 `final` 是编译期常量，就是在编译阶段已经将 `final` 修饰的常量换成了它所对应的值，很像 c++ 中的 `宏`；
> + 而 Kotlin 中的 `val` 并不是编译期常量，编译器在编译的时候还是用的引用，并不会拿常量值去替换，如果在 `val` 前面添加一个 `const` 就和 Java 中的 `final` 修饰的是等价的，即

```
const val aBoolean: Boolean = false
```

```
val aBoolean = false

// 或者是这样
val aBoolean: Boolean
aBoolean = false
```
> 2. `var` 定义一个变量；
> 3. `aBoolean` `bBoolean` 变量名；
> 4. `Boolean` 变量类型，注意与变量名之间用 `:` 隔开；
> 5. 其实在直接赋值的情况下，编译器是可以推断出变量的类型的，此时可是可以省略 `: Boolean` 这个类型声明；

#### 3. 简单的函数

1. 主函数

```
fun main(args: Array<String>) {
    println("Hello Kotlin")
}
```

+ 以上就是一个 kotlin 的 main 函数，程序的入口；
+ `fun` 函数的标志；
+ `main` 函数名；
+ `args` 参数名；
+ `Array<String>` 参数类型；
+ ***注意：函数无返回值***，在 kotlin 中，无返回值用 `Unit` 表示，可省略，所以 `main` 函数的完整写法：

```
fun main(args: Array<String>): Unit {
    println("Hello Kotlin")
}
```
> 返回值放在参数列表后面，用 `:` 与参数列表隔开；

2. 在 Kotlin 中函数还可以更简洁，先看一个例子

```
fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

// sum(1, 2) // 3
```

> 1. 这是一个简单的求和函数，上面是规规矩矩的写法，其实我们可以写成

```
fun sum(arg1: Int, arg2: Int): Int = arg1 + arg2

// sum(1, 2) // 3
```

> 2. 更灵活就是，还可以用一个变量去接收匿名函数，类似于 c 中的函数指针

```
val vSum = fun(arg1: Int, arg2: Int): Int = arg1 + arg2

// vSum(1, 2) // 3
```

> 3. 如果接触过 lambda 表达式，还可以写成这样

```
val vSum = { arg1: Int, arg2: Int -> arg1 + arg2 }

// vSum(1, 2) // 3
```

+ 如果函数体内容很多呢

```
val vSum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

// vSum(1, 2) // 3
```

+ 又如果没有返回值呢

```
val sayHello = { println("Hello Lambda") }

// sayHello() // Hello Lambda
```
+ 提到 lambda 表达式，要看一下数组的遍历

```
val array = arrayOf("Tom", 1, "Jerry")
for (it in array) {
    print("$it ")
}
// Tom 1 Jerry
```

+ 这是之前的数组遍历，如果换成 lambda 表达式呢，使用数组提供的一个 forEach 函数

```
array.forEach { print("$it ") }
```

+ 注意这里必须使用 `it` 来指代元素，why？因为传入的是一个参数，可以省略，省略后，编译器默认用 `it` 指代。那将这段代码还原一下

```
array.forEach({ element -> print("$element ") })
```

+ 其实在 Kotlin 中，如果函数的最后一个参数是 lambda 表达式，我们还可以将小括号提到大括号前面写，于是就变成了这样

```
array.forEach(){ element -> print("$element ") }
```

+ 由于除了最后一个参数是 lambda 表达式外，前面再没有其他参数（小括号中没有参数），所以小括号也可以省略

```
array.forEach{ element -> print("$element ") }
```

+ 上面也提到了，lambda 表达式中只有一个参数是可以省略的，所以

```
array.forEach { print("$it ") }
```


---

### 2. 基本数据类型

#### 1. `Boolean` 取值 true/false；
#### 2. Number类型：(主要包括整形和浮点型)

| 分类 | 类型 | 宽度 |
| --- | --- | --- |
| 浮点型 | Double | 64（8字节） |
| 浮点型 | Float | 32（4字节） |
| 整型 | Long | 64（8字节） |
| 整型 | Int | 32（4字节） |
| 整型 | Short | 16（2字节） |
| 字节 | Byte | 8（1字节） |

> 2.1 `Int`

```
val aInt: Int = 8
val bInt: Int = 0xff // 255 十六进制
val cInt: Int = 0b00000011 // 3 二进制
val maxInt: Int = Int.MAX_VALUE // 2147483647，即 2^31-1
val minInt: Int = Int.MIN_VALUE // -2147483648，即 -2^31
```

> 2.2 `Long`

```
val aLong:Long = 1L // 必须是大写的 L ，显示声明时可省略
val bLong:Long = 2
val maxLong:Long = Long.MAX_VALUE // 9223372036854775807，即 2^63-1
val minLong:Long = Long.MIN_VALUE // -9223372036854775808，即 -2^63
```

> 2.3 `Float`

```
val aFloat:Float = 2.0f // 必须在后面加 f/F
val bFloat:Float = 2e1f // 或者是 1E2F
val maxFloat:Float= Float.MAX_VALUE // 3.4028235E38
val minFloat:Float= Float.MIN_VALUE // 1.4E-45 ，最小的非零的正数
val minFloat2:Float= -Float.MAX_VALUE // -3.4028235E38 ，Float 真正的最小值
```

> 2.3.1 `Float` 的三个特殊值

```
val posFloat:Float= Float.POSITIVE_INFINITY // Infinity 正无穷
val negFloat:Float= Float.NEGATIVE_INFINITY // -Infinity 负无穷
val nanFloat:Float= Float.NaN // NaN 不是数
```


> 2.3.2 如何得到一个 `无穷值` 或者 `不是数`

```
val posFloat2:Float = 1.0f/0.0f // 结果为 posFloat
val nanFloat2:Float = 0.0f/0.0f // 结果为 NaN
```

> 2.3.3 比较 `无穷值` 或者 `不是数`

```
val posBoolean: Boolean = posFloat == posFloat2 // true
val nanBoolean: Boolean = nanFloat == nanFloat2 // false

val posBoolean2: Boolean = posFloat === posFloat2 // true
val nanBoolean2: Boolean = nanFloat === nanFloat2 // false
```

> 2.4 `Double`

```
val aDouble: Double = 3.0
val maxDouble: Double = Double.MAX_VALUE // 1.7976931348623157E308
val minDouble: Double = Double.MIN_VALUE // 4.9E-324 ，最小的非零的正数
val minDouble2: Double = -Double.MAX_VALUE // -1.7976931348623157E308 ，Double 真正的最小值
```

> 2.5 `Short`

```
val aShort: Short = 1
val maxShort: Short = Short.MAX_VALUE // 32767 ，即 2^15-1
val minShort: Short = Short.MIN_VALUE // -32768 ，即 -2^15
```

> 2.6 `Byte`

```
val aByte: Byte = 1
val maxByte: Byte = Byte.MAX_VALUE // 127 ，即 2^7-1
val minByte: Byte = Byte.MIN_VALUE // -128 ，即 -2^7
```

> 2.7 总结
> + 浮点型的数据都是无符号的，整型以及 Byte 都是有符号的；

#### 3. Char 类型（对应 Java 中的 Character）
> 3.1 宽度 16（2字节），表示一个16位的 Unicode 字符

```
val aChar: Char = '0'
val bChar: Char = 'a'
val cChar: Char = '\n'
val dChar: Char = '中'
val eChar: Char = '\u234f' // ⍏
```

> 3.2 Kotlin 中的特殊 Char 类型

| 转义字符 | 含义 |
| --- | --- |
| `\t` | 制表符  |
| `\b` | 光标后退一个字符  |
| `\n` | 回车  |
| `\r` | 光标回到行首  |
| `\'` | 单引号  |
| `\"` | 双引号  |
| `\\` | 反斜杠  |
| `\$` | 美元符号  |

---

### 3. 基本类型的转换 ***不可以隐式转换***

+ 在 Java 中，从小到大，数据可以隐式转换，数据类型会自动提升；
+ 在 Kotlin 中比较严格，不存在隐式转换，例如将 Int 转成 Long，必须使用显式转换；

```
val anInt: Int = 10
val anLong: Long = anInt.toLong()
```

---

### 4. 字符串

#### 1. 创建并初始化一个字符串

```
val aString: String = "Hello Kotlin"
```

#### 2. 通过字符数组创建一个字符串

```
val fromCharArray: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', ' ', 'K', 'o', 't', 'l', 'i', 'n')) // Hello Kotlin
```

#### 3. 字符串的比较 ***比较值***

```
val equalsBoolean: Boolean = aString == fromCharArray // true ，在 kotlin 中，== 相当于 Java 中的 equals() 方法
```
> `==` 相当于 Java 中的 `equals()` 方法；

#### 4. 字符串的比较 ***比较引用***

```
val equalsBoolean2: Boolean = aString === fromCharArray // false ，在 kotlin 中，=== 相当于 Java 中的 == ，比较两个对象的引用
```
> `===` 相当于 Java 中的 `==`；

#### 5. 字符串模板

+ 假设我们通过两个变量想计算并输出一个 `1 + 2 = 3`，在 Java 中的做法是：

```
val numInt1: Int = 1
val numInt2: Int = 2
val resultString: String = "" + numInt1 + " + " + numInt2 + " = " + (numInt1 + numInt2) // 1 + 2 = 3
```

+ 而在 kotlin 中使用模板就变得简单多了

```
val resultString2: String = "$numInt1 + $numInt2 = ${numInt1 + numInt2}" // 1 + 2 = 3
```
> ***注意:***当边量名可以和字符串区别开来的时候，可以将 `{}` 省略，例如例子中的 `$numInt1 + $numInt2 =` 中变量 `$numInt1`、`$numInt2` 和 `+`、`=` 之间都有空格将变量名和字符进行区分，所以省略了 `{}`

+ 使用字符串模板需要注意以下情况

```
val money: Int = 1000
val moneyString: String = "$money" // 1000
val moneyString2: String = "$$money" // $1000
val moneyString3: String = "\$money" // $money
```
#### 6. 原始字符串
+ 用三个双引号可以表示原始字符串;
+ 反斜杠 `\` 也不再表示转义了，所以 `\n` 也不再表示换行了，直接用回车换行
+ 字符串模板仍然被支持，但是仍然没有办法被转义，所以想要在字符串中输出 `$`，则 `$` 符号后面不能跟变量名

```
val originalString:String = """用三个双引号可以表示原始字符串；
    反斜杠 \ 也不再表示转义了，所以 \n 也不再表示换行了，直接用回车换行；
    并且字符串模板仍然被支持，$money，由于没有办法被转义，所有只能这样写 $ money；
    """
```
> 上面内容的输出结果是
```
用三个双引号可以表示原始字符串；
        反斜杠 \ 也不再表示转义了，所以 \n 也不再表示换行了，直接用回车换行；
        并且字符串模板仍然被支持，1000，由于没有办法被转义，所有只能这样写 $ money；
```



