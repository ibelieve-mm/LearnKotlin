## Kotlin 类4 - 伴生对象与静态成员

---

> + 在 Java 中，我们经常会把一些工具方法封装成一个类中的静态方法，这样就可以不用创建这个类的实例，直接用类名调用就可以了；
> + 但是在 Kotlin 中，我们一般不会这样用，我们会把这些工具方法定义成包级函数，直接拿函数名就可以调用了;
> + 例如我们要取两个数的最小值：

```
val number1 = 100
val number2 = 101
val minNumber = minOf(number1, number2) // 100
```

+ 如果实在需要将函数放到类中，像 Java 一样通过类名调用，我们可以使用 `伴生对象 companion object`

### 1. 伴生对象(静态函数)

> 伴生对象的语法就是在一个类中，用 `companion object{}` 将函数包裹，这样就可以直接用类名去调用这些函数
+ 看下面的一个例子

```
class LonLat private constructor(var longitude: Double, var latitude: Double) {
    companion object {
        fun instanceLonLat(longitude: Double, latitude: Double): LonLat {
            return LonLat(longitude, latitude)
        }
    }
}
```

> 这里创建了一个经纬度的类 `LonLat`，并将构造函数私有化了，这样我们就没有办法通过 `new` 实例化对象了，这是我们可以通过伴生对象，提供一个方法去返回该对象的实例

```
val lonlat = LonLat.instanceLonLat(116.404269, 39.914935)
```

+ 上面是 Kotlin 的调用，在 Java 中如何调用呢？

```
LonLat lonlat = LonLat.Companion.instanceLonLat(116.404269,39.914935);
```

> 但是在 Java 中，这种写法未免有些太繁琐了，其实可以完全像 Java 静态方法一样使用。我们将 `LonLat` 稍作改动，在函数前加上 `@JvmStatic` 注解就可以了

```
class LonLat private constructor(var longitude: Double, var latitude: Double) {
    companion object {

        @JvmStatic
        fun instanceLonLat(longitude: Double, latitude: Double): LonLat {
            return LonLat(longitude, latitude)
        }
    }
}
```

> Java 中的调用

```
LonLat lonlat = LonLat.instanceLonLat(116.404269, 39.914935);
```

### 2. 静态成员

```
class LonLat private constructor(var longitude: Double, var latitude: Double) {
    companion object {
        val TAG = "LonLat"
    }
}
```

```
println(LonLat.TAG) // LonLat
```

+ 如何在 Java 中调用呢？

```
class LonLat private constructor(var longitude: Double, var latitude: Double) {
    companion object {
        @JvmField
        val TAG = "LonLat"
    }
}
```

```
System.out.println(LonLat.TAG); // LonLat
```
