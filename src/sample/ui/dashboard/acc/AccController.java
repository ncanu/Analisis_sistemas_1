package sample.ui.dashboard.acc;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccController implements Initializable {

    @FXML
    private TableView<Bank> table;

    @FXML
    private TableColumn<Bank, String> number;

//    @FXML
//    private TableColumn<Bank, String> type;

    @FXML
    private TableColumn<Bank, String> bank;

    @FXML
    private TableColumn<Bank, String> balance;

    @FXML
    private JFXButton addAccount;

    @FXML
    private JFXButton editAccountButton;

    @FXML
    void addAccount(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/ui/dashboard/acc/create/createAcc.fxml"));
        Node source = (Node)  event.getSource();
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage) source.getScene().getWindow());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Cuenta Bancaria");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void getAllBanks()
    {
        try{
            APIController client = RetrofitClient.getClient().create(APIController.class);
            Call<BankResponse> call = client.getAllBanks();

            call.enqueue(new Callback<BankResponse>() {
                @Override
                public void onResponse(Call<BankResponse> call, retrofit2.Response<BankResponse> response) {


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
                        } catch (IOException | NullPointerException e) {
                            e.printStackTrace();
                        }


                    }

                }

                @Override
                public void onFailure(Call<BankResponse> call, Throwable t) {
                    System.out.println(call);
                }
            });

        }

        catch (NullPointerException e)
        {

        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        number.setCellValueFactory(new PropertyValueFactory<Bank, String>("number"));
        bank.setCellValueFactory(new PropertyValueFactory<Bank, String>("bank"));
        balance.setCellValueFactory(new PropertyValueFactory<Bank, String>("balance"));

        getAllBanks();
    }
}
