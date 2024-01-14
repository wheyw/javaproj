package services;

import factory.ShapeFactory;
import model.Shape;
import javafx.scene.paint.Color;
import services.infrastructure.IFileManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class FileManagerShape implements IFileManager<Shape> {
    @Override
    public void saveDataToFile(Deque<Shape> stack) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Shapes_state" + LocalDate.now() + ".txt");
             PrintStream printStream = new PrintStream(fileOutputStream)){
            for (var item: stack) {
                printStream.println(item.toString());
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Deque<Shape> loadDataFromFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {

            Deque<Shape> shapes = new ArrayDeque<>();
            ArrayList<String> items = new ArrayList<>();
            StringBuilder lines = new StringBuilder();

            int count;

            while ((count = inputStreamReader.read()) != -1){
                if ((char)count == '\n'){
                    items.add(lines.toString());
                    lines = new StringBuilder();
                }
                else lines.append((char) count);
            }
            try {
                for (var item: items) {
                    shapes.push(this.ShapeHelper(item));
                }
                return shapes;
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
        }
        return null;
    }
    private Shape ShapeHelper(String info){
        var args = info.split(" ");
        var shape =  new ShapeFactory().createShape(args[0]);

        shape.setX(Integer.parseInt(args[1])); shape.setY(Integer.parseInt(args[2]));
        shape.setColor(Color.valueOf(args[3].replace('\r',' ').trim()));

        return shape;
    }
}
