package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    private int x;
    private int y;
    private Color color;
    private final int size;

    public Shape(int x, int y){
        this.x = x; this.y = y;
        this.color = Color.SLATEGREY;
        this.size = 20;
    }
    public int getSize() {return this.size;}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setColor(Color color) { this.color = color; }
    public Color getColor() { return this.color; }
    public abstract void draw(GraphicsContext graphicsContext);
    public abstract String toString();
    public abstract void setXY(int x, int y);

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
