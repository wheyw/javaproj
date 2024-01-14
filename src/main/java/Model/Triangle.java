package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    private final double length;
    private final double angle;
    //Треугольник
    public Triangle(){
        super(20,20, Color.ALICEBLUE);
        angle = 2 * Math.sqrt(3);
        length = 40;
    }
    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(super.getColor());
        context.fillPolygon(new double[]{super.getX() + length /2, getX() -  length / 2, getX()}
                ,new double[]{super.getY() + length / angle ,getY() + length / angle,getY() - length / angle},3);
    }

    @Override
    public String toString(){
        return "Треугольник " + super.getX() + " " + super.getY() + " " + super.getColor().toString();
    }
}