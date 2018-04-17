package sample.ui.dashboard.courses.create;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateProfessorController {

    @FXML
    private JFXButton saveButton;

    @FXML
    void save(MouseEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
