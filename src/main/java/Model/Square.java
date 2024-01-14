package Model;

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape {
    public Square(){
        super(20,20);
    }
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(super.getColor());
        graphicsContext.fillRect(super.getX(),super.getY(),super.getSize(), super.getSize());
    }

    @Override
    public String toString() {
        return "Квадрат";
    }

    @Override
    public void setXY(int x, int y) {
        super.setX(x); super.setY(y);
    }
}
