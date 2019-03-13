package questionEngine;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    public String cheatCode;
    public String subject;
    public int numberOfQuestion;
    public int numberOfOption;
    public ArrayList<String> question;
    public ArrayList<Option> option;
    public ArrayList<String> answer;

    public Question()
    {
        cheatCode = "";
        subject = "";
        numberOfQuestion = 0;
        numberOfOption = 0;
        question = new ArrayList<String>();
        option = new ArrayList<Option>();
        answer = new ArrayList<String>();
    }

}
