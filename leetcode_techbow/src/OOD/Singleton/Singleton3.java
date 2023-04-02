package OOD.Singleton;

public class Singleton3 {

    /*
        没有lazy loading，但线程安全
        常用，但容易产生垃圾对象
        优点： 没有加锁，执行效率高
        缺点： 类加载时就初始化，浪费内存
        基于classloader机制避免多线程同步问题，但instance在类装载时就实例化，没有做到lazy loading
     */
    private static Singleton3 instance = new Singleton3();
        private Singleton3(){}
        public static Singleton3 getInstance(){
            return instance;
        }
}
