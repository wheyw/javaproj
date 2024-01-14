package services;

import model.Shape;
import services.infrastructure.IRepository;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShapeRepository implements IRepository<Shape> {
    private ArrayDeque<Shape> shapes;

    public ShapeRepository(){
        this.shapes = new ArrayDeque<Shape>();
    }

    public void addShape(Shape shape){
        this.shapes.push(shape);
    }

    @Override
    public void addLastShape(Shape shape) {
        this.shapes.addLast(shape);
    }

    public void popShape(){
        this.shapes.pop();
    }

    public Deque<Shape> getShapes(){
        return this.shapes;
    }

    public void clearRepository(){ shapes = new ArrayDeque<>();}

}
