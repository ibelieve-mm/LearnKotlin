package mm.learn.kotlin

/**
 * Descriptions：Kotlin 的基本语法、简单函数、基本数据类型
 * <p>
 * Author：ChenME
 * Date：2018/7/20
 * Email：ibelieve1210@163.com
 */


fun main(args: Array<String>): Unit {

    val aBoolean: Boolean
    aBoolean = false

    var bBoolean: Boolean = true
    bBoolean = false

    val aInt: Int = 8
    val bInt: Int = 0xff // 255 十六进制
    val cInt: Int = 0b00000011 // 3 二进制
    val maxInt: Int = Int.MAX_VALUE // 2147483647，即 2^31-1
    val minInt: Int = Int.MIN_VALUE // -2147483648，即 -2^31

    val aLong: Long = 1L // 必须是大写的 L ，显示声明时可省略
    val bLong: Long = 2
    val maxLong: Long = Long.MAX_VALUE // 9223372036854775807，即 2^63-1
    val minLong: Long = Long.MIN_VALUE // -9223372036854775808，即 -2^63

    val aFloat: Float = 2.0f // 必须在后面加 f/F
    val bFloat: Float = 2e1f // 或者是 1E2F
    val maxFloat: Float = Float.MAX_VALUE // 3.4028235E38
    val minFloat: Float = Float.MIN_VALUE // 1.4E-45 ，最小的非零的正数
    val minFloat2: Float = -Float.MAX_VALUE // -3.4028235E38 ，Float 真正的最小值

    // Float 的三个特殊值
    val posFloat: Float = Float.POSITIVE_INFINITY // Infinity 正无穷
    val negFloat: Float = Float.NEGATIVE_INFINITY // -Infinity 负无穷
    val nanFloat: Float = Float.NaN // NaN 不是数

    val posFloat2: Float = 1.0f / 0.0f // 结果为 posFloat
    val nanFloat2: Float = 0.0f / 0.0f // 结果为 NaN

    val posBoolean: Boolean = posFloat == posFloat2 // true
    val nanBoolean: Boolean = nanFloat == nanFloat2 // false

    val posBoolean2: Boolean = posFloat === posFloat2 // true
    val nanBoolean2: Boolean = nanFloat === nanFloat2 // false

    val aDouble: Double = 3.0
    val maxDouble: Double = Double.MAX_VALUE // 1.7976931348623157E308
    val minDouble: Double = Double.MIN_VALUE // 4.9E-324 ，最小的非零的正数
    val minDouble2: Double = -Double.MAX_VALUE // -1.7976931348623157E308 ，Double 真正的最小值

    val aShort: Short = 1
    val maxShort: Short = Short.MAX_VALUE // 32767 ，即 2^15-1
    val minShort: Short = Short.MIN_VALUE // -32768 ，即 -2^15

    val aByte: Byte = 1
    val maxByte: Byte = Byte.MAX_VALUE // 127 ，即 2^7-1
    val minByte: Byte = Byte.MIN_VALUE // -128 ，即 -2^7

    val aChar: Char = '0'
    val bChar: Char = 'a'
    val cChar: Char = '\n'
    val dChar: Char = '中'
    val eChar: Char = '\u234f' // ⍏

    val anInt: Int = 10
    val anLong: Long = anInt.toLong()

    val aString: String = "Hello Kotlin"
    val fromCharArray: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', ' ', 'K', 'o', 't', 'l', 'i', 'n')) // Hello Kotlin

    val equalsBoolean: Boolean = aString == fromCharArray // true ，在 kotlin 中，== 相当于 Java 中的 equals() 方法
    val equalsBoolean2: Boolean = aString === fromCharArray // false ，在 kotlin 中，=== 相当于 Java 中的 == ，比较两个对象的引用

    val numInt1: Int = 1
    val numInt2: Int = 2
    val resultString: String = "" + numInt1 + " + " + numInt2 + " = " + (numInt1 + numInt2) // 1 + 2 = 3
    val resultString2: String = "$numInt1 + $numInt2 = ${numInt1 + numInt2}" // 1 + 2 = 3

    val money: Int = 1000
    val moneyString: String = "$money" // 1000
    val moneyString2: String = "$$money" // $1000
    val moneyString3: String = "\$money" // $money

    val originalString:String = """用三个双引号可以表示原始字符串；
        反斜杠 \ 也不再表示转义了，所以 \n 也不再表示换行了，直接用回车换行；
        并且字符串模板仍然被支持，$money，由于没有办法被转义，所有只能这样写 $ money；
        """

    println(moneyString)
    println(moneyString2)
    println(moneyString3)
    println(originalString)
}