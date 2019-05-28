package account;

import java.io.*;
import java.util.Scanner;

public class Account{

    public User user;

    public boolean createAccount(User user) throws IOException {

        if (user.firstName.isEmpty() || user.lastName.isEmpty() || user.password.isEmpty() || user.userID.isEmpty()) {
            return false;
        }


        try {
            File inputFile = new File("src/resource/login/loginData.txt");
            Scanner input = new Scanner(inputFile);
            String inputuserID = "";
            String inputpassword = "";

            while (input.hasNextLine()) {
                inputuserID = input.next();
                inputpassword = input.next();

                if (inputuserID.equals(user.userID)) return false;
            }


        } catch (Exception e) {
        }

        this.user = user;

        ObjectOutputStream object = null;
        try {
            object = new ObjectOutputStream(new FileOutputStream(new File("src/resource/userdata/" + user.userID + ".txt")));
            object.writeObject(user);

            object.close();
        } catch (Exception e) {
        }

        try {
            String loginData = user.userID + " " + user.password + "\n";

            OutputStream out = new FileOutputStream("src/resource/login/loginData.txt", true);
            byte[] ara = loginData.getBytes();

            for (int i = 0; i < ara.length; i++) out.write(ara[i]);

            out.close();
        } catch (Exception e) {
        }

        return true;
    }


    public boolean login(String userID, String password) {

        try {
            File inputFile = new File("src/resource/login/loginData.txt");
            Scanner input = new Scanner(inputFile);
            String inputuserID = "";
            String inputpassword = "";

            while (input.hasNextLine()) {
                inputuserID = input.next();
                inputpassword = input.next();

                if (inputuserID.equals(userID) && inputpassword.equals(password)) return true;
            }


        } catch (Exception e) {
        }

        return false;

    }

}

