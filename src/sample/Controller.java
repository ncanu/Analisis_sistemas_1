package sample;

import com.jfoenix.controls.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import sample.network.APIController;
import sample.network.RetrofitClient;
import sample.ui.login.LoginRequest;
import sample.ui.login.LoginResponse;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {

    @FXML
    private JFXTextField user_textfield;

    @FXML
    private JFXPasswordField password_textfield;

    @FXML
    private JFXButton login_button;

    @FXML
    private Label error_label;

    @FXML
    private JFXSpinner spinner;

    @FXML
    void login(ActionEvent event) {
        spinner.setVisible(true);
        error_label.setVisible(false);
        String userName = user_textfield.getText();
        String password = password_textfield.getText();
        getToken(userName,password, event);
    }

    public void getToken(final String email, final String password, ActionEvent event)
    {
        LoginRequest tokenRequest = new LoginRequest();
        tokenRequest.setEmail(email);
        tokenRequest.setPassword(password);

            try{
                APIController client = RetrofitClient.setClient("").create(APIController.class);
                Call<LoginResponse> call = client.login(tokenRequest);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {


                        if(response.isSuccessful())
                        {
                            Platform.runLater(
                                    () -> {
                                        // Update UI here.
                                        RetrofitClient.setClient("Bearer "+response.body().getData().getToken());
                                        replaceFXML(event);
                                    }
                            );
                        }
                        else
                        {
                            spinner.setVisible(false);
                            error_label.setVisible(true);
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        spinner.setVisible(false);
                    }
                });

            }

            catch (NullPointerException e)
            {
                spinner.setVisible(false);
            }


    }

    public void replaceFXML(ActionEvent event)
    {
        try {
            Parent dashboard = FXMLLoader.load(getClass().getResource("/sample/ui/dashboard/dashboard.fxml"));
            Scene scene = new Scene(dashboard);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
