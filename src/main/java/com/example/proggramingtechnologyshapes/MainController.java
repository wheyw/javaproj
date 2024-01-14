package com.example.proggramingtechnologyshapes;

import Model.Circle;
import Model.Shape;
import Model.Square;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MainController {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public TextField sizeNumber;
    public Label infoShape;
    private Shape shape;
    @FXML
    public void ButtonCircleAction() {
        GraphicsContext context = this.sheet.getGraphicsContext2D();

        shape = new Circle(50,50,this.colorPicker.getValue(), Double.valueOf(this.sizeNumber.getText()),30.);
        shape.drawShape(context);
    }

    @FXML
    public void ButtonSquareAction() {
        GraphicsContext context = this.sheet.getGraphicsContext2D();

        try {
            shape = new Square(20, 20,this.colorPicker.getValue(), Double.parseDouble(this.sizeNumber.getText()));
            System.out.println(shape);
            shape.drawShape(context);
        }
        catch (Exception ex){
            System.out.println("" + ex);
        }
    }

    @FXML
    public void ClickMouse(MouseEvent mouseEvent) {
        GraphicsContext context = this.sheet.getGraphicsContext2D();

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        MouseButton but = mouseEvent.getButton();

        if (sizeNumber.getText().isEmpty()) {
            System.out.println("ОШИБКА: Размер не указан");
            return;
        }

        var size = Double.parseDouble(this.sizeNumber.getText());

        if (but == MouseButton.PRIMARY){

            shape = new Square((int)x, (int)y,this.colorPicker.getValue(), size);
            infoShape.setText("" + shape);
            shape.drawShape(context);
        }
        else {
            shape = new Circle((int)x,(int)y,this.colorPicker.getValue(), Double.valueOf(this.sizeNumber.getText()),30.);
            infoShape.setText(shape.toString());
            shape.drawShape(context);
        }
    }
}