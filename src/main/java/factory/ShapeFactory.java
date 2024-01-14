package Factory;

import Model.Circle;
import Model.Triangle;
import Model.Shape;
import Model.Square;

import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory implements IFactory{

    Map<String, Supplier<Shape>> shapes = Map.of(
            "Круг",Circle::new,
            "Квадрат",Square::new,
            "Треугольник",Triangle::new
    );

    @Override
    public Shape createShape(String name) {
        var shape = shapes.get(name);

        if (shape == null) return null;
        return shape.get();
    }
}