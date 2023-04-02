package OOD.FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape square = shapeFactory.getShape("SQUARE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
