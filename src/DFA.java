import java.util.ArrayList;
import java.util.HashMap;

public class DFA {
    private ArrayList<String> sigma;
    private ArrayList<String> states;
    private String initialState;
    private States finalStates;
    private HashMap delta;

    public DFA(ArrayList<String> sigma, ArrayList<String> states, String initialState, States finalStates, HashMap delta) {
        this.sigma = sigma;
        this.states = states;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.delta = delta;
    }

    public Boolean canRecognize(String string) {
        int length = string.length();
        String currentState = initialState;
        for (int i = 0; i < length; i++) {
            HashMap path = (HashMap) delta.get(currentState);
            System.out.println("path" + path);
            currentState = (String) path.get((string.split(""))[i]);
            System.out.println(currentState);
        }
        return this.finalStates.contains(currentState);
    }
}
