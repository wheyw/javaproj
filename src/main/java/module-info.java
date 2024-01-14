module com.example.proggramingtechnologyshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proggramingtechnologyshapes to javafx.fxml;
    exports com.example.proggramingtechnologyshapes;
}