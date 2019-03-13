package questionEngine;

import java.io.Serializable;
import java.util.ArrayList;

public class Option implements Serializable {
    public ArrayList<String> option;

    public Option()
    {
        option = new ArrayList<String>();
    }
}
