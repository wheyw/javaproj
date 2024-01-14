package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rectangle extends Shape {

    private final double length;
    private final double angle;
    //Треугольник
    public Rectangle(){
        super(20,20, Color.ALICEBLUE);
        angle = new Random().nextDouble(0,1);
        length = 10;
    }
    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(super.getColor());
        context.fillPolygon(new double[]{super.getX(),getX()+ length*Math.tan(angle), getX() -length},new double[]{super.getY(),getY() -length,getY() -(length*Math.tan(angle))},3);
    }

    @Override
    public String toString(){
        return "Треугольник с координатами x: " + super.getX() + " y: " + super.getY() + " Цвет: " + super.getColor().toString();
    }
}