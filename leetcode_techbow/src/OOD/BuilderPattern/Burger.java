package OOD.BuilderPattern;

public abstract class Burger implements Item{
    /* 当Java抽象类实现某个接口后没必要实现所有的方法：因为抽象类本身是具有抽象性的，
    因此其方法也不需要进行实现因为抽象类本身是具有抽象性的，它的方法也大多不需要进行实现，只需要声明，其他实现的过程多交给继承它的子类。
    而接口本身就更为抽象的一种形式，所以如果让一个本来抽象的类去实现一个更为抽象的接口的所有方法是没有必要的，
    除非对于抽象类本身而言需要接口的一些方法来完善自身。而没有实现的其他方法完全可以交给它的派生类去实现。
     */

    // 而Java普通类实现接口后实现接口中的所有方法

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
