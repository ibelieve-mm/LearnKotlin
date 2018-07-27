package mm.learn.kotlin._001_class

/**
 * Descriptions：类0 - 类的简单使用
 * <p>
 * Author：ChenME
 * Date：2018/7/20
 * Email：ibelieve1210@163.com
 */

//class 狗 constructor(var 毛色: String, var 身高: Int, var 叫声: String) : Any() {}


//class 狗(var 毛色: String, var 身高: Int, var 叫声: String)


//class 狗(var 毛色: String, var 身高: Int, var 叫声: String){
//    init {
//        println("创建了一条狗，毛色：$毛色，身高：$身高，叫声：$叫声")
//    }
//}
//
//class 羊(var 毛色: String, var 身高: Int, var 叫声: String) {
//    init {
//        println("创建了一只羊，毛色：$毛色，身高：$身高，叫声：$叫声")
//    }
//}


//open class 动物(var 毛色: String, var 身高: Int, var 叫声: String)
//
//class 狗(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声) {
//    init {
//        println("创建了一条狗，毛色：$毛色，身高：$身高，叫声：$叫声")
//    }
//}
//
//class 羊(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声) {
//    init {
//        println("创建了一只羊，毛色：$毛色，身高：$身高，叫声：$叫声")
//    }
//}


open class 动物(var 毛色: String, var 身高: Int, var 叫声: String) {
    init {
        println("创建了一只${this.javaClass.simpleName}，毛色：$毛色，身高：$身高，叫声：$叫声")
    }
}

class 狗(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声)
class 羊(毛色: String, 身高: Int, 叫声: String) : 动物(毛色, 身高, 叫声)

fun main(args: Array<String>) {

    var 比熊: 狗 = 狗("白色", 50, "汪汪汪")
    var 山羊: 羊 = 羊("黑色", 80, "咩咩咩")
}