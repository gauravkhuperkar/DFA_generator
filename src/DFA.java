import java.util.ArrayList;
import java.util.HashMap;

public class DFA {
    private String[] sigma;
    private String[] states;
    private String initial_state;
    private ArrayList<String> final_states;
    private HashMap delta;

    public DFA(DFA_eqution equation) {
        this.sigma = equation.sigma;
        this.states = equation.states;
        this.initial_state = equation.initial_state;
        this.final_states = equation.final_states;
        this.delta = equation.delta;
    }

    public Boolean canRecognize(String string) {
        int length = string.length();
        String current_state = initial_state;
        for (int i = 0; i < length; i++) {
            HashMap path = (HashMap) delta.get(current_state);
            current_state = (String) path.get((string.split(""))[i]);
        }
        return final_states.contains(current_state);
    }
}
