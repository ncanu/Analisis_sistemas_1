package sample;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import retrofit2.Call;
import retrofit2.Callback;
import sample.network.APIController;
import sample.network.RetrofitClient;
import sample.ui.login.LoginRequest;
import sample.ui.login.LoginResponse;
import javafx.scene.control.Label;

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
    void login(ActionEvent event) {
        String userName = user_textfield.getText();
        String password = password_textfield.getText();
        getToken(userName,password);
    }

    public void getToken(final String email, final String password)
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
                            System.out.println("Success!!");
                        }
                        else
                        {
                            System.out.println("Sorry!!");
                            error_label.setVisible(true);

                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

            }

            catch (NullPointerException e)
            {

            }

    }

}
