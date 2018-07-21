package mm.learn.kotlin

/**
 * Descriptions：Kotlin 中的智能类型转换
 * <p>
 * Author：ChenME
 * Date：2018/7/21
 * Email：ibelieve1210@163.com
 */
import mm.learn.kotlin._003_TypeCastJava.Person
import mm.learn.kotlin._003_TypeCastJava.Student

fun main(args: Array<String>) {


    // 安全的类型转换
    val person: Person = Person()
    val student:Student? =person as? Student
    println(student)



    // 智能类型转换
//    val person: Person = Student()
//    if (person is Student) {
//        person.study()
//    }

    val aString: String? = "Hello Kotlin"
    println(aString?.length)
    if (aString is String) {
        println(aString.length)
    }
}