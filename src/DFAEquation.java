import java.util.ArrayList;
import java.util.HashMap;

public class DFAEquation {
    public ArrayList<String> sigma;
    public ArrayList<String> states;
    public String initialState;
    public ArrayList<String> finalStates;
    public HashMap delta;

    public DFAEquation(ArrayList<String> sigma, ArrayList<String> states, String initialState, ArrayList<String> final_states, HashMap delta) {
        this.sigma = sigma;
        this.states = states;
        this.initialState = initialState;
        this.finalStates = final_states;
        this.delta = delta;
    }
}
