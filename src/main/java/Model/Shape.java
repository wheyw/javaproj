package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final int x;
    private final int y;
    private final Color color;

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
    public abstract void drawShape(GraphicsContext context);

}