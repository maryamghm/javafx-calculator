module dci.javafx.javafxcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens dci.javafx.javafxcalculator to javafx.fxml;
    exports dci.javafx.javafxcalculator;
}