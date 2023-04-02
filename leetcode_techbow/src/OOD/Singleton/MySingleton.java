package OOD.Singleton;

public class MySingleton {
    /*
        Double-checked locking
        双重校验锁
        支持lazy loading 支持多线程
     */
    private static volatile MySingleton instance = null;//在声明一个可能被多线程同时访问的变量时，可以使用volatile修饰

    //private constructor
    private MySingleton(){}
    public static MySingleton getInstance(){
        if(instance==null){
            synchronized (MySingleton.class){
                //double check
                if(instance==null){
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}

