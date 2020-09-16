module com.eurystic {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;
    requires poi;
    requires poi.ooxml;
    requires model;
    requires anylogic.engine;

    opens com.eurystic.Controllers to javafx.fxml;
    opens com.eurystic to java.graphics;
    exports com.eurystic;
}