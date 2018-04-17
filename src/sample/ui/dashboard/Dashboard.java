package sample.ui.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @FXML // fx:id="border_pane"
    private BorderPane border_pane; // Value injected by FXMLLoader

    @FXML
    void showAcc(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/acc/acc.fxml");
    }

    @FXML
    void showHome(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/home/home.fxml");
    }

    @FXML
    void showInventory(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/inventory/inventory.fxml");
    }

    @FXML
    void showStudents(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/student/student.fxml");
    }

    @FXML
    void showProfessors(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/courses/courses.fxml");
    }

    public void initialize(URL location, ResourceBundle resources)  {
        try {
            DynamicView.loadBorderCenter(border_pane, "/sample/ui/dashboard/home/home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
