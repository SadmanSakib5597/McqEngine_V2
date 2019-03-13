package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import questionEngine.Question;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayQuizController implements Initializable {

    @FXML
    AnchorPane rootPane;
    @FXML
    ComboBox subjectList;
    @FXML
    Button ok;
    @FXML
    Label subjectName;
    @FXML
    Label numOfQuestion;
    @FXML
    Label numberOfOption;
    @FXML
    Slider complexity;
    @FXML
    Button playQuiz;

    File[] listOfFiles = null;
    List<String> listOfSubjectName = new ArrayList<String>();
    ObservableList obList = FXCollections.observableList(listOfSubjectName);
    Question question;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        File folder = new File("src/resource/questionList/");
        listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                listOfSubjectName.add(file.getName());
            }
        }

        subjectList.getItems().clear();
        subjectList.setItems(obList);

    }

    public void ok(ActionEvent event)
    {
        try {
            String selectedSubject = subjectList.getSelectionModel().getSelectedItem().toString();

            for(File file: listOfFiles)
            {
                if(file.getName().equals(selectedSubject))
                {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

                     question = (Question)objectInputStream.readObject();

                     subjectName.setText(question.subject);
                     numOfQuestion.setText(question.numberOfQuestion+"");
                     numberOfOption.setText(question.numberOfOption+"");

                    break;
                }
            }

        }catch(Exception e){}

    }

    public void setPlayQuiz(ActionEvent event) throws IOException {
        if(question!=null)
        {

            PlayerController.question = question;
            Parent root = FXMLLoader.load(getClass().getResource("/ui/player.fxml"));
            Scene scene = new Scene(root);
            Stage currWindow = (Stage)rootPane.getScene().getWindow();
            currWindow.setScene(scene);


        }
    }
}
