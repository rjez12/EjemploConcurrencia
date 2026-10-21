module com.desarrollo.ejemploconcurrenciag3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.desarrollo.ejemploconcurrenciag3 to javafx.fxml;
    exports com.desarrollo.ejemploconcurrenciag3;
}