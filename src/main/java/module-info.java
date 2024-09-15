module com.example.bdrcs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bdrcs to javafx.fxml;
    exports com.example.bdrcs;
}