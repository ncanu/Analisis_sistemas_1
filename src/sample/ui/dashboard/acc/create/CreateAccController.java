package sample.ui.dashboard.acc.create;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateAccController implements Initializable {

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXComboBox<String> bank;

    @FXML
    void save(MouseEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> bankItems = new ArrayList<>();
        bankItems.add("Banco Industrial");
        bankItems.add("Banco G&T");
        bankItems.add("Banrural");
        bankItems.add("BAM");
        bankItems.add("BAC-REFORMADOR");
        bankItems.add("BAC-CREDOMATIC");

        bank.getItems().addAll(bankItems);
    }
}
