module com.assign6.assignment6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assign6.assignment6 to javafx.fxml;
    exports com.assign6.assignment6;
}