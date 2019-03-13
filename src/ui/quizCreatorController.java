package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import questionEngine.Option;
import questionEngine.Question;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class quizCreatorController implements Initializable {


    @FXML
    AnchorPane questionHolder;
    @FXML
    AnchorPane nextHolder;
    @FXML
    AnchorPane rootPane;
    @FXML
    TextField cheatCode;
    @FXML
    TextField subject;
    @FXML
    TextField numOfQus;
    @FXML
    TextField numOfOp;
    @FXML
    Label errormsg;
    @FXML
    TextField questionName;
    @FXML
    TextField option;
    @FXML
    Button addQuestion;
    @FXML
    Button addOption;
    @FXML
    Button addAnswer;
    @FXML
    TextField answer;
    @FXML
    Button next;
    @FXML
    Button save;
    @FXML
    Button cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionHolder.setVisible(false);
        save.setVisible(false);
        cancel.setVisible(false);

    }

    public void setNext(ActionEvent event)
    {
        errormsg.setText("");

        Question question = new Question();

        String tmpcCheatCode="", tmpSubject="", tmpNumOfQus="", tmpNumOfOp="";

        tmpcCheatCode = cheatCode.getText();
        tmpSubject = subject.getText();
        tmpNumOfQus = numOfQus.getText();
        tmpNumOfOp = numOfOp.getText();

        if(tmpcCheatCode.isEmpty() || tmpSubject.isEmpty() || tmpNumOfQus.isEmpty() || tmpNumOfOp.isEmpty())
            errormsg.setText("Error: Please fill all the fields!");


        else
        {
            question.cheatCode = tmpcCheatCode;
            question.subject = tmpSubject;
            question.numberOfQuestion = Integer.valueOf(tmpNumOfQus);
            question.numberOfOption = Integer.valueOf(tmpNumOfOp);

            nextHolder.setVisible(false);
            questionHolder.setVisible(true);

            errormsg.setText("");

            AtomicInteger numOfQuestion = new AtomicInteger(0);
            AtomicInteger numOfOption = new AtomicInteger(0);

            option.setDisable(true);
            addOption.setDisable(true);
            answer.setDisable(true);
            addAnswer.setDisable(true);
            next.setDisable(true);
            questionName.setPromptText("enter question name " + (numOfQuestion.get() + 1));
            option.setPromptText("enter option " + (numOfOption.get() + 1));

            addQuestion.setOnAction(e->{
                String tmpQuestion = questionName.getText();

                if(tmpQuestion.isEmpty())
                    errormsg.setText("Error: Question name Can't be empty!");

                else {
                    Option optionList = new Option();
                    addQuestion.setDisable(true);
                    question.question.add(tmpQuestion);
                    errormsg.setText("");
                    option.setDisable(false);
                    addOption.setDisable(false);

                    addOption.setOnAction(e1->{

                        String tmpOption = option.getText();
                        if(tmpOption.isEmpty())
                            errormsg.setText("Error: Option Can't be empty!");
                        else{

                            boolean is_filledOption = numOfOption.compareAndSet(question.numberOfOption, 0);
                            errormsg.setText("");
                            if(!is_filledOption) {
                                option.setText("");
                                optionList.option.add(tmpOption);
                                numOfOption.incrementAndGet();
                                option.setPromptText("enter option " + (numOfOption.get() + 1));

                                if(numOfOption.compareAndSet(question.numberOfOption, 0))
                                {
                                    option.setPromptText("enter option " + (numOfOption.get()));
                                    question.option.add(optionList);
                                    addOption.setDisable(true);
                                    answer.setDisable(false);
                                    addAnswer.setDisable(false);

                                    addAnswer.setOnAction(e2->{
                                        String tmpAnswer = answer.getText();
                                        if(tmpAnswer.isEmpty())
                                            errormsg.setText("Error: Answer Can't be empty!");
                                        else
                                            {
                                                errormsg.setText("");
                                                question.answer.add(tmpAnswer);


                                                next.setDisable(false);
                                                addAnswer.setDisable(true);
                                                next.setOnAction(e3->{
                                                    questionName.setText("");
                                                    answer.setText("");
                                                    numOfQuestion.incrementAndGet();
                                                    errormsg.setText("");
                                                    questionName.setDisable(false);
                                                    addQuestion.setDisable(false);
                                                    option.setDisable(true);
                                                    addOption.setDisable(true);
                                                    answer.setDisable(true);
                                                    addAnswer.setDisable(true);
                                                    next.setDisable(true);
                                                    questionName.setPromptText("enter question name " + (numOfQuestion.get() + 1));
                                                    option.setPromptText("enter option " + (numOfOption.get() + 1));

                                                    if(numOfQuestion.compareAndSet(question.numberOfQuestion, 0)) {

                                                        questionName.setDisable(true);
                                                        addQuestion.setDisable(true);
                                                        questionName.setPromptText("enter question name " + 0);
                                                        option.setPromptText("enter option " + (numOfOption.get() + 1));

                                                        next.setVisible(false);
                                                        save.setVisible(true);
                                                        cancel.setVisible(true);

                                                        save.setOnAction(e4->{
                                                            try {
                                                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/resource/questionList/" + question.subject));
                                                                objectOutputStream.writeObject(question);
                                                            } catch (IOException e5) {
                                                                e5.printStackTrace();
                                                            }
                                                            save.setText("Saved");
                                                            save.setDisable(true);
                                                            cancel.setText("Back");

                                                        });

                                                        cancel.setOnAction(e5->{
                                                            Parent root = null;
                                                            try {
                                                                root = FXMLLoader.load(getClass().getResource("/ui/chooser.fxml"));
                                                            } catch (IOException e4) {
                                                                e4.printStackTrace();
                                                            }
                                                            Scene scene = new Scene(root);
                                                            Stage currWindow = (Stage)rootPane.getScene().getWindow();
                                                            currWindow.setScene(scene);
                                                        });




                                                        /*try{
                                                            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/resource/questionList/" + question.subject));

                                                            Question q = (Question)objectInputStream.readObject();

                                                            System.out.println("Cheat Code: " + q.cheatCode);
                                                            System.out.println("Subject: " + q.subject);
                                                            System.out.println("Number of question: " + q.numberOfQuestion);
                                                            System.out.println("Number of option: " + q.numberOfOption);

                                                            for (int i = 0; i < q.numberOfQuestion; i++) {
                                                                System.out.println((i + 1) + ". " + q.question.get(i) + " ?");
                                                                Option op = q.option.get(i);

                                                                int a = 97;
                                                                for (String s : op.option) {
                                                                    System.out.println("    " + ((char) a) + ". " + s);
                                                                    a++;
                                                                }

                                                                System.out.println("#ANSWER: " + q.answer.get(i));

                                                            }

                                                        }catch(Exception e4)
                                                        {

                                                        }*/
                                                    }

                                                });

                                            }

                                        });
                                }
                            }

                        }
                    });
                }
            });



        }


    }

}
