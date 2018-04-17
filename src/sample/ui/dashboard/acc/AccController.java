package sample.ui.dashboard.acc;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AccController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> number;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> bank;

    @FXML
    private TableColumn<?, ?> balance;

    @FXML
    private JFXButton addAccount;

    @FXML
    private JFXButton editAccountButton;
}
