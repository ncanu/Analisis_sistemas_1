package sample.ui.dashboard.student;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.ui.dashboard.DynamicView;
import sample.ui.dashboard.student.response.CourseResponse;
import sample.ui.dashboard.student.response.StudentResponse;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Student implements Initializable {

    @FXML
    private JFXComboBox<CourseResponse> course_combobox;

    @FXML
    private TableView<StudentResponse> table;

    @FXML private TableColumn<StudentResponse, String> carnet;
    @FXML private TableColumn<StudentResponse, String> name;
    @FXML private TableColumn<StudentResponse, String> lastName;


    public Student()
    {


    }

    public void initialize(URL location,
                    ResourceBundle resources)
    {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(1L);
        courseResponse.setName("Metodos numericos");
        courseResponse.setSection("A");
        course_combobox.getItems().add(courseResponse);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName("Luis");
        studentResponse.setLastName("Blanco");
        studentResponse.setId(1L);
        studentResponse.setCarnet("0901-15-13765");
        studentResponseList.add(studentResponse);

        carnet.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("carnet"));
        name.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("lastName"));

        table.getItems().setAll(studentResponseList);



    }

    @FXML
    void addStudent(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/ui/dashboard/student/create/createStudent.fxml"));
        Node source = (Node)  event.getSource();
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage) source.getScene().getWindow());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Estudiante");
        stage.setScene(new Scene(root1));
        stage.show();


    }


}
