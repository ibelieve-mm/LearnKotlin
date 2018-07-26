package mm.learn.kotlin._008_expression;

/**
 * Descriptions：Kotlin 各种表达式
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */
class _008_Expression {


    public static void main(String[] args) {

        final int ENVIRONMENT_DEV = 2;// 开发环境
        final int ENVIRONMENT_TEST = 1;// 测试环境
        final int ENVIRONMENT_ONLINE = 0; // 正式环境

        int projectEnvironment = ENVIRONMENT_DEV;

        final String PATH_HOST = ENVIRONMENT_ONLINE == projectEnvironment ?
                "http://api.online.com" :
                (ENVIRONMENT_TEST == projectEnvironment ?
                        "http://api.test.com" :
                        "http://api.dev.com");

        System.out.println(PATH_HOST);
    }
}