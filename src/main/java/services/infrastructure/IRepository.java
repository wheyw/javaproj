package services.infrastructure;

import java.util.Deque;

public interface IRepository<T> {

    public void addShape(T shape);
    public void popShape();

    public void addLastShape(T shape);

    public Deque<T> getShapes();

    public void clearRepository();
}
