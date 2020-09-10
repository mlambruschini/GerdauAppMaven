module com.eurystic {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;

    opens com.eurystic.Controllers to javafx.fxml;
    opens com.eurystic to java.graphics;
    exports com.eurystic;
}