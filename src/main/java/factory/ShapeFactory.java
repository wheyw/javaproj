package factory;

import model.Circle;
import model.Triangle;
import model.Shape;
import model.Square;

public class ShapeFactory implements IFactory{
    @Override
    public Shape createShape(String name) {
        return switch (name) {
            case "Круг" -> new Circle();
            case "Квадрат" -> new Square();
            case "Треугольник" -> new Triangle();
            default -> null;
        };
    }
}