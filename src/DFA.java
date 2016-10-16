import java.util.ArrayList;
import java.util.HashMap;

public class DFA {
    private ArrayList<String> sigma;
    private ArrayList<String> states;
    private String initialState;
    private ArrayList<String> finalStates;
    private HashMap delta;

    public DFA(DFAEquation equation) {
        this.sigma = equation.sigma;
        this.states = equation.states;
        this.initialState = equation.initialState;
        this.finalStates = equation.finalStates;
        this.delta = equation.delta;
    }

    public Boolean canRecognize(String string) {
        int length = string.length();
        String current_state = initialState;
        for (int i = 0; i < length; i++) {
            HashMap path = (HashMap) delta.get(current_state);
            current_state = (String) path.get((string.split(""))[i]);
        }
        return finalStates.contains(current_state);
    }
}
