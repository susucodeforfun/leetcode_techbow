单例模式是最常见的设计模式之一。 
对于任何时刻，如果某个类只存在且最多存在一个具体的实例，那么我们称这种模式为单例。
target: 设计一个getInstance方法，对于给定的类，每次调用getInstance时，都能得到同一个实例
example：在java中， A a = A.getInstance(); A b = A.getInstance();  a应该等于b


follow up: 并发调用getInstance,程序也应该正确执行
solution：在getInstance()方法中使用同步锁synchronized(Singleton.class)，
防止多线程同时进入造成instance被多次实例化
