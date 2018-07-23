## Kotlin 中的包

---

### 别名

+ 假设有一个包，下面有两个子包 `beijing` 和 `shanghai`，每个包下面都一个 `Secretary` 类，如图：

![包的别名.jpg](https://upload-images.jianshu.io/upload_images/1135454-e6f3ccfb08582a74.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
package mm.learn.kotlin._004_package.beijing

class Secretary(var firstName: String)
```

```
package mm.learn.kotlin._004_package.shanghai

class Secretary(var firstName: String)
```

+ 那么在使用的时候就是这样的，使用起来非常繁琐

```
package mm.learn.kotlin._004_package.beijing

fun main(args: Array<String>) {

    var bjSecretary: Secretary = Secretary("张")

    var shSecretary: mm.learn.kotlin._004_package.shanghai.Secretary = mm.learn.kotlin._004_package.shanghai.Secretary("李")
}
```

+ 但是在 Kotlin 中，提供了一种更友好的方式来简化，就是在导入包的时候可以同时起一个别名，于是上面的代码变成了：

```
package mm.learn.kotlin._004_package.beijing

import mm.learn.kotlin._004_package.shanghai.Secretary as SHS

fun main(args: Array<String>) {
    var bjSecretary: Secretary = Secretary("张")

    var shSecretary: SHS = SHS("李")
}
```
