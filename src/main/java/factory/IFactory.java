package factory;

import model.Shape;

public interface IFactory {
    Shape createShape(String name);
}
