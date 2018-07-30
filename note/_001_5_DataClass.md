## Kotlin 类5 - Data Class

---

在 Kotlin 中，不需要自己动手去写一个 JavaBean，可以直接使用 DataClass，使用 DataClass 编译器会默默地帮我们生成以下函数

```
equals()
hashCode()
toString()
componentN()
copy()
```

### 1. data class 的使用

1. 定义一个 data class 类

```
data class Country(var id: Int, var name: String, var continent: String)
```


2. 编译器自动实现的函数举例

+ `toString()`

```
var china = Country(0, "中国", "Asia")
println(china) // Country(id=0, name=中国, continent=Asia)
```

+ `copy()`

```
var japan = china.copy(id = 1, name = "日本")
println(japan) // Country(id=1, name=日本, continent=Asia)
```

+ `componentN()`

```
val (id, name, continent) = china
println("$id --> $name，$continent") // 0 --> 中国，Asia
```

### 2. data class 使用的坑
由于 data class 被编译器生成 JavaBean 时，是一个 final 类，并且没有无参的构造函数，所以在使用过程非常不方便，但是我们可以利用官方给出的插件来解决这些问题（`noarg`、`allopen`）

1. 添加依赖

```
buildscript {
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-noarg:$kotlin_version"
        classpath "org.jetbrains.kotlin:kotlin-allopen:$kotlin_version"
    }
}
```

2. 将依赖应用到项目中

```
apply plugin: 'kotlin-noarg'
apply plugin: 'kotlin-allopen'
```

3. 创建一个 annotation
```
package mm.learn.kotlin._001_class.annotations;

annotation class NoArgOpenDataClass
```

4. 添加配置

```
noArg{
    annotation("mm.learn.kotlin._001_class.annotations.NoArgOpenDataClass")
}

allOpen{
    annotation("mm.learn.kotlin._001_class.annotations.NoArgOpenDataClass")
}
```

5. 将注解用到 data class 中

```
@NoArgOpenDataClass
data class Country(var id: Int, var name: String, var continent: String)
```

6. 经过上面5个步骤，编译器就会帮我去掉 `final` 关键字，并且生成一个无参的构造方法，但是由于是在编译器做的操作，所以在源代码中还是无法直接使用无参的构造函数，只能通过反射来使用。


