package mm.learn.kotlin._004_package.beijing

import mm.learn.kotlin._004_package.shanghai.Secretary as SHS

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/23
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {
    var bjSecretary: Secretary = Secretary("张")

//    var shSecretary: mm.learn.kotlin._004_package.shanghai.Secretary = mm.learn.kotlin._004_package.shanghai.Secretary("李")
    var shSecretary: SHS = SHS("李")
}