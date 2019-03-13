package ui;

import account.Account;
import account.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML
    AnchorPane rootPane;
    @FXML
    AnchorPane createAccountHolder;
    @FXML
    AnchorPane loginHolder;
    @FXML
    TextField loginUserID;
    @FXML
    PasswordField loginPassword;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField userID;
    @FXML
    PasswordField password;
    @FXML
    Label errormsg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createAccountHolder.setVisible(false);

    }

    public void createAccountOpener(ActionEvent event)
    {
        loginHolder.setVisible(false);
        createAccountHolder.setVisible(true);
    }

    public void loginHolderOpener(ActionEvent event)
    {
        loginHolder.setVisible(true);
        createAccountHolder.setVisible(false);
    }

    public void createAccount(ActionEvent event) throws IOException {
        errormsg.setText("");
        User user = new User();

        user.firstName = firstName.getText();
        user.lastName = lastName.getText();
        user.userID = userID.getText();
        user.password = password.getText();

        Account acc = new Account();
        boolean is_created = acc.createAccount(user);

        if(is_created)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/ui/chooser.fxml"));
            Scene scene = new Scene(root);
            Stage currWindow = (Stage)rootPane.getScene().getWindow();
            currWindow.setScene(scene);
        }

        else
            errormsg.setText("Can't create account! Try again.");


    }

    public void login(ActionEvent event) throws IOException {
        errormsg.setText("");
        String userID = "";
        String password = "";

        userID = loginUserID.getText();
        password  = loginPassword.getText();

        Account acc = new Account();
        boolean is_login = acc.login(userID, password);

        if(is_login)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/ui/chooser.fxml"));
            Scene scene = new Scene(root);
            Stage currWindow = (Stage)rootPane.getScene().getWindow();
            currWindow.setScene(scene);
        }
        else
            errormsg.setText("Wrong username or password! Try again.");


    }


}
