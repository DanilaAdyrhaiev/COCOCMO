module org.nau.cococmo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens org.nau.cococmo to javafx.fxml;
    exports org.nau.cococmo;
}