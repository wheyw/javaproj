package com.example.proggramingtechnologyshapes;

import factory.ShapeFactory;
import model.Shape;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.FileManagerShape;
import services.ShapeRepository;
import services.infrastructure.IFileManager;
import services.infrastructure.IRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable  {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public TextField sizeNumber;
    public Label infoShape;
    public TextField nameShape;
    private GraphicsContext context;
    private ShapeFactory factory;
    private IRepository<Shape> repository;
    private IFileManager<Shape> fileManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        context = this.sheet.getGraphicsContext2D();
        factory = new ShapeFactory();
        repository = new ShapeRepository();
        fileManager = new FileManagerShape();

        MainController.initializeHandlers(this);
    }

    private static void initializeHandlers(MainController controller){
        controller.sheet.setOnMouseClicked(controller::canvasClickHandler);
    }

    private void canvasClickHandler(MouseEvent event){
        double x = event.getX(); double y = event.getY();

        Shape shape = factory.createShape(nameShape.getText());

        if (shape == null) {
            this.displayWarning("Такой фигуры не существует");
            return;
        }

        shape.setColor(this.colorPicker.getValue());
        shape.setX((int)x); shape.setY((int)y);

        repository.addShape(shape);

        shape.drawShape(context);
    }

    private void displayWarning(String text){
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Ошибка");
        alert.setContentText(text);
        alert.showAndWait();
    }

    private void initCollection(){
        this.context.setFill(Color.ALICEBLUE);
        this.context.fillRect(0,0,sheet.getWidth(),sheet.getHeight());

        for (var item: repository.getShapes()) {
            item.drawShape(context);
        }
    }

    public void back_Button(ActionEvent actionEvent) {
        this.repository.popShape();
        initCollection();
    }

    public void clear_Button(ActionEvent actionEvent) {
        this.repository.clearRepository();
        initCollection();
    }

    public void saveFile_Button(ActionEvent actionEvent) throws FileNotFoundException {
        fileManager.saveDataToFile(this.repository.getShapes());
    }

    public void openFile_Button(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");

        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fileChooser.showOpenDialog(new Stage());

        if (file == null) return;

        repository.clearRepository();

        var temp_shape = fileManager.loadDataFromFile(file);

        if (temp_shape == null){
            displayWarning("Не распознанный файл");
            return;
        }

        for(var item : temp_shape)
            repository.addLastShape(item);

        initCollection();
    }
}