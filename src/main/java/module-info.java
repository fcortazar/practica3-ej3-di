module com.di.practica33 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.di.practica33 to javafx.fxml;
    exports com.di.practica33;
}