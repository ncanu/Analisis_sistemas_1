package sample.ui.dashboard.inventory;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.ui.dashboard.inventory.response.Inventory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {


    @FXML
    private JFXListView<Inventory> list;

    ObservableList<Inventory> myItems = FXCollections.observableArrayList();

    @FXML
    private JFXTextField productName;

    @FXML
    private JFXTextField code;

    @FXML
    private JFXTextField existence;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(myItems);

        List<Inventory> inventories = new ArrayList<>();
        Inventory inventory = new Inventory();
        inventory.setCode("A456");
        inventory.setExistence(800L);
        inventory.setName("Lapiz Bolic");
        inventory.setId(1L);
        inventories.add(inventory);

        Inventory inventory2 = new Inventory();
        inventory2.setCode("A458");
        inventory2.setExistence(25L);
        inventory2.setName("Pizarron");
        inventory2.setId(25L);
        inventories.add(inventory2);

        myItems.addAll(inventories);

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Inventory>() {
            @Override
            public void changed(ObservableValue<? extends Inventory> observable, Inventory oldValue, Inventory newValue) {
                productName.setText(newValue.getName());
                code.setText(newValue.getCode());
                existence.setText(String.valueOf(newValue.getExistence()));
            }
        });
    }
}
