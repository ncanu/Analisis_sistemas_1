package sample.ui.dashboard.courses;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CoursesController {


    @FXML
    private JFXButton addStudentButton;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> lastName;

    @FXML
    void createProfessor(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/ui/dashboard/courses/create/createProfessor.fxml"));
        Node source = (Node)  event.getSource();
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage) source.getScene().getWindow());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Catedratico");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
