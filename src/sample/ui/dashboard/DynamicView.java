package sample.ui.dashboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DynamicView {

    private DynamicView()
    {

    }

    public static void loadBorderCenter(BorderPane borderPane, String resource) throws IOException
    {
        Parent dashboard = FXMLLoader.load(new DynamicView().getClass().getResource(resource));
        borderPane.setCenter(dashboard);
    }

}
