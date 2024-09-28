module org.practicagui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.practicagui to javafx.fxml;
    exports org.practicagui;

    opens org.practicagui.Controller to javafx.fxml;
    exports org.practicagui.Controller;
}