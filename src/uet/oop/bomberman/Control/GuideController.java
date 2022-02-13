package uet.oop.bomberman.Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GuideController implements Initializable {
    @FXML
    public TextArea guideTextArea;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            File dic = new File("src/FXML/GuideText");
            Scanner scanner = new Scanner(dic);
            String text = "";
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                text = text + word + "\n";
            }
            scanner.close();
            guideTextArea.setText(text);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void backButton(ActionEvent e) {
        Controller.getInstance().switchTab("MenuTab");
    }


}