package OOD.Singleton;

public class Singleton1 {
    /*
        懒汉式，线程不安全
        不支持多线程，没有加锁
     */
    private static Singleton1 instance;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
