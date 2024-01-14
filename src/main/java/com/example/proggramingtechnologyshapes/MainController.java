package com.example.proggramingtechnologyshapes;

import Factory.ShapeFactory;
import Model.Shape;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable  {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public TextField sizeNumber;
    public Label infoShape;
    public TextField nameShape;
    private Shape shape;
    private GraphicsContext context;
    private ShapeFactory factory;

    private static void initializeHandlers(MainController controller){
        controller.sheet.setOnMouseClicked(controller::canvasClickHandler);
    }

    private void canvasClickHandler(MouseEvent event){
        double x = event.getX(); double y = event.getY();

        shape = factory.createShape(nameShape.getText());

        if (shape == null) {
            this.displayWarning();
            return;
        }

        shape.setColor(this.colorPicker.getValue());
        shape.setX((int)x); shape.setY((int)y);
        shape.drawShape(context);
    }
//    @FXML
//    public void ClickMouse(MouseEvent mouseEvent) {
//        GraphicsContext context = this.sheet.getGraphicsContext2D();
//
//        double x = mouseEvent.getX();
//        double y = mouseEvent.getY();
//
//        MouseButton but = mouseEvent.getButton();
//
//        if (sizeNumber.getText().isEmpty()) {
//            System.out.println("ОШИБКА: Размер не указан");
//            return;
//        }
//
//        var size = Double.parseDouble(this.sizeNumber.getText());
//
//        if (but == MouseButton.PRIMARY){
//
//            shape = new Square((int)x, (int)y,this.colorPicker.getValue(), size);
//            infoShape.setText("" + shape);
//            shape.drawShape(context);
//        }
//        else {
//            shape = new Circle((int)x,(int)y,this.colorPicker.getValue(), Double.valueOf(this.sizeNumber.getText()),30.);
//            infoShape.setText(shape.toString());
//            shape.drawShape(context);
//        }
//    }

    private void displayWarning(){
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Ошибка");
        alert.setContentText("Такой фигуры не существует");
        alert.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        context = this.sheet.getGraphicsContext2D();
        factory = new ShapeFactory();

        MainController.initializeHandlers(this);
    }
}