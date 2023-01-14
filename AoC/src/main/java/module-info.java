module com.example.aoc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aoc to javafx.fxml;
    exports com.example.aoc;
}