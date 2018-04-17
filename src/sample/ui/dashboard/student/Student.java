package sample.ui.dashboard.student;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ui.dashboard.student.response.CourseResponse;
import sample.ui.dashboard.student.response.StudentResponse;

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


}
