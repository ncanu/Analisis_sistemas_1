package sample.ui.dashboard.courses;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
}
