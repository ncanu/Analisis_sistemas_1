package sample.ui.dashboard.courses;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import sample.network.APIController;
import sample.network.RetrofitClient;
import sample.ui.dashboard.student.response.CourseResponse;
import sample.ui.dashboard.student.response.StudentCompleteResponse;
import sample.ui.dashboard.student.response.StudentResponse;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {


    @FXML
    private JFXButton addStudentButton;

    @FXML
    private TableView<StudentResponse> table;

    @FXML
    private TableColumn<StudentResponse, String> code;

    @FXML
    private TableColumn<StudentResponse, String> name;

    @FXML
    private TableColumn<StudentResponse, String> lastName;



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



    public void initialize(URL location,
                           ResourceBundle resources)
    {
        code.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("carnet"));
        name.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<StudentResponse, String>("lastName"));
        getAllUsers();
    }







    public void getAllUsers()
    {
        try{
            APIController client = RetrofitClient.getClient().create(APIController.class);
            Call<StudentCompleteResponse> call = client.getAllUsers();

            call.enqueue(new Callback<StudentCompleteResponse>() {
                @Override
                public void onResponse(Call<StudentCompleteResponse> call, retrofit2.Response<StudentCompleteResponse> response) {


                    if(response.isSuccessful())
                    {
                        Platform.runLater(
                                () -> {
                                    // Update UI here.

                                    table.getItems().setAll(response.body().getData());

                                }
                        );
                    }
                    else
                    {
                        JSONObject jObjError = null;
                        try {
                            jObjError = new JSONObject(response.errorBody().string());
                            System.out.println(jObjError.getString("message"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }

                @Override
                public void onFailure(Call<StudentCompleteResponse> call, Throwable t) {
                    System.out.println(call);
                }
            });

        }

        catch (NullPointerException e)
        {

        }


    }
}
