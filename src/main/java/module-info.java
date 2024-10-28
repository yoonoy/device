module com.example.demomid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demomid to javafx.fxml;
    exports com.example.demomid;
}