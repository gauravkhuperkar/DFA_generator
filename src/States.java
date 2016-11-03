import java.util.ArrayList;

public class States {
    private ArrayList states;

    public States(ArrayList states) {
        this.states = states;
    }

    public boolean contains(String state) {
        return states.contains(state);
    }

    public boolean containsAnyOf(ArrayList<String> states) {
        for (String state: states) {
            if (this.contains(state))
                return true;
        }
        return false;
    }
}
