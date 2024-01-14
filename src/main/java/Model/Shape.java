package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private int x;
    private int y;
    private Color color;

    public Shape(int x, int y, Color color){
        this.x = x; this.y = y; this.color = color;
    }

    protected int getX(){
        return this.x;
    }

    protected int getY(){
        return this.y;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public abstract void drawShape(GraphicsContext context);

}