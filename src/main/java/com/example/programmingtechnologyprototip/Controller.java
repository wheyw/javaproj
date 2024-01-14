package com.example.programmingtechnologyprototip;

import Model.Circle;
import Model.Shape;
import Model.Square;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ListView listview;

    public ObservableList<Shape> items;
    public Canvas graphicContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Square square = new Square();
        Circle circle = new Circle();

        items = FXCollections.observableArrayList(square,circle);
        listview.setItems(items);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void drawShapeOnCanvas(MouseEvent mouseEvent){
        int index = listview.getSelectionModel().getSelectedIndex();
        Shape shape;
        shape = (Shape)items.get(index).clone();
        shape.setXY((int)mouseEvent.getX(),(int)mouseEvent.getY());
        shape.draw(this.graphicContent.getGraphicsContext2D());
    }
}