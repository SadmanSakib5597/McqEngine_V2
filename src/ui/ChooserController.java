package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooserController {

    @FXML
    AnchorPane rootPane;


    public void createQuiz(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ui/quizCreator.fxml"));
        Scene scene = new Scene(root);
        Stage currWindow = (Stage)rootPane.getScene().getWindow();
        currWindow.setScene(scene);

    }

    public void playQuiz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/playQuiz.fxml"));
        Scene scene = new Scene(root);
        Stage currWindow = (Stage)rootPane.getScene().getWindow();
        currWindow.setScene(scene);

    }

}
