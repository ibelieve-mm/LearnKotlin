package mm.learn.kotlin._012_singleton;

/**
 * Descriptions：饿汉式单例模式
 * <p>
 * Author：ChenME
 * Date：2018/11/20
 * Email：ibelieve1210@163.com
 */
public class _012_01_SingletonByJava {

    private static _012_01_SingletonByJava mInstance = new _012_01_SingletonByJava();

    private _012_01_SingletonByJava() {
    }

    public static _012_01_SingletonByJava getInstance(){
        return mInstance;
    }
}
