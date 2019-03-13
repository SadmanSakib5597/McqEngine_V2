package account;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;

public class User implements Serializable {
    public String firstName;
    public String lastName;
    public String userID;
    public String password;


    public User() throws IOException {

        firstName = null;
        lastName = null;
        userID = null;
        password = null;


    }
}
