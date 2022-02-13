package uet.oop.bomberman.Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Controller instance;
    @FXML
    public AnchorPane root;

    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        switchTab("MenuTab");
    }

    public static Controller getInstance() {
        //if (instance == null) instance = new Controller();
        return instance;
    }

    public void switchTab(String tabId) {
       // System.out.println(tabId);
        for (Node node : root.getChildren()) {
            if (node.getId() != null && node.getId().equals(tabId))
                node.visibleProperty().set(true);
            else node.visibleProperty().set(false);
        }

    }


}
