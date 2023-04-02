package OOD.Singleton;

public class Singleton2 {
    /*
    懒汉式，线程安全
    具备lazy loading，支持多线程，但效率低
    优点：第一次调用才初始化，避免内存浪费
    缺点：必须加锁 synchronized才能保证单例，但加锁会影响效率
    因此，当getInstance()的性能对程序不是很重要时，可以使用。也就是当getInstance()的调用不是很频繁
     */
    private static Singleton2 instance;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
