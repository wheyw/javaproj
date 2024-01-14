package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape{
    private final double side;

    public Square(int x, int y, Color color, double side){
        super(x,y,color); this.side = side;
    }

    public Square(){
        super(20,20,Color.AQUA); this.side = 20.0;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(super.getX(),super.getY(),this.side, this.side);
    }

    @Override
    public String toString(){
        return "Квадрат " + super.getX() + " " + super.getY() + " " + super.getColor().toString();
    }
}