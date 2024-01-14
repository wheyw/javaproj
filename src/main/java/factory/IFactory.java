package Factory;

import Model.Shape;

public interface IFactory {
    Shape createShape(String name);
}
