module com.example.assign2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    opens com.example.assign2 to javafx.fxml, com.google.gson;
    exports com.example.assign2;
}