package sample.ui.dashboard;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Dashboard {

    @FXML // fx:id="border_pane"
    private BorderPane border_pane; // Value injected by FXMLLoader

    @FXML
    void showAcc(MouseEvent event) {

    }

    @FXML
    void showHome(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/home/home.fxml");
    }

    @FXML
    void showInventory(MouseEvent event) {

    }

    @FXML
    void showStudents(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/student/student.fxml");
    }

}
