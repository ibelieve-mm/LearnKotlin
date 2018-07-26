package mm.learn.kotlin._001_class

/**
 * Descriptions：Kotlin 类与对象
 * <p>
 * Author：ChenME
 * Date：2018/7/20
 * Email：ibelieve1210@163.com
 */

//class Person {
//
//    var gender = 0
//        get() {
//            println("getter 方法")
//            return field
//        }
//        set(value) {
//            println("setter 方法")
//            field = value
//        }
//
//    var height = 175
//        protected set(value) {
//            println("setter 方法")
//            field = value
//        }
//
//    var name = ""
//        private set
//
//    var job = null
//}

class Job

class Person {

    var gender = 0
    var height = 0
    lateinit var name: String
    lateinit var job: Job
    val jobSub: Job by lazy {
        println("XXXXXX")
        Job()
    }
}

fun main(args: Array<String>) {
}