package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(){
        super(20,20);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(super.getColor());
        graphicsContext.fillOval(super.getX(),super.getY(),this.getSize(),this.getSize());
    }

    @Override
    public String toString() {
        return "Круг";
    }

    @Override
    public void setXY(int x, int y) {
        super.setX(x); super.setY(y);
    }
}
