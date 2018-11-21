## Kotlin 集合

---

#### 1. List

```
fun main(args: Array<String>) {

    // 不可变集合，即listOf 创建出来的集合不可以新增、修改、删除元素
    val list1 = listOf("QWE","asd","ZXC")

    // 可变集合
    val list2 = mutableListOf("小明","小红","小刚")
    list2[0]="李雷"
    list2.add(0,"Lily")
    list2.removeAt(list2.size-1)
    println(list2)

    // ArrayList 集合
    val list3 = arrayListOf("Tom","Sonia","Jerry")

    // Vector，线程安全
    val list4 = Vector<String>()
    list4.add("Tom")
}
```

```
[Lily, 李雷, 小红]
```

#### 2. Set

```
fun main(args: Array<String>) {

    // 不可变
    val set1 = setOf("西施", "王昭君", "貂蝉", "杨玉环")
    println(set1)

    // 可变，本质上是 Java 中的 LinkedHashSet
    val set2 = mutableSetOf("西施", "王昭君", "貂蝉", "杨玉环")
    set2.add("猪刚鬣")
    println(set2)

    // 可变，Java 中的 HashSet
    val set3 = hashSetOf("西施", "王昭君", "貂蝉", "杨玉环")
    println(set3)

    // 可变，并且 TreeSet 中的元素必须实现 Comparable 接口
    val set4 = TreeSet<String>()
    set4.add("Z")
    set4.add("A")
    set4.add("g")
    set4.add("b")
    println(set4)
}
```

```
[西施, 王昭君, 貂蝉, 杨玉环]
[西施, 王昭君, 貂蝉, 杨玉环, 猪刚鬣]
[杨玉环, 貂蝉, 西施, 王昭君]
[A, Z, b, g]
```

#### 3. Map

1. 创建

```
fun main(args: Array<String>) {

    // 不可变
    val map1 = mapOf("CN" to "China", "EN" to "English")
    println(map1)

    // 可变，实质是 Java 中的 LinkedHashMap
    val map2 = mutableMapOf("CN" to "China", "EN" to "English")
    map2["CN"] = "中国"
    println(map2)

    // Java 中的 HashMap，线程不安全
    val map3 = hashMapOf("CN" to "China", "EN" to "English")
    map3["EN"] = "英国"
    println(map3)

    // HashTable，线程安全
    val map4 = Hashtable<String, String>()
    map4["CN"] = "中国"
    map4["EN"] = "英国"
    println(map4)
}
```

```
{CN=China, EN=English}
{CN=中国, EN=English}
{EN=英国, CN=China}
{CN=中国, EN=英国}
```

2. 遍历

```
fun main(args: Array<String>) {

    val map = mapOf("CN" to "China", "EN" to "English")

    val keys = map.keys
    keys.forEach { print("$it ,") }

    println("\n----------------------------")

    val values = map.values
    values.forEach { print("$it ,") }

    println("\n----------------------------")

    map.forEach { key, value ->
        println("key -> $key , value -> $value")
    }

    println("----------------------------")
    for ((key, value) in map) {
        println("key -> $key , value -> $value")
    }
}
```

```
CN ,EN ,
----------------------------
China ,English ,
----------------------------
key -> CN , value -> China
key -> EN , value -> English
----------------------------
key -> CN , value -> China
key -> EN , value -> English
```