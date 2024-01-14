module com.example.programmingtechnologyprototip {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.programmingtechnologyprototip to javafx.fxml;
    exports com.example.programmingtechnologyprototip;
}