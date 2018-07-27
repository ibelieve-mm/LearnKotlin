package mm.learn.kotlin._007_function;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/27
 * Email：ibelieve1210@163.com
 */
public class _007_4_FunctionOverloadingJava {

    public static void main(String[] args){
        FunctionOverloading fo = new FunctionOverloading();
        fo.printComplex(); // 0.0 + 0.0i
        fo.printComplex(1.0); // 1.0 + 0.0i
        fo.printComplex(0,2.0); // 0.0 + 2.0i
        fo.printComplex(1.0,2.0); // 1.0 + 2.0i
    }
}
